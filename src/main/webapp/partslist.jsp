<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
      Partslist
    </jsp:attribute>

  <jsp:attribute name="footer">
            Partslist
    </jsp:attribute>

  <jsp:body>
      <c:forEach items="${applicationScope.partsList}" var="partsListItem">
          PartlistItem Description &nbsp;${partsListItem.description}
          PartlistItem Amount &nbsp;${partsListItem.amount}
          Part Description &nbsp;${partsListItem.parts.description}
          Part name &nbsp;${partsListItem.parts.name}
<br>
      </c:forEach>
  </jsp:body>
</t:pagetemplate>