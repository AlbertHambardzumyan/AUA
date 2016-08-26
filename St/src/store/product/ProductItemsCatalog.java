// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.product;

import store.db.DBconnectionManager;

import java.util.List;

/**
 * @author Albert Hambardzumyan
 */

/**
 * A catalog that lists the product items available in inventory.
 */

public class ProductItemsCatalog {

    private static List<ProductItem> productItems;

    static {
        productItems = DBconnectionManager.getInstance().getProductItems();
    }

    public static ProductItem getProductItemsCatalog(String productItemID) {
        if (productItemID == null) {
            return (null);
        }
        for (ProductItem productItem : productItems) {
            if (productItemID.equals(productItem.getProductItemID())) {
                return (productItem);
            }
        }
        return (null);
    }
}
               