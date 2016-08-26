// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Albert Hambardzumyan
 */

/**
 * Base class for setting product entries.
 * Servlets that extend this class must specify
 * the product entries that they are showing.
 */

public abstract class ProductItemsSetter extends HttpServlet {
    private List<ProductItem> productItems;
    private List<String> itemIDs;

    private List<ProductItem> selectedProductItem;

    /**
     * Given an list of item IDs, look them up in the
     * ProductItemsCatalog and put their corresponding ProductItem entry
     * into the productItems list. The ProductItem contains productItemName,
     * using the item ID as the unique key, productItemPrice, productItemDescription,
     * subMenuName, and productItemPictureUrl.
     * Servlets that extend ProductItemsSetter must call
     * this method (usually from init) before the servlet
     * is accessed.
     */

    protected void setItems(List<String> itemIDs) {
        this.itemIDs = itemIDs;
        productItems = new ArrayList<>();
        for (String itemID : itemIDs) {
            ProductItem temp = ProductItemsCatalog.getProductItemsCatalog(itemID);
            if (temp != null) {
                productItems.add(temp);
            }
        }
    }

    private void checkSelectedProductItem(String selectedSubMenu) {
        selectedProductItem = new ArrayList<>();
        for (ProductItem item : productItems) {
            if (item.getSubMenuName().equals(selectedSubMenu)) {
                selectedProductItem.add(item);
            }
        }
    }

    /**
     * Set in session productItems
     */

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        if (productItems == null) {
            response.sendError(response.SC_NOT_FOUND,
                    "Missing Items.");
            return;
        }
        String selectedSubMenu = request.getParameter("selectedSubMenu");
        if (selectedSubMenu == null)
            selectedSubMenu = (String) request.getSession().getAttribute("selectedSubMenu");
        checkSelectedProductItem(selectedSubMenu);
        request.getSession().setAttribute("selectedSubMenu", selectedSubMenu);

        request.getSession().setAttribute("productItems", selectedProductItem);

    }
}