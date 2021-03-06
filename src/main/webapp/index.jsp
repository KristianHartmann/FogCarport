<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <p>Startcode for 2nd semester </p>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here:
            <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#loginModal">Login
            </button>
        </c:if>

        <%--            <form action="PartslistController" method="get">--%>
        <%--            <input type="submit" name="command" value="partslist"/>--%>
        <%--        </form>--%>
        <div>
            <form action="Login" method="post" class="mt-3">
                <input name="username" hidden value="b@b.com">
                <input name="password" hidden value="customer">
                <button class="btn btn-primary" type="submit">Login som bruger</button>
            </form>

            <form action="Login" method="post" class="mt-3">
                <input name="username" hidden value="a@a.com">
                <input name="password" hidden value="admin">
                <button class="btn btn-primary" type="submit">Login som admin</button>
            </form>
        </div>
    </jsp:body>

</t:pagetemplate>