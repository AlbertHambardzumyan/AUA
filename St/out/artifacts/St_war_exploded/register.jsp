<%--
  Created by IntelliJ IDEA.
  User: Albert
  Date: 11/11/2015
  Time: 2:45 AM
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
    <link href="css/register.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/wave-effects.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<body>

<section class="container">
    <div class="text-center">${registrationValidationInfo}</div>
    <form class="form-signIn" name="myForm" action="/RegisterServlet" method="post">
        <h2 class="text-center c-blue">Sport Store</h2>

        <label for="inputFirstName" class="sr-only">First name</label>
        <input type="text" id="inputFirstName" class="form-control space-top-2" placeholder="First name" required=""
               autofocus="" name="firstName">

        <label for="inputLastName" class="sr-only">Last names</label>
        <input type="text" id="inputLastName" class="form-control space-top-1" placeholder="Last name" required=""
               name="lastName">

        <label for="inputPhone" class="sr-only">Phone</label>
        <input type="tel" id="inputPhone" class="form-control space-top-1" placeholder="Phone" required="" name="phone">

        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control space-top-1" placeholder="Email address" required=""
               name="emailAddress">

        <label class="sr-only">Password</label>
        <input type="password" id="inputPassword1" class="form-control space-top-1" placeholder="Password" required=""
               name="pass1">

        <label class="sr-only">Password</label>
        <input type="password" id="inputPassword2" class="form-control space-top-1" placeholder="Re-Enter Password"
               required="" name="pass2">

        <hr class="footer-divider space-top-8 space-bottom-8">
        <p class="text-center">By creating an account, you are agreeing to our <br><a href="#">Terms of Use</a> and <a
                href="#">Privacy Policy</a>.</p>
        <button class="btn btn-lg btn-signUp btn-block space-top-1 waves-effect waves-light" type="submit">Register
        </button>
    </form>
</section>
<!-- Script for Materialize -->
<script src="./js/materialize.js"></script>
</body>
</html>