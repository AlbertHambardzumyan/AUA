// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.authentication;

import store.cookie.CookieUtilities;
import store.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Albert Hambardzumyan
 */
public class AuthenticationChecker extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        String url;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            String email = CookieUtilities.getCookieValue(request, "emailCookie", null);

            if (email == null || email.equals(""))
                url = "/login.jsp";
            else {
                request.getSession().setAttribute("isAuthenticated", true);
                request.getSession().setAttribute("user", new User(null, null, email, null, null));
                url = "/payment.jsp";
            }
        } else
            url = "/payment.jsp";


        response.sendRedirect(url);
    }
}

