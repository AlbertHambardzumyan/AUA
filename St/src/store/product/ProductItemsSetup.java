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
 * A specialization of the ProductItemsSetter servlet that
 * displays a ProductItems.
 */

public class ProductItemsSetup extends ProductItemsSetter {

    public void init() {
        List<String> ids;
        ids = DBconnectionManager.getInstance().getSettedProductItems();
        setItems(ids);
        setItems(ids);
    }
}