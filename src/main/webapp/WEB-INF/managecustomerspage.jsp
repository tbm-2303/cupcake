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
                All customers and employees
            </div>
        </div>


        <table class="table table-success table-striped ">
            <thead>
            <tr>
                <th scope="col">Userid</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Role</th>
                <th scope="col">Balance</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach var="customer" items="${sessionScope.customerList}" varStatus="status_index">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
                    <td>${customer.role}</td>
                    <td><label for="balance"></label><input type="number" class="" id="balance" name="balance" value="${customer.balance}"></td>
                </tr>

            </c:forEach>
        </table>

                <c:if test="${sessionScope.customerList != null}">
                    <div class="card">
                        <a href="${pageContext.request.contextPath}/fc/updatebalance" class="btn btn-outline-success"
                           role="button">refresh data with current DB data point</a>
                    </div>
                </c:if>



    </jsp:body>
</t:genericpage>