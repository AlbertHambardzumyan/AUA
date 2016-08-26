<script>
    /** script for getting sub menu as user clicked on menu item*/
    $(document).on("click", ".menuCall", function () {
        var selectedMenu = this.innerHTML;
        $.get('/SubMenuListItemsSetup', {"selectedMenu": selectedMenu},
                function (resp) {
                    $('#main').load('/includes/activity.jsp');
                })
                .fail(function () {
                    alert("Sub Menu Request failed.");
                });
    });
</script>
<section id="menu">
    <nav class="navbar navbar-bootsnipp bg-menu no-margin">
        <div class="container">

            <div class="text-center">
                <%@ taglib prefix="c"
                           uri="http://java.sun.com/jsp/jstl/core" %>
                <ul class="nav navbar-nav">
                    <c:forEach var="menuListItem" items="${menuListItems}">
                        <li><a class="pointer bl menuCall">${menuListItem.menuListItemName}</a></li>
                    </c:forEach>
                </ul>
            </div>

        </div>
    </nav>
</section>