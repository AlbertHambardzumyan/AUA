<script>
    $(".addInCart").on("click", function () {
        var selectedProductItemId = this.value;
        $.get('/ShoppingCartSetter', {"selectedProductItemId": selectedProductItemId},
                function (resp) {
                })
                .fail(function () {
                    alert("Adding into the shopping cart Request failed.");
                });
    });
</script>
<section id="subMenuItemCatalogSection">
    <h5 class="bl text-center">${selectedSubMenu}</h5>
    <%@ taglib prefix="c"
               uri="http://java.sun.com/jsp/jstl/core" %>

    <ul class="list-layout items text-center">
        <c:forEach var="productItem" items="${productItems}">
            <li>
                <div class="productImages">
                    <a class="pointer">
                        <img src="/img/${productItem.productItemPictureUrl}.jpg" alt="${selectedSubMenu}">
                    </a>
                </div>
                <div class="margiTop20">
                    <a class="pointer">${productItem.productItemName}</a>
                    <h5 class="priceColor"><span>$</span>${productItem.productItemPrice}</h5>
                    <button type="button" class="addInCart btn btn-sm btn-blue btn-block waves-effect waves-light"
                            value=${productItem.productItemID}>Add to Shopping Cart
                    </button>
                </div>
            </li>
        </c:forEach>
    </ul>
</section>