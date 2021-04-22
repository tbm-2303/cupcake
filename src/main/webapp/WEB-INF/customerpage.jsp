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
        <br>
        Email: ${sessionScope.email}
        <br>
        Role: ${sessionScope.role}
        <br>
        UserId: ${sessionScope.userId}
        <br>
        <p><a href= "${pageContext.request.contextPath}/fc/orderpage">Ordering Page</a>



    </jsp:body>

</t:genericpage>

