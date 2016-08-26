// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.cart;

import store.product.ProductItem;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author Albert Hambardzumyan
 */

/**
 * Associates a ProductItem with a specific order by
 * keeping track of the number ordered and the total price.
 * Also provides some convenience methods to get at the
 * ProductItem data without extracting the ProductItem
 * separately.
 */

public class ShoppingCartItem implements Serializable{
    private ProductItem productItem;
    private int numItems;

    public ShoppingCartItem(ProductItem productItem) {
        setProductItem(productItem);
        setProductNumItems(1);
    }

    public ProductItem getProductItem() {
        return (productItem);
    }

    protected void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }

    public String getProductItemID() {
        return (getProductItem().getProductItemID());
    }

    public String getProductItemName() {
        return (getProductItem().getProductItemName());
    }


    public double getProductUnitCost() {
        return (getProductItem().getProductItemPrice());
    }

    public int getProductNumItems() {
        return (numItems);
    }

    public void setProductNumItems(int n) {
        this.numItems = n;
    }

    public void incrementProductNumItems() {
        setProductNumItems(getProductNumItems() + 1);
    }

    public void cancelOrder() {
        setProductNumItems(0);
    }

    public double getTotalCost() {
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        return Double.parseDouble(myFormatter.format(getProductNumItems() * getProductUnitCost()));
    }
}