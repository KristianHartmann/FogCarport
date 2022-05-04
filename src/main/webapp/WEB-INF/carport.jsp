<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="/error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Choose your prefered carport
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col"><h1>Choose a prefixed carport</h1></div>
            <div class="col"><h1>OR</h1></div>
            <div class="col"><h1>Build your own</h1></div>
        </div>
        <div class="row p-2">
            <div class="col" style="height: 700px; overflow-y: scroll">
                <div class="row" style="justify-content: space-between">
                    <c:forEach begin="1" end="7" var="i">
                        <div class="card p-0" style="width: 18rem; margin-bottom: 10px;">
                            <img src="images/ProductModel${i}.png" class="card-img-top" alt="Product model ${i}">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the
                                    bulk
                                    of
                                    the card's content.</p>
                            </div>
                            <div class="card-footer">
                                <div class="row justify-content-center" style="height: 40px">
                                    <div class="col">
                                        <input type="number" min="1" class="form-control" value="1" style="height: 100%">
                                    </div>
                                    <div class="col">
                                        <button class="btn btn-primary" style="font-size: small; height: 100%; width: 100%;" type="submit">Add to cart</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="vr"></div>
            <div class="col">
            </div>
        </div>
    </jsp:body>

</t:pagetemplate>
