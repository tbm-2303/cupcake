<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        <c:if test="${sessionScope.role == 'employee' }">
            <br>
            Email: ${sessionScope.email}<br>
            Role: ${sessionScope.role}<br>
            UserId: ${sessionScope.userId}<br><br>
            <a href= "${pageContext.request.contextPath}/fc/showCustomers" class="btn btn-lg btn btn-outline-success" role="button">View All customers</a>
            <a href= "${pageContext.request.contextPath}/fc/showorders" class="btn btn-lg btn btn-outline-success" role="button">View All Orders</a>
            <a href= "${pageContext.request.contextPath}/fc/orderpage" class="btn btn-lg btn btn-outline-success" role="button">se alle ordre</a>
        </c:if>

    </jsp:body>
</t:genericpage>
