<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="/error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome ${sessionScope.user.email}
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="text-end px-5">
                <button class="btn dropdown-toggle" type="button" id="dropdownCogWheelMenu"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="images/profilecogwheel.png" width="40">
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownCogWheelMenu">
                    <li><a class="dropdown-item" href="#">Rediger profil</a></li>
                    <li><a class="dropdown-item" href="#">Skift Kodeord</a></li>
                </ul>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-auto">
                <img src="images/profile-icon.jpg" width="150">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-auto">
                <p style="width: 500px">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec et sodales diam,
                    ut dictum mauris.
                    Fusce eros velit, varius sed iaculis ac, vulputate in velit. Suspendisse aliquam ut dolor a congue.
                    Nam a sapien tincidunt, gravida lectus in, lobortis risus. Maecenas eleifend pharetra metus ut
                    egestas. Proin ut interdum diam. Nam imperdiet luctus rutrum. Phasellus at pretium arcu.</p>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-auto">
                <button class="btn dropdown-toggle" type="button" id="dropdownProfileMenu"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="images/Hamburger_icon_profile.png" width="40">

                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownProfileMenu">
                    <li>
                        <c:forEach items="${applicationScope.orderArrayList}" var="order">
                            <form action="ProfileController" method="post" class="profileOrderForm">
                                <input hidden value="${order.order_id}" name="orderID">
                                <button class="dropdown-item"
                                        type="submit">Order ${order.order_id}
                                </button>
                            </form>
                        </c:forEach>
                    </li>
                </ul>
            </div>
        </div>
Backup table here
                <div >
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">PartlistItem Description</th>
                    <th scope="col">PartlistItem Amount</th>
                    <th scope="col">Part Description</th>
                    <th scope="col">Part name</th>
                </tr>
                </thead>
                <c:forEach items="${applicationScope.partsListArray}" var="item">
                    <tr>
                        <td>${item.description}</td>
                        <td>${item.amount}</td>
                        <td>${item.parts.description}</td>
                        <td>${item.parts.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                </tfoot>
            </table>
        </div>

<%--            Offcanvas    --%>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasOrder" aria-labelledby="offcanvasOrderLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasOrderLabel"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body" style="text-align: center">
                <button class="btn btn-info" data-bs-toggle="collapse" data-bs-target="#partList-table"
                        aria-expanded="false" type="button" aria-controls="partList-table" name="StykListeKnap">vis
                    stykliste
                </button>


                <div class="collapse mt-2" id="partList-table">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">PartlistItem Description</th>
                            <th scope="col">PartlistItem Amount</th>
                            <th scope="col">Part Description</th>
                            <th scope="col">Part name</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider" id="partsListTableBody">
                        <c:forEach items="${applicationScope.partsListArray}" var="item">
                            <tr>
                                <td>${item.description}</td>
                                <td>${item.amount}</td>
                                <td>${item.parts.description}</td>
                                <td>${item.parts.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        </tfoot>
                    </table>
                </div>
                <br>
                <button class="btn btn-secondary mt-3" data-bs-toggle="modal" data-bs-target="#svgOrderModal">vis
                    tegninger
                </button>
            </div>
        </div>
        <%--    svgOrderModal    --%>
        <div class="modal modal-lg fade" id="svgOrderModal" tabindex="-1" aria-labelledby="svgOrderModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="svgOrderModalLabel">Tegninger for</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="row justify-content-center">
                            <div class="col-auto">
                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link active" id="sideView-tab" data-bs-toggle="tab"
                                                data-bs-target="#sideView-tab-pane" type="button" role="tab"
                                                aria-controls="sideView-tab-pane" aria-selected="true">Sideview
                                        </button>
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link" id="topView-tab" data-bs-toggle="tab"
                                                data-bs-target="#topView-tab-pane" type="button" role="tab"
                                                aria-controls="topView-tab-pane" aria-selected="false">Topview
                                        </button>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <div class="tab-content" id="myTabContent" style="width: 100%; height: 600px">
                                <div class="tab-pane fade show active" id="sideView-tab-pane" role="tabpanel"
                                     aria-labelledby="sideView-tab" tabindex="0" style="height: 600px">
                                </div>
                                <div class="tab-pane fade" id="topView-tab-pane" role="tabpanel"
                                     aria-labelledby="topView-tab" tabindex="0" style="height: 600px">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>

</t:pagetemplate>
