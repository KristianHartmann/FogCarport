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
<div style="height:780px; width: 600px;"> // Laver en ramme til at holde viewBox i.
    <svg height="100%" width="100%" viewBox="0 0 100% 100%"> // Laver en SVG med viewBox i ramme størrelse.

        private final String rectTemplate = "<rect x="%d" y="%d" height="%d" width="%d" style="stroke:#000000; fill: #ffffff"/>";

    </svg>

</div>
    </jsp:body>

</t:pagetemplate>