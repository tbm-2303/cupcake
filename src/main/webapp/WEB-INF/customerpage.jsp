<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.name} </h1>
        You are now logged in as a Customer.

        <c:if test="${sessionScope.role == 'customer' }">
            <br>
            Email: ${sessionScope.email}<br>
            Role: ${sessionScope.role}<br>
            UserId: ${sessionScope.userId}<br><br>
            <a href= "${pageContext.request.contextPath}/fc/orderpage" class="btn btn-lg btn btn-outline-success" role="button">Ordering Page</a>
            <a href= "${pageContext.request.contextPath}/#" class="btn btn-lg btn btn-outline-success" role="button">Order history</a>
            <a href= "${pageContext.request.contextPath}/#" class="btn btn-lg btn btn-outline-success" role="button">Insert money</a>
        </c:if>


    </jsp:body>

</t:genericpage>

