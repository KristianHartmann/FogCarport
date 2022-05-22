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
            <div class="col">
                <div class="row justify-content-center">
                    <div class="col-auto">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="orders-tab" data-bs-toggle="tab"
                                        data-bs-target="#orders-tab-pane" type="button" role="tab"
                                        aria-controls="home-tab-pane" aria-selected="true">Ordre
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                    <button class="nav-link" id="customers-tab" data-bs-toggle="tab"
                                            data-bs-target="#customers-tab-pane" type="button" role="tab"
                                            aria-controls="profile-tab-pane" aria-selected="false">Kunder
                                    </button>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="orders-tab-pane" role="tabpanel"
                             aria-labelledby="home-tab" tabindex="0">
                            <table class="table table-hover">
                                <thead>
                                carportRequestArrayList
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">First</th>
                                    <th scope="col">Last</th>
                                    <th scope="col">Handle</th>
                                    <th scope="col">Handle</th>
                                    <th scope="col">Handle</th>
                                    <th scope="col">Handle</th>
                                    <th scope="col">Handle</th>
                                </tr>
                                </thead>
                                <tbody class="table-group-divider">
                                <c:forEach items="${applicationScope.carportRequestArrayList}" var="request"
                                           varStatus="loop">
                                <tr>
                                    <th scope="row">${loop.index+1}</th>
                                    <td>${request.length}</td>
                                    <td>${request.width}</td>
                                    <td>${request.rooftype}</td>
                                    <td>${request.roofpitch}</td>
                                    <td>${request.toolbox_length}</td>
                                    <td>${request.toolbox_width}</td>
                                    <td>${request.email}</td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane fade" id="customers-tab-pane" role="tabpanel"
                             aria-labelledby="profile-tab" tabindex="0">

                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Number</th>
                                    <th scope="col">Email</th>
                                </tr>
                                </thead>
                                <tbody class="table-group-divider">
                                <tr>
                                    <c:forEach items="${applicationScope.personArrayList}" var="person"
                                               varStatus="loop">
                                    <th scope="row">${loop.index+1}</th>
                                    <td>${person.name}</td>
                                    <td>${person.phonenumber}</td>
                                    <td>${person.email}</td>
                                </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="row justify-content-center">
                    <div class="col-auto">
                        <button class="btn btn-primary btn-lg" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                            Forspørgsler
                        </button>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="collapse" id="collapseExample">
                        <div class="card card-body">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">length</th>
                                    <th scope="col">width</th>
                                    <th scope="col">rooftype</th>
                                    <th scope="col">roofpitch</th>
                                    <th scope="col">toolbox_length</th>
                                    <th scope="col">toolbox_width</th>
                                    <th scope="col">email</th>
                                </tr>
                                </thead>
                                <tbody class="table-group-divider">
                                <c:forEach items="${applicationScope.carportRequestArrayList}" var="request">
                                <tr>
                                    <th scope="row">${request.carport_request_id}</th>
                                    <td>${request.length}</td>
                                    <td>${request.width}</td>
                                    <td>${request.rooftype}</td>
                                    <td>${request.roofpitch}</td>
                                    <td>${request.toolbox_length}</td>
                                    <td>${request.toolbox_width}</td>
                                    <td>${request.email}</td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>

</t:pagetemplate>
