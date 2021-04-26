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

            <label for="top">Choose a top:</label>
            <select name="top" id="top">
                <optgroup label="Cupcake tops">
                    <option value="1">Chocolate</option>
                    <option value="2">Blueberry</option>
                    <option value="3">Rasberry</option>
                    <option value="4">Crispy</option>
                    <option value="5">Strawberry</option>
                    <option value="6">Rum/Raisin</option>
                    <option value="7">Orange</option>
                    <option value="8">Lemon</option>
                    <option value="9">Blue cheese</option>
                </optgroup>
            </select>

            <label for="bottom">Choose a bottom:</label>
            <select name="bottom" id="bottom">
                <optgroup label="Cupcake bottoms">
                    <option value="1">Chocolate</option>
                    <option value="2">Vanilla</option>
                    <option value="3">Nutmeg</option>
                    <option value="4">Pistacio</option>
                    <option value="5">Almond</option>
                </optgroup>
            </select>


            <label for="amount">amount:</label>
            <select name="amount" id="amount">
                <optgroup label="amount">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                </optgroup>
            </select><br>


            <div>
                <button type="submit" class="btn btn-lg btn btn-outline-success">order</button>
            </div>
        </form>


        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>
    </jsp:body>

</t:genericpage>

