<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>ManageCustomerPage</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                All Orders
            </div>
        </div>


        <table class="table table-success table-striped ">
            <thead>
            <tr>
                <th scope="col">OrderId</th>
                <th scope="col">User_id</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <c:forEach var="order" items="${sessionScope.orderList}">
                <tr>
                    <td>${order.order_id}</td>
                    <td>${order.user_id}</td>
                    <td>${order.price}</td>
                </tr>
            </c:forEach>
        </table>


    </jsp:body>
</t:genericpage>