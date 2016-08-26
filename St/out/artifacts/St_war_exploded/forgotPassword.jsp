<%--
  Created by IntelliJ IDEA.
  User: Albert
  Date: 11/12/2015
  Time: 15:50 PM
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
    <link href="css/forgotPassword.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/wave-effects.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<body>

<section class="container">
    <form class="form-signIn" name="myForm">
        <h2 class="text-center c-blue">Sport Store</h2>

        <p class="text-center space-top-8 font-16">Provide your email to get a new password</p>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control space-bottom-2 space-top-4" placeholder="Email address"
               required="" autofocus="">


        <button class="btn btn-lg btn-login btn-block waves-effect waves-light" type="submit">Retrieve Password</button>
        <div class="text-center space-top-1">
            <a href="login.jsp" style="color: #fff">Login</a>
        </div>

    </form>
</section>

<!-- Script for Materialize -->
<script src="./js/materialize.js"></script>
</body>
</html>