// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.menu;

import store.db.DBconnectionManager;

import java.util.List;

/**
 * @author Albert Hambardzumyan
 */

/**
 * A catalog that lists the menu list items available in inventory.
 */

public class MenuListItemsCatalog {
    private static List<MenuListItem> menuListItems;

    static {
        menuListItems = DBconnectionManager.getInstance().getMenuListItems();
    }

    public static MenuListItem getMenuListItemsCatalog(int menuListItemID) {
        if (menuListItemID != (int) menuListItemID || menuListItemID <= 0) {
            return (null);
        }
        for (MenuListItem menuListItem : menuListItems) {
            if (menuListItemID == menuListItem.getMenuListItemID()) {
                return (menuListItem);
            }
        }
        return (null);
    }
}
               