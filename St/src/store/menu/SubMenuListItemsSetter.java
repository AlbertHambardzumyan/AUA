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
 * Base class for setting sub menu entries.
 * Servlets that extend this class must specify
 * the sub menu entries that they are showing.
 */

public abstract class SubMenuListItemsSetter extends HttpServlet {
    private List<SubMenuListItem> subMenuListItems;
    private List<Integer> itemIDs;

    private List<SubMenuListItem> selectedSubMenuListItems;

    /**
     * Given an list of item IDs, look them up in the
     * SubMenuListItemsCatalog and put their corresponding SubMenuListItem entry
     * into the subMenuListItems list. The SubMenuListItem contains subMenuListItemName,
     * using the item ID as the unique key.
     * Servlets that extend SubMenuListItemsSetter must call
     * this method (usually from init) before the servlet
     * is accessed.
     */

    protected void setItems(List<Integer> itemIDs) {
        this.itemIDs = itemIDs;
        subMenuListItems = new ArrayList<>();
        for (Integer itemID : itemIDs) {
            SubMenuListItem temp = SubMenuListItemsCatalog.getSubMenuListItemsCatalog(itemID.intValue());
            if (temp != null) {
                subMenuListItems.add(temp);
            }
        }
    }

    private void checkSelectedSubMenuListItems(String selectedMenu) {
        selectedSubMenuListItems = new ArrayList<>();
        for (SubMenuListItem item : subMenuListItems) {
            if (item.getMenuName().equals(selectedMenu)) {
                selectedSubMenuListItems.add(item);
            }
        }
    }

    /**
     * Set in session menuListItems
     */

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        if (subMenuListItems == null) {
            response.sendError(response.SC_NOT_FOUND,
                    "Missing Items.");
            return;
        }
        String selectedMenu = request.getParameter("selectedMenu");
        checkSelectedSubMenuListItems(selectedMenu);
        request.getSession().setAttribute("selectedMenu", selectedMenu);
        request.getSession().setAttribute("subMenuListItems", selectedSubMenuListItems);

        /**For making Products servlet run and provide by default the items of the first subMenu*/

        if (!selectedSubMenuListItems.isEmpty()) {
            String selectedSubMenu = selectedSubMenuListItems.get(0).getSubMenuListItemName();
            request.getSession().setAttribute("selectedSubMenu", selectedSubMenu);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductItemsSetup");
            dispatcher.forward(request, response);
        } else {
            request.getSession().setAttribute("selectedMenu", null);
            request.getSession().setAttribute("productItems", null);
            request.getSession().setAttribute("selectedSubMenu", null);
        }

    }
}