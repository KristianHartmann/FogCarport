<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid p-0">
    <header>
        <div class="px-3 py-2 bg-dark text-white">
            <div class="container-fluid">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="${pageContext.request.contextPath}/index.jsp"
                       class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
                        <img width="75" src="<%=request.getContextPath()%>/images/logo.png">
                    </a>

                    <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
                        <li>
                            <a href="${pageContext.request.contextPath}/index.jsp" class="nav-link text-white">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/carport.jsp" class="nav-link text-white">
                                Quick-byg
                            </a>
                        </li>
                        <c:choose>
                            <c:when test="${sessionScope.user.role.equals('admin')}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/dashboard.jsp"
                                       class="nav-link text-white">
                                        Dashboard
                                    </a>
                                </li>
                            </c:when>
                            <c:when test="${sessionScope.user.role.equals('customer')}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/profile.jsp"
                                       class="nav-link text-white">
                                        Profile
                                    </a>
                                </li>
                            </c:when>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
        <div class="px-3 py-2 border-bottom mb-3">
            <div class="container-fluid d-flex flex-wrap justify-content-center">
                <form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto">
                    <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
                </form>

                <div class="text-end">
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            <form action="Logout" method="post"  class="btn btn-light text-dark" >
                                <label></label>
                                <input type="submit"value="Logout" class="btn btn-light text-dark" >
                            </form>
                            <button class="btn btn-light dropdown-toggle" type="button" id="dropdownBalanceMenu"
                                    data-bs-toggle="dropdown" aria-expanded="false">
                                Balance: ${sessionScope.user.balance}kr,-
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownBalanceMenu">
                                <li><a class="dropdown-item" href="#">Tilføj penge</a></li>
                                <li><a class="dropdown-item" href="#">Fjern penge</a></li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <button type="button" class="btn btn-light text-dark me-2" data-bs-toggle="modal"
                                    data-bs-target="#loginModal">Login
                            </button>
                            <button type="button" class="btn btn-primary">Sign-up</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </header>

    <div id="body" class="container-fluid" style="height: calc(100vh - calc(146.27px + 81.08px + 1rem));">
        <jsp:doBody/>
    </div>

    <!-- Footer -->
    <div class="container-fluid p-0">
        <footer>
            <ul class="nav justify-content-center border-bottom pb-1 mb-1">
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">FAQs</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
            </ul>
            <p class="text-center text-muted m-0 pb-2">&copy; Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby</p>
        </footer>
    </div>
</div>

<%-- Modals --%>
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel">Login</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="text-align: center">
                <form action="Login" method="post">
                    <img class="mb-4" src="<%=request.getContextPath()%>/images/logo.png" alt="logo" width="75">
                    <h1 class="h3 mb-3 fw-normal">Please Login</h1>

                    <div class="form-floating">
                        <input type="email" name="username" class="form-control" id="floatingInput"
                               placeholder="name@example.com">
                        <label for="floatingInput">Email address</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" name="password" class="form-control" id="floatingPassword"
                               placeholder="Password">
                        <label for="floatingPassword">Password</label>
                    </div>

                    <div class="checkbox mb-3">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                </form>
            </div>
            <div class="modal-footer">
                <p class="text-muted">&copy; Johannes Fog A/S</p>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="./webjars/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="./webjars/jquery.ajax/1.2.0/src/jquery.ajaxs.js"></script>
<script type="text/javascript" rel="script" src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>