<jsp:include page="includes/headerForAllExceptHome.jsp"/>
<script>
    $(document).on("click", ".updateNumber", function () {
        var selectedProductItemId = this.value;
        var updatedNumberOfItem = $("#" + selectedProductItemId).val();
        $.get('/ShoppingCartSetter', {"selectedProductItemId": selectedProductItemId, "updatedNumberOfItem": updatedNumberOfItem},
                function (resp) {
                    $('#cartBody').load('/includes/cartMain.jsp');
                })
                .fail(function () {
                    alert("Update Request failed.");
                });
    });
</script>
<section class="containerBody">
    <div class="nameLine">
        <h4 class="bl text-center">Shopping Cart</h4>
    </div>
    <div id="cartBody">
        <jsp:include page="includes/cartMain.jsp"/>
    </div>
</section>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>