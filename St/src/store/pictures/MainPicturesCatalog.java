// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.pictures;

import store.db.DBconnectionManager;

import java.util.List;

/**
 * @author Albert Hambardzumyan
 */
public class MainPicturesCatalog {
    private static String[] array;
    static{
        List<String> picturesCatalog = DBconnectionManager.getInstance().getPictureList();
        array = picturesCatalog.toArray(new String[picturesCatalog.size()]);
    }
    public static String[] getPicturesCatalog(){
        return array;
    }
}
