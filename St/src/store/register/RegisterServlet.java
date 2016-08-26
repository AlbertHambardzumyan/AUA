// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.register;

import store.db.DBconnectionManager;
import store.ex.DatabaseReadError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Albert Hambardzumyan
 */
public class RegisterServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String phone = request.getParameter("phone");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        String registrationValidationInfo;
        if (firstName != null && lastName != null && emailAddress != null && phone != null && pass1 != null && pass2 != null &&
                !firstName.trim().equals("") && !lastName.trim().equals("") && !emailAddress.trim().equals("") && !phone.trim().equals("") &&
                !pass1.trim().equals("") && !pass2.trim().equals("")) {

            if (pass1.equals(pass2)) {
                boolean isExistsEmail;
                try {
                    isExistsEmail = DBconnectionManager.getInstance().isExistsEmail(emailAddress);
                    if (!isExistsEmail) {
                        boolean insertResponse = DBconnectionManager.getInstance().insert(firstName, lastName, emailAddress, phone, pass1);
                        if (insertResponse) {
                            registrationValidationInfo = "You Have Successfully Registered. Now You Can Get Started";
                            request.getSession().setAttribute("registrationValidationInfo", registrationValidationInfo);
                            response.sendRedirect("/login.jsp");
                        }
                    } else {
                        registrationValidationInfo = "Email Address Is Already Registered.";
                        request.getSession().setAttribute("registrationValidationInfo", registrationValidationInfo);
                        response.sendRedirect("/register.jsp");
                    }
                } catch (DatabaseReadError databaseReadError) {
                    registrationValidationInfo = "We Could NOT Connect To Database. Please Try Again";
                    request.getSession().setAttribute("registrationValidationInfo", registrationValidationInfo);
                    response.sendRedirect("/register.jsp");
                }
            } else {
                registrationValidationInfo = "Re-Enter Password Correctly.";
                request.getSession().setAttribute("registrationValidationInfo", registrationValidationInfo);
                response.sendRedirect("/register.jsp");
            }
        } else {
            registrationValidationInfo = "Please Fill All Fields.";
            request.getSession().setAttribute("registrationValidationInfo", registrationValidationInfo);
            response.sendRedirect("/register.jsp");
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
