// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.menu;

import java.io.Serializable;

/**
 * @author Albert Hambardzumyan
 */

/**
 * Describes a MenuListItem for on-line store. The menuListItemID
 * uniquely identifies the menu list item id, and the menuListItemName
 * gives the current per-item name.
 */

public class MenuListItem implements Serializable {
    private int menuListItemID;
    private String menuListItemName;

    public MenuListItem(int menuListItemID, String menuListItemName) {
        setMenuListItemID(menuListItemID);
        setMenuListItemName(menuListItemName);
    }

    public int getMenuListItemID() {
        return (menuListItemID);
    }

    protected void setMenuListItemID(int menuListItemID) {
        this.menuListItemID = menuListItemID;
    }

    public String getMenuListItemName() {
        return (menuListItemName);
    }

    protected void setMenuListItemName(String menuListItemName) {
        this.menuListItemName = menuListItemName;
    }

}