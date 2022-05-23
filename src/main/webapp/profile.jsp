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
                        <button class="dropdown-item" data-bs-toggle="offcanvas" data-bs-target="#offcanvasOrder"
                                type="button">ordre 1
                        </button>
                    </li>
                </ul>
            </div>
        </div>


        <%--    Offcanvas    --%>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasOrder" aria-labelledby="offcanvasOrderLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasOrderLabel">Ordre 1</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body" style="text-align: center">
                <button class="btn btn-info" data-bs-toggle="collapse" data-bs-target="#partList-table"
                        aria-expanded="false" aria-controls="partList-table">vis stykliste
                </button>
                <div class="collapse mt-2" id="partList-table">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Handle</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider">
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td colspan="2">Larry the Bird</td>
                            <td>@twitter</td>
                        </tr>
                        </tbody>
                        <tfoot>
                        </tfoot>
                    </table>
                </div><br>
                <button class="btn btn-secondary mt-3" data-bs-toggle="modal" data-bs-target="#svgOrderModal">vis tegninger</button>
            </div>
        </div>
        <%--    svgOrderModal    --%>
        <div class="modal modal-lg fade" id="svgOrderModal" tabindex="-1" aria-labelledby="svgOrderModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="svgOrderModalLabel">Tegninger for ordre 1</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="row justify-content-center">
                            <div class="col-auto">
                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link active" id="orders-tab" data-bs-toggle="tab"
                                                data-bs-target="#orders-tab-pane" type="button" role="tab"
                                                aria-controls="home-tab-pane" aria-selected="true">Sideview
                                        </button>
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link" id="customers-tab" data-bs-toggle="tab"
                                                data-bs-target="#customers-tab-pane" type="button" role="tab"
                                                aria-controls="profile-tab-pane" aria-selected="false">Topview
                                        </button>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <div class="tab-content" id="myTabContent" style="width: 100%; height: 600px">
                                <div class="tab-pane fade show active" id="orders-tab-pane" role="tabpanel"
                                     aria-labelledby="home-tab" tabindex="0">
                                </div>
                                <div class="tab-pane fade" id="customers-tab-pane" role="tabpanel"
                                     aria-labelledby="profile-tab" tabindex="0">
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
