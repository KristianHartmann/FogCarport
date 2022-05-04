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
        <%--                <div class="row">--%>
        <%--                    <div class="col"><h1>Choose a prefixed carport</h1></div>--%>
        <%--                    <div class="col"><h1>OR</h1></div>--%>
        <%--                    <div class="col"><h1>Build your own</h1></div>--%>
        <%--                </div>--%>
        <%--                <div class="row p-2">--%>
        <%--                    <div class="col" style="height: 700px; overflow-y: scroll">--%>
        <%--                        <div class="row" style="justify-content: space-between">--%>
        <%--                            <c:forEach begin="1" end="7" var="i">--%>
        <%--                                <div class="card p-0" style="width: 18rem; margin-bottom: 10px;">--%>
        <%--                                    <img src="images/ProductModel${i}.png" class="card-img-top" alt="Product model ${i}">--%>
        <%--                                    <div class="card-body">--%>
        <%--                                        <p class="card-text">Some quick example text to build on the card title and make up the--%>
        <%--                                            bulk--%>
        <%--                                            of--%>
        <%--                                            the card's content.</p>--%>
        <%--                                    </div>--%>
        <%--                                    <div class="card-footer">--%>
        <%--                                        <div class="row justify-content-center" style="height: 40px">--%>
        <%--                                            <div class="col">--%>
        <%--                                                <input type="number" min="1" class="form-control" value="1" style="height: 100%">--%>
        <%--                                            </div>--%>
        <%--                                            <div class="col">--%>
        <%--                                                <button class="btn btn-primary" style="font-size: small; height: 100%; width: 100%;" type="submit">Add to cart</button>--%>
        <%--                                            </div>--%>
        <%--                                        </div>--%>
        <%--                                    </div>--%>
        <%--                                </div>--%>
        <%--                            </c:forEach>--%>
        <%--                        </div>--%>
        <%--                    </div>--%>
        <%--                    <div class="vr"></div>--%>
        <%--                    <div class="col">--%>
        <%--                    </div>--%>
        <%--                </div>--%>
        <div class="row">
            <h1 class="col offset-1">QUICKBYG</h1>
        </div>
        <div class="row">
            <div class="col-3 offset-1">
                <div class="list-group" id="list-tab" role="tablist">
                    <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list"
                       href="#list-home" role="tab" aria-controls="list-home">QUICKBYG</a>
                    <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list"
                       href="#list-profile" role="tab" aria-controls="list-profile">CARPORT MED FLADT TAG</a>
                    <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list"
                       href="#list-messages" role="tab" aria-controls="list-messages">CARPORT MED REJSNING</a>
                    <a class="list-group-item list-group-item-action" id="list-settings-list" data-bs-toggle="list"
                       href="#list-settings" role="tab" aria-controls="list-settings">STANDARD CARPORTE</a>
                </div>
            </div>
            <div class="col-7">
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="list-home" role="tabpanel"
                         aria-labelledby="list-home-list">
                        <div class="row">
                            <h3>Quick-byg tilbud</h3>
                            <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en
                                skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine
                                specifikke ønsker.

                                Tilbud og skitsetegning fremsendes med post hurtigst muligt.
                                Ved bestilling medfølger standardbyggevejledning.

                                Rekvirér tilbud - start med at vælge type: </p>
                        </div>
                        <hr>
                        <div class="row justify-content-center" style="text-align: center">
                            <h6>Carport med fladt tag</h6>
                            <img src="images/quickurejs.png" alt="carport med flat tag" style="width: 350px">
                        </div>
                        <hr>
                        <div class="row justify-content-center" style="text-align: center">
                            <h6>Carport med rejsning</h6>
                            <img src="images/quickmrejs.png" style="width: 350px;" alt="carport med rejsning">
                        </div>
                        <hr>
                    </div>
                    <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
                        <div class="row">
                            <h3>QUICK-BYG TILBUD - CARPORT MED FLADT TAG</h3>
                            <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en
                                skitsetegning på en carport indenfor vores standardprogram.

                                Tilbud og skitsetegning fremsendes med post hurtigst muligt.
                                Standardbyggevejledning medfølger ved bestilling.</p>
                            <p><strong>Udfyld nedenstående omhyggeligt og klik på "Bestil"</strong><br>
                                Felter markeret * SKAL udfyldes!</p>
                            <p>Ønsket carport mål:</p>
                            <form>
                                <div class="form-group">
                                    <label for="cpwidth">Carport bredde:</label>
                                    <select class="form-control" id="cpwidth">
                                        <option value="" selected disabled hidden>Vælg bredde</option>
                                        <c:forEach begin="240" end="600" var="i" step="30">
                                            <option value="${i}">${i} cm</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="cplength">Carport længde:</label>
                                    <select class="form-control" id="cplength">
                                        <option value="" selected disabled hidden>Vælg længde</option>
                                        <c:forEach begin="240" end="780" var="i" step="30">
                                            <option value="${i}">${i} cm</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <p><strong>Redskabsrum:</strong><br>
                                    NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*</p>
                                <div class="form-check form-switch">
                                    <input class="form-check-input" onchange="showShed()" type="checkbox" role="switch"
                                           id="cpshed">
                                    <label class="form-check-label" for="cpshed">Tilføj redskabskur</label>
                                </div>
                                <div class="form-group" id="cpshedwidthdiv" style="display: none">
                                    <labe for="cpshedwidth">Redskabsrum bredde:</labe>
                                    <select class="form-control" id="cpshedwidth">
                                        <option value="" selected disabled hidden>Ønsker ikke redskabsrum</option>
                                        <c:forEach begin="210" end="720" var="i" step="30">
                                            <option value="${i}">${i} cm</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group" id="cpshedlengthdiv" style="display: none">
                                    <labe for="cpshedlength">Redskabsrum længde:</labe>
                                    <select class="form-control" id="cpshedlength">
                                        <option value="" selected disabled hidden>Ønsker ikke redskabsrum</option>
                                        <c:forEach begin="150" end="690" var="i" step="30">
                                            <option value="${i}">${i} cm</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Bestil</button>
                                <p>* Hvis du f.eks. har valgt en carport med målene 240x360 cm kan redskabsrummet
                                    maksimalt måle <strong>210x330 cm.</strong></p>
                            </form>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">
                        <h1>under construction</h1>
                    </div>
                    <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">
                        <div class="row" style="justify-content: space-between">
                            <h3>Standard Carporte</h3>
                            <c:forEach begin="1" end="7" var="i">
                                <div class="card p-0" style="width: 18rem; margin-bottom: 10px;">
                                    <img src="images/ProductModel${i}.png" class="card-img-top"
                                         alt="Product model ${i}">
                                    <div class="card-body">
                                        <p class="card-text">Some quick example text to build on the card title and make
                                            up the
                                            bulk
                                            of
                                            the card's content.</p>
                                    </div>
                                    <div class="card-footer">
                                        <div class="row justify-content-center" style="height: 40px">
                                            <div class="col">
                                                <input type="number" min="1" class="form-control" value="1"
                                                       style="height: 100%">
                                            </div>
                                            <div class="col">
                                                <button class="btn btn-primary"
                                                        style="font-size: small; height: 100%; width: 100%;"
                                                        type="submit">Add to cart
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>

</t:pagetemplate>
