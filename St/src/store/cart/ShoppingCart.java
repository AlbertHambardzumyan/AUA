// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.cart;

import store.product.ProductItemsCatalog;

import java.util.*;

/**
 * @author Albert Hambardzumyan
 */

/**
 * A shopping cart data structure used to track orders.
 */

public class ShoppingCart {
    private ArrayList<ShoppingCartItem> shoppingCartItems;

    /**
     * Builds an empty shopping cart.
     */

    public ShoppingCart() {
        shoppingCartItems = new ArrayList<>();
    }

    /**
     * Returns List of ItemOrder entries giving
     * ProductItem and number ordered.
     */

    public ArrayList<ShoppingCartItem> getShoppingCartItems() {
        return (shoppingCartItems);
    }

    /**
     * Looks through cart to see if it already contains
     * an order entry corresponding to product item ID. If it does,
     * increments the number ordered. If not, looks up
     * Item in catalog and adds an order entry for it.
     */

    public synchronized void addItem(String itemID) {
        ShoppingCartItem shoppingCartItem;
        for (int i = 0; i < shoppingCartItems.size(); i++) {
            shoppingCartItem = shoppingCartItems.get(i);
            if (shoppingCartItem.getProductItemID().equals(itemID)) {
                shoppingCartItem.incrementProductNumItems();
                return;
            }
        }
        ShoppingCartItem newShoppingCartItem = new ShoppingCartItem(ProductItemsCatalog.getProductItemsCatalog(itemID));
        shoppingCartItems.add(newShoppingCartItem);
    }

    /**
     * Looks through cart to find ShoppingCartItem entry corresponding
     * to item ID listed. If the designated number
     * is positive, sets it. If designated number is 0
     * (or, negative due to a user input error), deletes
     * item from cart.
     */

    public synchronized void setProductNumOrdered(String itemID,
                                                  int numOrdered) {
        ShoppingCartItem shoppingCartItem;
        for (int i = 0; i < shoppingCartItems.size(); i++) {
            shoppingCartItem = shoppingCartItems.get(i);
            if (shoppingCartItem.getProductItemID().equals(itemID)) {
                if (numOrdered <= 0) {
                    shoppingCartItems.remove(i);
                } else {
                    shoppingCartItem.setProductNumItems(numOrdered);
                }
                return;
            }
        }
        ShoppingCartItem newShoppingCartItem = new ShoppingCartItem(ProductItemsCatalog.getProductItemsCatalog(itemID));
        shoppingCartItems.add(newShoppingCartItem);
    }
}
    