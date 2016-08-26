<%--
  Created by IntelliJ IDEA.
  User: Albert
  Date: 11/10/2015
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <title>Sport Store</title>
    <link rel="icon" href="./icons/favicon.ico" type="image/x-icon"/>

    <!-- bootstrap -->
    <link href="./css/bootstrap.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <script src="./js/jquery.js"></script>
    <script src="./js/bootstrap.js"></script>

    <!-- styles goes here -->
    <link href="css/login.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/wave-effects.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<body>
    <section class="container">
        <div class="text-center">${registrationValidationInfo}</div>
        <div class="text-center">${validationInfo}</div>
        <form class="form-signIn" name="myForm" action="/LoginServlet" method="post">

            <h2 class="text-center c-blue">Sport Store</h2>

            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control space-top-2 space-bottom-2" placeholder="Email address" required="" autofocus="" name="user_login" >

            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control space-bottom-2" placeholder="Password" required="" name="user_pass">


            <button class="btn btn-lg btn-login btn-block waves-effect waves-light" type="submit">Login</button>

            <div class="text-center space-top-1">
                <a href="forgotPassword.jsp" style="color: #fff">Forgot Password?</a>
            </div>

            <hr class="footer-divider space-top-8 space-bottom-8">

            <p>Don't have an account?</p>
            <a class="btn btn-lg btn-signUp btn-block waves-effect waves-light" href="register.jsp" type="submit">Register</a>
        </form>
    </section>
<!-- Script for Materialize -->
<script src="./js/materialize.js"></script>
</body>
</html>