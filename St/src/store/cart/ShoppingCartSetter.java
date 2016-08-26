// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.cart;

import java.io.*;
import java.text.DecimalFormat;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Albert Hambardzumyan
 */

/**
 * Clients have their own session that keeps track of which
 * ShoppingCart is theirs. If this is their first visit
 * to the order page, a new shopping cart is created.
 */

public class ShoppingCartSetter extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart;
        synchronized (session) {
            shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
            /**New visitors get a fresh shopping cart.
             Previous visitors keep using their existing shoppingCart. */
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();
            }
            String itemID = request.getParameter("selectedProductItemId");
            String updatedNumberOfItem = request.getParameter("updatedNumberOfItem");
            if (updatedNumberOfItem != null && itemID != null) {
                shoppingCart.setProductNumOrdered(itemID, Integer.parseInt(updatedNumberOfItem));
            } else if (itemID != null) {
                shoppingCart.addItem(itemID);
            }
            session.setAttribute("shoppingCart", shoppingCart);
            double total = 0;
            for (ShoppingCartItem shoppingCartItem : shoppingCart.getShoppingCartItems()) {
                total += shoppingCartItem.getTotalCost();
            }
            DecimalFormat myFormatter = new DecimalFormat("0.00");
            session.setAttribute("total", myFormatter.format(total));
        }

    }
}