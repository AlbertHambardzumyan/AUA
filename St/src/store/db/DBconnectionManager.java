// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.db;

import store.ex.DatabaseReadError;
import store.menu.MenuListItem;
import store.menu.SubMenuListItem;
import store.product.ProductItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Albert Hambardzumyan
 */
public class DBconnectionManager {
    private static DBconnectionManager ourInstance = new DBconnectionManager();

    public static DBconnectionManager getInstance() {
        return ourInstance;
    }

    private Connection conn;

    private DBconnectionManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "sesame");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getPictureList() {
        List<String> items = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("select MenuName from settedmenu JOIN menu On SettedMenuID = MenuID;");
            while (rs.next()) {
                String menuName = rs.getString("MenuName");
                items.add(menuName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(statement, rs);
        }
        return items;
    }
    public List<MenuListItem> getMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * from Menu;");
            while (rs.next()) {
                int menuId = rs.getInt("MenuID");
                String menuName = rs.getString("MenuName");
                items.add(new MenuListItem(menuId, menuName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(statement, rs);
        }
        return items;
    }

    public List<Integer> getSettedMenuListItems() {
        List<Integer> items = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT SettedMenuID from SettedMenu;");
            while (rs.next()) {
                int settedMenuId = rs.getInt("SettedMenuID");
                items.add(settedMenuId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(statement, rs);
        }
        return items;
    }

    public List<SubMenuListItem> getSubMenuListItems() {
        List<SubMenuListItem> items = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("select SubMenuId, SubMenuName, MenuName from submenu JOIN menu USING(MenuID);");
            while (rs.next()) {
                int subMenuId = rs.getInt("SubMenuID");
                String subMenuName = rs.getString("SubMenuName");
                String menuName = rs.getString("MenuName");
                items.add(new SubMenuListItem(subMenuId, subMenuName, menuName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(statement, rs);
        }
        return items;
    }

    public List<Integer> getSettedSubMenuListItems() {
        List<Integer> items = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT SettedSubMenuID from SettedSubMenu;");
            while (rs.next()) {
                int settedSubMenuId = rs.getInt("SettedSubMenuID");
                items.add(settedSubMenuId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(statement, rs);
        }
        return items;
    }

    public List<ProductItem> getProductItems() {
        List<ProductItem> items = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("select ProductID, ProductName, ProductPrice, ProductPictureUrl , SubMenuName from product JOIN submenu USING(SubMenuID);");
            while (rs.next()) {
                String productID = rs.getString("ProductID");
                String productName = rs.getString("ProductName");
                double productPrice = rs.getDouble("ProductPrice");
                String productPictureUrl = rs.getString("ProductPictureUrl");
                String subMenuName = rs.getString("SubMenuName");
                items.add(new ProductItem(productID, productName, productPrice, productPictureUrl, subMenuName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(statement, rs);
        }
        return items;
    }

    public List<String> getSettedProductItems() {
        List<String> items = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT SettedProductID from SettedProduct;");

            while (rs.next()) {
                String settedSubMenuId = rs.getString("SettedProductID");
                items.add(settedSubMenuId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(statement, rs);
        }
        return items;
    }

    public boolean isRegisteredUser(String userLogin, String userPass) throws DatabaseReadError {
        String login = userLogin.toLowerCase();
        PreparedStatement preparedStmt = null;
        ResultSet rs = null;
        try {
            /** the mysql insert statement */
            String query = "select Password from user where Email= ?";
            /** create the mysql insert preparedStatement */
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, login);

            /** execute the preparedStatement */
            rs = preparedStmt.executeQuery();
            if (rs.next()) {
                String pass = rs.getString("Password");
                return pass.equals(userPass);
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseReadError();
        } finally {
            closeAll(preparedStmt, rs);
        }
    }

    public boolean isExistsEmail(String emailAddress) throws DatabaseReadError {
        String email = emailAddress.toLowerCase();
        PreparedStatement preparedStmt = null;
        ResultSet rs = null;
        try {
            /** the mysql insert statement */
            String query = "select * from user where Email= ?";
            /** create the mysql insert preparedStatement */
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, email);

            /** execute the preparedStatement */
            rs = preparedStmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseReadError();
        } finally {
            closeAll(preparedStmt, rs);
        }
    }

    public boolean insert(String firstName, String lastName, String emailAddress, String phone, String pass1) throws DatabaseReadError {
        String email = emailAddress.toLowerCase();
        PreparedStatement preparedStmt = null;
        try {
            /** the mysql insert statement */
            String query = " insert into user (FirstName, LastName, Email, Phone, Password)"
                    + " values (?, ?, ?, ?, ?)";
            /** create the mysql insert preparedStatement */
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, firstName);
            preparedStmt.setString(2, lastName);
            preparedStmt.setString(3, email);
            preparedStmt.setString(4, phone);
            preparedStmt.setString(5, pass1);

            /** execute the preparedStatement */
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseReadError();
        } finally {
            closeAll(preparedStmt, null);
        }
    }

    private static void closeAll(Statement st, ResultSet rs) {
        if (st != null)
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
