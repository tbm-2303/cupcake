<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    <meta name="theme-color" content="#7952b3">


    __________________________________________________

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        .notification {
            background-color: #555;
            color: white;
            text-decoration: none;
            padding: 6px 6px;
            position: relative;
            display: inline-block;
            border-radius: 2px;
        }

        .notification:hover {
            background: red;
        }

        .notification .badge {
            position: absolute;
            top: -8px;
            right: -8px;
            padding: 3px 3px;
            border-radius: 50%;
            background-color: red;
            color: white;
        }
    </style>

    __________________________________________________
</head>
<body>

<div class="page-header">

</div>

<div class="card-body " style="margin-top: -2em">
    <header class="d-flex flex-column flex-md-row align-items-center p-3 pb-0 px-md-4 mb-4 bg-white border-bottom shadow-sm">
        <div class="h5 my-0 me-md-auto fw-normal">
            <c:if test="${sessionScope.role == 'customer' }">
                <a class="navbar-brand mb-0 h1 text-dark" href="${pageContext.request.contextPath}/fc/customerpage">
                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                         class="bi bi-person-square" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                        <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z"/>
                    </svg>
                </a>
                <c:if test="${sessionScope.role == 'customer' }">
                    <a class="navbar-brand mb-0 h1 text-dark"
                       href="${pageContext.request.contextPath}/fc/showcartCommand">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                             class="bi bi-basket3" viewBox="0 0 16 16">
                            <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-1A.5.5 0 0 1 .5 6h1.717L5.07 1.243a.5.5 0 0 1 .686-.172zM3.394 15l-1.48-6h-.97l1.525 6.426a.75.75 0 0 0 .729.574h9.606a.75.75 0 0 0 .73-.574L15.056 9h-.972l-1.479 6h-9.21z"/>
                        </svg>
                    </a>
                    <c:if test="${sessionScope.balance != null }">
                        <a href="#" class="notification">
                            <span>Wallet</span>
                            <span class="badge">${sessionScope.balance}</span>
                        </a>
                    </c:if>
                </c:if>
            </c:if>
        </div>


        <nav class="my-2 my-md-0 me-md-3">

            <c:if test="${sessionScope.user != null }">
                ${sessionScope.user.email}
            </c:if>

            <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
            <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
            <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

            <c:if test="${isNotLoginPage && isNotRegisterPage}">
                <c:if test="${sessionScope.user != null }">
                    <a type="button" class="btn btn-lg btn btn-outline-success"
                       href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
                </c:if>
                <c:if test="${sessionScope.user == null }">
                    <a type="button" class="btn btn-lg btn btn-outline-success"
                       href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                    <a type="button" class="btn btn-lg btn btn-outline-success"
                       href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
                </c:if>
            </c:if>

        </nav>

    </header>

</div>

<div class="card-body bg-white" style="margin-top: -2em">
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container">
    <br>
    <hr>
    <br>
    <jsp:invoke fragment="footer"/>
</div>

</body>
</html>