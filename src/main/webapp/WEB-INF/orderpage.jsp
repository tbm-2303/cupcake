<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         ordering cupcakes here
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>


        <h1>Hello ${sessionScope.name} </h1>
        Please order some cupcakes! <br>


        <form id="form" method="post" action="${pageContext.request.contextPath}/fc/cupcakecommand">
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label class="form-check-label" for="top">Topping:</label>
                        <select class="form-control" name="top" id="top">
                            <c:forEach var="topItem" items="${applicationScope.topList}">
                                <option value="${topItem.topId}">${topItem.name} ${topItem.price} </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="col">
                    <div class="form-group">
                        <label class="form-check-label" for="bot">Bottoms:</label>
                        <select class="form-control" name="bot" id="bot">
                            <c:forEach var="botItem" items="${applicationScope.botList}">
                                <option value="${botItem.bottomId}">${botItem.name} ${botItem.price} </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="col">
                    <div class="form-group">
                        <label class="form-check-label" for="amount"> Amount:</label>
                        <select class="form-control" name="amount" id="amount">
                            <optgroup label="amount">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </optgroup>
                        </select>
                    </div>
                </div>
            </div>
            <div>
                <button type="submit" class="btn btn-lg btn btn-outline-success">læg i kurv</button>
            </div>
        </form>


        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>
    </jsp:body>

</t:genericpage>

