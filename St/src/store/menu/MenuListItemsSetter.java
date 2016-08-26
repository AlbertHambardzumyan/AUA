// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Albert Hambardzumyan
 */

/**
 * Base class for setting menu entries.
 * Servlets that extend this class must specify
 * the menu entries that they are showing.
 */

public abstract class MenuListItemsSetter extends HttpServlet {
    private List<MenuListItem> menuListItems;
    private List<Integer> itemIDs;

    /**
     * Given an list of item IDs, look them up in the
     * MenuListItemsCatalog and put their corresponding MenuListItem entry
     * into the menuListItems list. The MenuListItem contains menuListItemName,
     * using the item ID as the unique key.
     * Servlets that extend CatalogPage must call
     * this method (usually from init) before the servlet
     * is accessed.
     */

    protected void setItems(List<Integer> itemIDs) {
        this.itemIDs = itemIDs;
        menuListItems = new ArrayList<>();
        for (Integer itemID : itemIDs) {
            MenuListItem temp = MenuListItemsCatalog.getMenuListItemsCatalog(itemID.intValue());
            if (temp != null) {
                menuListItems.add(temp);
            }
        }
    }


    /**
     * Set in session menuListItems
     */

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        if (menuListItems == null) {
            response.sendError(response.SC_NOT_FOUND, "Missing Items.");
            return;
        }

        request.getSession().setAttribute("menuListItems", menuListItems);
    }
}