// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.product;

import java.io.Serializable;

/**
 * @author Albert Hambardzumyan
 */

/**
 * Describes a ProductItem for on-line store. The ProductItemID
 * uniquely identifies the product item id, the productItemName
 * gives the current per-item name, productItemPrice gives the price,
 * productItemPictureUrl gives the picture url path as a string, and
 * subMenuName whom belongs to.
 */

public class ProductItem implements Serializable {
    private String productItemID;
    private String productItemName;
    private double productItemPrice;
    private String productItemPictureUrl;
    private String subMenuName;

    public ProductItem(String productItemID, String productItemName, double productItemPrice, String productItemPictureUrl, String subMenuName) {
        setProductItemID(productItemID);
        setProductItemName(productItemName);
        setProductItemPrice(productItemPrice);
        setProductItemPictureUrl(productItemPictureUrl);
        setSubMenuName(subMenuName);
    }

    public String getProductItemID() {
        return (productItemID);
    }

    protected void setProductItemID(String productItemID) {
        this.productItemID = productItemID;
    }

    public String getProductItemName() {
        return (productItemName);
    }

    protected void setProductItemName(String productItemName) {
        this.productItemName = productItemName;
    }

    public double getProductItemPrice() {
        return (productItemPrice);
    }

    protected void setProductItemPrice(double productItemPrice) {
        this.productItemPrice = productItemPrice;
    }

    public String getProductItemPictureUrl() {
        return (productItemPictureUrl);
    }

    protected void setProductItemPictureUrl(String productItemPictureUrl) {
        this.productItemPictureUrl = productItemPictureUrl;
    }

    public String getSubMenuName() {
        return (subMenuName);
    }

    protected void setSubMenuName(String menuName) {
        this.subMenuName = menuName;
    }

}