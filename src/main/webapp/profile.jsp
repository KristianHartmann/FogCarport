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
                    <li><button class="dropdown-item" type="button" id="dropdownOrderMenu">Se ordre</button></li>
                    <li><button class="dropdown-item" type="button">Se styklister</button></li>
                    <li><button class="dropdown-item" type="button">Se tegninger</button></li>
                </ul>
            </div>
        </div>
    </jsp:body>

</t:pagetemplate>
