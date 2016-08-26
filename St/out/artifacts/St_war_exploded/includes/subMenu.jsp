<h5 class="bl text-center">${selectedMenu}</h5>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="list-layout text-center">
    <c:forEach var="subMenuListItem" items="${subMenuListItems}">
        <li class="padding5"><a class="link-contrast bl subMenuCall pointer">${subMenuListItem.subMenuListItemName}</a>
        </li>
    </c:forEach>
</ul>
