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
            <h2>Shopping Cart page</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                Here you can see the items in your shopping cart.
            </div>


            <p style="font-size: medium">Purchase items</p>
                <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/createordercommand">Purchase</a>


        </div>

    </jsp:body>
</t:genericpage>