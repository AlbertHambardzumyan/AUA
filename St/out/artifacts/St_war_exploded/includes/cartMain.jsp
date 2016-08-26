<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${shoppingCart!= null && !shoppingCart.shoppingCartItems.isEmpty()}">
        <jsp:include page="cartTable.jsp"/>
    </c:when>
    <c:otherwise>
        <h4 class="text-center bl">No Item To Show In Shopping Cart</h4>
    </c:otherwise>
</c:choose>
