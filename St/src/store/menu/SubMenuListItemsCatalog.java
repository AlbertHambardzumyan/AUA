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
 * A catalog that lists the sub menu list items available in inventory.
 */

public class SubMenuListItemsCatalog {
    private static List<SubMenuListItem> subMenuListItems;

    static {
        subMenuListItems = DBconnectionManager.getInstance().getSubMenuListItems();
    }

    public static SubMenuListItem getSubMenuListItemsCatalog(int subMenuListItemID) {
        if (subMenuListItemID != (int) subMenuListItemID || subMenuListItemID <= 0) {
            return (null);
        }
        for (SubMenuListItem subMenuListItem : subMenuListItems) {
            if (subMenuListItemID == subMenuListItem.getSubMenuListItemID()) {
                return (subMenuListItem);
            }
        }
        return (null);
    }
}
               