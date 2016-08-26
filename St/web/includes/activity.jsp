<script>
    /** script for getting products */
    $(document).on("click", ".subMenuCall", function () {
        var selectedSubMenu = this.innerHTML;
        $.get('/ProductItemsSetup', {"selectedSubMenu": selectedSubMenu},
                function (resp) {
                    $('#subMenuItemCatalogSection').load('/includes/subMenuItemCatalog.jsp');
                })
                .fail(function () {
                    alert("Products Request is failed.");
                });
    });
</script>
<section class="containerActivity">
    <div class="row row-condensed" style="margin: 0">
        <div class="col-md-2 col-md-offset-0">
            <jsp:include page="subMenu.jsp"/>
        </div>
        <div class="col-md-10 col-md-offset-0">
            <jsp:include page="subMenuItemCatalog.jsp"/>
        </div>
    </div>
</section>