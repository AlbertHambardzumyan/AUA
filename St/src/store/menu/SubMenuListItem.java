// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.menu;

import java.io.Serializable;

/**
 * @author Albert Hambardzumyan
 */

/**
 * Describes a SubMenuListItem for on-line store. The subMenuListItemID
 * uniquely identifies the subMenu list item id, and the subMenuListItemName
 * gives the current per-item name.
 */

public class SubMenuListItem implements Serializable {
    private int subMenuListItemID;
    private String subMenuListItemName;
    private String menuName;

    public SubMenuListItem(int subMenuListItemID, String subMenuListItemName, String menuName) {
        setSubMenuListItemID(subMenuListItemID);
        setSubMenuListItemName(subMenuListItemName);
        setMenuName(menuName);
    }

    public int getSubMenuListItemID() {
        return (subMenuListItemID);
    }

    protected void setSubMenuListItemID(int subMenuListItemID) {
        this.subMenuListItemID = subMenuListItemID;
    }

    public String getSubMenuListItemName() {
        return (subMenuListItemName);
    }

    protected void setSubMenuListItemName(String subMenuListItemName) {
        this.subMenuListItemName = subMenuListItemName;
    }

    public String getMenuName() {
        return (menuName);
    }

    protected void setMenuName(String menuName) {
        this.menuName = menuName;
    }


}