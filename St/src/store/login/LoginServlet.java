// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.login;

import store.db.DBconnectionManager;
import store.ex.DatabaseReadError;
import store.user.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Albert Hambardzumyan
 */

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userLogin = request.getParameter("user_login");
        String userPass = request.getParameter("user_pass");

        request.getSession().setAttribute("registrationValidationInfo", null);
        String validationInfo;

        if (userLogin != null && userPass != null && !userLogin.trim().equals("") && !userPass.trim().equals("")) {
            boolean isRegisteredUser;
            try {
                isRegisteredUser = DBconnectionManager.getInstance().isRegisteredUser(userLogin, userPass);
                if (isRegisteredUser) {
                    request.getSession().setAttribute("validationInfo", null);
                    request.getSession().setAttribute("isAuthenticated", true);
                    User user = new User(null, null, userLogin, null, userPass);
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("");
                } else {
                    validationInfo = "Username Or Password Is Wrong.";
                    request.getSession().setAttribute("validationInfo", validationInfo);
                    response.sendRedirect("/login.jsp");
                }
            } catch (DatabaseReadError databaseReadError) {
                validationInfo = "We Could NOT Connect To Database. Please Try Again";
                request.getSession().setAttribute("validationInfo", validationInfo);
                response.sendRedirect("/login.jsp");
            }

        } else {
            validationInfo = "Please Fill All Fields.";
            request.getSession().setAttribute("validationInfo", validationInfo);
            response.sendRedirect("/login.jsp");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
