<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-lg-12 col-md-12 ">
    <table class="bl cartTable text-center">
        <tr class="blueTr">
            <th class="hide-sm">Item ID</th>
            <th>Description</th>
            <th>Unit Cost</th>
            <th>Number</th>
            <th class="hide-sm">Total Cost</th>
        </tr>
        <c:forEach var="shoppingCartItem" items="${shoppingCart.shoppingCartItems}">
            <tr>
                <td class="hide-sm">${shoppingCartItem.productItemID}</td>
                <td>${shoppingCartItem.productItemName}</td>
                <td><span>$</span>${shoppingCartItem.productUnitCost}</td>
                <td>
                    <label class="sr-only">Ordered Number</label>
                    <input type="number" id="${shoppingCartItem.productItem.productItemID}" size="3"
                           class="form-control marginBottom2 bl text-center" value="${shoppingCartItem.productNumItems}"
                           required="">
                    <button type="button" class="updateNumber btn btn-sm btn-blue btn-block waves-effect waves-light"
                            value=${shoppingCartItem.productItem.productItemID}>Update Item Number
                    </button>
                </td>
                <td class="hide-sm"><span>$</span>${shoppingCartItem.totalCost}</td>
            </tr>
        </c:forEach>
        <tr class="blueTr">
            <th>Total</th>
            <th class="hide-sm"></th>
            <th></th>
            <th class="hide-sm"></th>
            <th><span>$</span>${total}</th>
        </tr>
    </table>
</div>
<div class="text-center paymentDiv">
    <a class="form-btn btn-lg payment btn-block waves-effect waves-light" href="/AuthenticationChecker" type="submit">Proceed
        to Checkout</a>
</div>