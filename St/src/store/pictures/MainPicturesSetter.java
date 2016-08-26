// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.pictures;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Albert Hambardzumyan
 */
public class MainPicturesSetter extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("picturesArray", MainPicturesCatalog.getPicturesCatalog());



       /* response.setContentType("application/json");
        String[] array = MainPicturesCatalog.getPicturesCatalog();
        Gson gson = new Gson();


        response.getWriter().write(gson.toJson(array));
        response.flushBuffer();*/
    }
}
