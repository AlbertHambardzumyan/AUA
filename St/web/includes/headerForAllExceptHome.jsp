<%--
  Created by IntelliJ IDEA.
  User: Albert
  Date: 11/14/2015
  Time: 17:36 PM
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
    <link href="./css/cart.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="./css/footer.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="./css/wave-effects.css" type="text/css" rel="stylesheet" media="screen,projection"/>

    <script src="./js/materialize.js"></script>

</head>
<body>

<nav class="navbar navbar-bootsnipp no-margin bg-header">
    <div class="container">
        <div class="navbar-header">
            <div class="animbrand">
                <a class="navbar-brand" href="/home.jsp"><strong class="white">Sport Store</strong></a>
            </div>
        </div>
        <div>
            <%@ taglib prefix="c"
                       uri="http://java.sun.com/jsp/jstl/core" %>

            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${isAuthenticated}">
                        <li><a href="" class="bl"><span class="myIcon glyphicon glyphicon-user"></span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="login.jsp" class="bl">Login</a></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="cart.jsp" class="bl"><span class="myIcon glyphicon glyphicon-shopping-cart"></span></a></li>
            </ul>
        </div>
    </div>
</nav>

