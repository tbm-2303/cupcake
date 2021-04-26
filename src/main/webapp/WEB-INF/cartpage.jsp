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


        </div>

        <form action="${pageContext.request.contextPath}/fc/updateCommand" method="post">
            <table class="table table-success table-striped">
                <thead>
                <tr>
                    <th scope="col">Bottom</th>
                    <th scope="col">Topping</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Price</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="cart" items="${sessionScope.cupcakeList}" varStatus="status">
                    <tr>
                        <td>${cart.bot.name}</td>
                        <td>${cart.top.name}</td>
                        <td>
                            <label for="amount"></label><input type="number" class="" id="amount" name="amount" min="0" step="1"
                                                            value="${cart.amount}">
                        </td>
                        <td>${cart.price}</td>
                        <!-- OrderLine doesn't exist and doesn't have an ID, so we're using the loop index to identify the item selected -->
                        <td>
                            <button type="submit" class=" btn btn-danger" name="remove" value="${status.index}">Fjern
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <c:if test="${requestScope.error != null}">
                <p style="color: red">${requestScope.error}</p>
            </c:if>
            <div class="card">
                <c:if test="${sessionScope.cupcakeList != null && sessionScope.price != null}">
                    <input type="submit" class="btn btn-outline-primary" name="updateCommand"
                           value="Opdate ShoppingCart">
                </c:if>

            </div>
        </form>

        <c:if test="${sessionScope.cupcakeList != null && not empty sessionScope.cupcakeList && sessionScope.price != null}">
            <div class="card">
                <a href="${pageContext.request.contextPath}/fc/createordercommand" class="btn btn-outline-success"
                   role="button">Tryk her for at betale</a>
            </div>
            <p class="h3">Total: ${sessionScope.price}</p>
        </c:if>
    </jsp:body>
</t:genericpage>