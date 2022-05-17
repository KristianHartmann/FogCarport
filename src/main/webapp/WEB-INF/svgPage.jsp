<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Vis SVG tegning
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
<div>
        <h2>Tegning </h2>


    <p>Her indsættes en tegning:</p>

    ${requestScope.svgDrawing} // Her indsættes en tekststreng med en genereret SVG



</div>
    </jsp:body>

</t:pagetemplate>