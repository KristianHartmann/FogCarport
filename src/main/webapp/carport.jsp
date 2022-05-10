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
            <h1 class="col offset-1">QUICKBYG</h1>
        </div>
        <div class="row" style="height: calc(100% - 55.97px)">
            <div class="col-3 offset-1">
                <div class="list-group" id="qb-list-tab" role="tablist">
                    <a class="list-group-item list-group-item-action active" id="list-qb-list" data-bs-toggle="list"
                       href="#list-qb" role="tab" aria-controls="list-qb">QUICKBYG</a>
                    <a class="list-group-item list-group-item-action" id="list-cpur-list" data-bs-toggle="list"
                       href="#list-cpur" role="tab" aria-controls="list-cpur">CARPORT MED FLADT TAG</a>
                    <a class="list-group-item list-group-item-action" id="list-cpmr-list" data-bs-toggle="list"
                       href="#list-cpmr" role="tab" aria-controls="list-cpmr">CARPORT MED REJSNING</a>
                    <a class="list-group-item list-group-item-action" id="list-stcp-list" data-bs-toggle="list"
                       href="#list-stcp" role="tab" aria-controls="list-stcp">STANDARD CARPORTE</a>
                </div>
            </div>
            <div class="vr p-0"></div>
            <div class="col-7">
                <div class="tab-content" style="height: 100%" id="qb-nav-tabContent">
                    <div class="tab-pane fade show active" id="list-qb" role="tabpanel"
                         aria-labelledby="list-qb-list">
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
                    <div class="tab-pane fade" id="list-cpur" role="tabpanel" aria-labelledby="list-cpur-list">
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
                                        <option value="" selected disabled hidden>Vælg bredde</option>
                                        <c:forEach begin="210" end="540" var="i" step="30">
                                            <option value="${i}">${i} cm</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group" id="cpshedlengthdiv" style="display: none">
                                    <labe for="cpshedlength">Redskabsrum længde:</labe>
                                    <select class="form-control" id="cpshedlength">
                                        <option value="" selected disabled hidden>Vælg længde</option>
                                        <c:forEach begin="150" end="390" var="i" step="30">
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
                    <div class="tab-pane fade" id="list-cpmr" role="tabpanel" aria-labelledby="list-cpmr-list">
                        <h1>under construction</h1>
                    </div>
                    <div class="tab-pane fade" id="list-stcp" role="tabpanel" aria-labelledby="list-stcp-list">
                        <div class="row">
                            <h3>Standard Carporte</h3>
                            <nav id="navbar-example2" class="navbar navbar-light px-3">
                                <ul class="nav nav-pills">
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#scrollspyHeading1">Enkelt</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#scrollspyHeading2">Dobbelt</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#scrollspyHeading3">Third</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#scrollspyHeading4">Fourth</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#scrollspyHeading5">Fifth</a>
                                    </li>
                                </ul>
                            </nav>
                            <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-offset="10" tabindex="0"
                                 class="scrollspy-example"
                                 style="overflow-y: scroll; height: 520px; position: relative">
                                <h4 id="scrollspyHeading1">Enkelt Carport</h4>
                                <hr class="mt-0">
                                <div class="row">
                                    <c:forEach begin="1" end="7" var="i">
                                        <div class="col-auto">
                                            <div class="card" style="width: 17rem; margin-bottom: 20px">
                                                <img src="images/ProductModel${i}.png" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                    <p class="card-text">Some quick example text to build on the card
                                                        title and make up the bulk of the card's content.</p>
                                                    <a href="#" class="btn btn-primary">Go somewhere</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <h5>KØB DIN NYE CARPORT HOS FOG</h5>
                                        <p>Vælg mellem vores mange standard Byg-Selv modeller eller lad os give dig et
                                            konkret tilbud på en carport i nøjagtig de mål, som du ønsker - med eller
                                            uden redskabsrum</p>
                                        <h5>STANDARD MODELLER</h5>
                                        <p>Leveres som Byg-selv sæt - usamlet og ubehandlet!
                                            Altid kvalitetsmaterialer.
                                            Udførlig byggevejledning til carport og spær medfølger.

                                            Levering i hele Danmark inden for ca. 10 hverdage.</p>
                                    </div>
                                    <div class="col">
                                        <h5>TILBEHØRSPAKKER</h5>
                                        <p>Vælg mellem en lang række tilkøbspakker til din carport. Det kan eksempelvis
                                            være tagrender, beklædning og tagbelægning.

                                            Se valgmuligheder på de enkelte produktsider.</p>
                                        <h5>CARPORT I TILPASSEDE MÅL?</h5>
                                        <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og
                                            udskrive en skitsetegning på en carport indenfor vores standardprogram - i
                                            de mål du ønsker.
                                            Tilbud og skitsetegning fremsendes med post hurtigst muligt.</p>
                                    </div>
                                 </div>
                                <h4 id="scrollspyHeading2">Dobbelt Carport</h4>
                                <hr class="mt-0">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus tristique, ligula
                                    eu viverra luctus, tellus nibh fringilla ligula, non auctor augue nibh eu leo. Ut
                                    faucibus condimentum laoreet. Mauris ornare ante vitae placerat bibendum.
                                    Suspendisse fringilla turpis lacus, non feugiat odio facilisis sed. Aliquam nec
                                    feugiat nunc. In tempus egestas sapien ut posuere. Nulla odio lectus, vehicula id
                                    viverra pellentesque, faucibus luctus tellus. Etiam laoreet consectetur dignissim.
                                    In auctor eros condimentum elit tempus, ut rutrum erat fringilla. Nullam in
                                    vulputate tortor.

                                    Proin ullamcorper vestibulum sem, ut commodo ante malesuada a. Quisque ac magna non
                                    neque sagittis luctus. Sed tempor tellus ligula, non <pharetr></pharetr>a urna auctor in.
                                    Vestibulum suscipit fermentum arcu, at bibendum libero egestas in. Pellentesque
                                    imperdiet, mi et euismod porttitor, metus ante ultrices erat, ac maximus tortor
                                    lacus a ligula. Fusce efficitur magna molestie sapien suscipit, sed dignissim mi
                                    condimentum. Aenean vel arcu quis mi malesuada pharetra a at metus. Fusce lobortis
                                    metus non magna congue sagittis. Integer sit amet dolor vel purus sollicitudin
                                    tincidunt. Praesent tincidunt molestie sem, eget vulputate nulla porttitor id.
                                    Integer justo libero, pulvinar vel leo eu, pretium varius odio.

                                    Suspendisse et luctus leo, non pretium est. Vestibulum ornare est metus, id euismod
                                    felis euismod eget. Suspendisse ac neque sed lectus fermentum vestibulum. Mauris sed
                                    massa sit amet diam convallis porta non vel diam. Nulla sed mi nibh. Nulla vitae
                                    lectus risus. Nunc est massa, dapibus in nulla sit amet, sollicitudin molestie eros.
                                    Nulla semper ligula sed nisi efficitur, nec egestas erat tempus. Nam dictum ligula
                                    felis, vehicula venenatis sem pellentesque eget. In lorem justo, tincidunt id neque
                                    ut, cursus vestibulum ligula. Nunc lacinia volutpat erat vitae hendrerit. Proin
                                    faucibus turpis ac magna posuere rhoncus vitae a nisl. Curabitur gravida, odio quis
                                    tincidunt semper, sapien ligula scelerisque enim, non feugiat leo ligula ut lectus.

                                    Suspendisse tincidunt, ipsum in suscipit rutrum, elit ligula aliquam orci, ut
                                    dignissim arcu lectus sit amet enim. Sed a dignissim tellus. Maecenas aliquet dolor
                                    ut neque suscipit dignissim. Donec arcu mi, semper nec porttitor sed, lacinia
                                    sagittis leo. Etiam interdum dui tristique ex efficitur, ut viverra neque fringilla.
                                    Nullam mattis tellus finibus nulla facilisis venenatis. Sed in tincidunt turpis.

                                    Morbi posuere nisi vitae luctus imperdiet. Aenean sit amet felis vel sem lobortis
                                    semper. Maecenas tellus ligula, scelerisque in porttitor id, venenatis in nunc.
                                    Integer finibus at velit eu finibus. Sed sed neque sagittis nisi finibus semper eget
                                    id magna. Phasellus mauris justo, lobortis et placerat a, aliquet nec nulla. Nulla
                                    eu dignissim diam. Sed et venenatis magna. Etiam aliquam massa id sem ultrices
                                    lacinia. Donec tincidunt, urna eu rhoncus pulvinar, felis nisl vulputate neque,
                                    vitae pellentesque urna est ac eros. Praesent felis dui, tincidunt non consectetur
                                    ac, dapibus sit amet arcu.</p>
                                <h4 id="scrollspyHeading3">Third heading</h4>
                                <hr>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus tristique, ligula
                                    eu viverra luctus, tellus nibh fringilla ligula, non auctor augue nibh eu leo. Ut
                                    faucibus condimentum laoreet. Mauris ornare ante vitae placerat bibendum.
                                    Suspendisse fringilla turpis lacus, non feugiat odio facilisis sed. Aliquam nec
                                    feugiat nunc. In tempus egestas sapien ut posuere. Nulla odio lectus, vehicula id
                                    viverra pellentesque, faucibus luctus tellus. Etiam laoreet consectetur dignissim.
                                    In auctor eros condimentum elit tempus, ut rutrum erat fringilla. Nullam in
                                    vulputate tortor.

                                    Proin ullamcorper vestibulum sem, ut commodo ante malesuada a. Quisque ac magna non
                                    neque sagittis luctus. Sed tempor tellus ligula, non pharetra urna auctor in.
                                    Vestibulum suscipit fermentum arcu, at bibendum libero egestas in. Pellentesque
                                    imperdiet, mi et euismod porttitor, metus ante ultrices erat, ac maximus tortor
                                    lacus a ligula. Fusce efficitur magna molestie sapien suscipit, sed dignissim mi
                                    condimentum. Aenean vel arcu quis mi malesuada pharetra a at metus. Fusce lobortis
                                    metus non magna congue sagittis. Integer sit amet dolor vel purus sollicitudin
                                    tincidunt. Praesent tincidunt molestie sem, eget vulputate nulla porttitor id.
                                    Integer justo libero, pulvinar vel leo eu, pretium varius odio.

                                    Suspendisse et luctus leo, non pretium est. Vestibulum ornare est metus, id euismod
                                    felis euismod eget. Suspendisse ac neque sed lectus fermentum vestibulum. Mauris sed
                                    massa sit amet diam convallis porta non vel diam. Nulla sed mi nibh. Nulla vitae
                                    lectus risus. Nunc est massa, dapibus in nulla sit amet, sollicitudin molestie eros.
                                    Nulla semper ligula sed nisi efficitur, nec egestas erat tempus. Nam dictum ligula
                                    felis, vehicula venenatis sem pellentesque eget. In lorem justo, tincidunt id neque
                                    ut, cursus vestibulum ligula. Nunc lacinia volutpat erat vitae hendrerit. Proin
                                    faucibus turpis ac magna posuere rhoncus vitae a nisl. Curabitur gravida, odio quis
                                    tincidunt semper, sapien ligula scelerisque enim, non feugiat leo ligula ut lectus.

                                    Suspendisse tincidunt, ipsum in suscipit rutrum, elit ligula aliquam orci, ut
                                    dignissim arcu lectus sit amet enim. Sed a dignissim tellus. Maecenas aliquet dolor
                                    ut neque suscipit dignissim. Donec arcu mi, semper nec porttitor sed, lacinia
                                    sagittis leo. Etiam interdum dui tristique ex efficitur, ut viverra neque fringilla.
                                    Nullam mattis tellus finibus nulla facilisis venenatis. Sed in tincidunt turpis.

                                    Morbi posuere nisi vitae luctus imperdiet. Aenean sit amet felis vel sem lobortis
                                    semper. Maecenas tellus ligula, scelerisque in porttitor id, venenatis in nunc.
                                    Integer finibus at velit eu finibus. Sed sed neque sagittis nisi finibus semper eget
                                    id magna. Phasellus mauris justo, lobortis et placerat a, aliquet nec nulla. Nulla
                                    eu dignissim diam. Sed et venenatis magna. Etiam aliquam massa id sem ultrices
                                    lacinia. Donec tincidunt, urna eu rhoncus pulvinar, felis nisl vulputate neque,
                                    vitae pellentesque urna est ac eros. Praesent felis dui, tincidunt non consectetur
                                    ac, dapibus sit amet arcu.</p>
                                <h4 id="scrollspyHeading4">Fourth heading</h4>
                                <hr>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus tristique, ligula
                                    eu viverra luctus, tellus nibh fringilla ligula, non auctor augue nibh eu leo. Ut
                                    faucibus condimentum laoreet. Mauris ornare ante vitae placerat bibendum.
                                    Suspendisse fringilla turpis lacus, non feugiat odio facilisis sed. Aliquam nec
                                    feugiat nunc. In tempus egestas sapien ut posuere. Nulla odio lectus, vehicula id
                                    viverra pellentesque, faucibus luctus tellus. Etiam laoreet consectetur dignissim.
                                    In auctor eros condimentum elit tempus, ut rutrum erat fringilla. Nullam in
                                    vulputate tortor.

                                    Proin ullamcorper vestibulum sem, ut commodo ante malesuada a. Quisque ac magna non
                                    neque sagittis luctus. Sed tempor tellus ligula, non pharetra urna auctor in.
                                    Vestibulum suscipit fermentum arcu, at bibendum libero egestas in. Pellentesque
                                    imperdiet, mi et euismod porttitor, metus ante ultrices erat, ac maximus tortor
                                    lacus a ligula. Fusce efficitur magna molestie sapien suscipit, sed dignissim mi
                                    condimentum. Aenean vel arcu quis mi malesuada pharetra a at metus. Fusce lobortis
                                    metus non magna congue sagittis. Integer sit amet dolor vel purus sollicitudin
                                    tincidunt. Praesent tincidunt molestie sem, eget vulputate nulla porttitor id.
                                    Integer justo libero, pulvinar vel leo eu, pretium varius odio.

                                    Suspendisse et luctus leo, non pretium est. Vestibulum ornare est metus, id euismod
                                    felis euismod eget. Suspendisse ac neque sed lectus fermentum vestibulum. Mauris sed
                                    massa sit amet diam convallis porta non vel diam. Nulla sed mi nibh. Nulla vitae
                                    lectus risus. Nunc est massa, dapibus in nulla sit amet, sollicitudin molestie eros.
                                    Nulla semper ligula sed nisi efficitur, nec egestas erat tempus. Nam dictum ligula
                                    felis, vehicula venenatis sem pellentesque eget. In lorem justo, tincidunt id neque
                                    ut, cursus vestibulum ligula. Nunc lacinia volutpat erat vitae hendrerit. Proin
                                    faucibus turpis ac magna posuere rhoncus vitae a nisl. Curabitur gravida, odio quis
                                    tincidunt semper, sapien ligula scelerisque enim, non feugiat leo ligula ut lectus.

                                    Suspendisse tincidunt, ipsum in suscipit rutrum, elit ligula aliquam orci, ut
                                    dignissim arcu lectus sit amet enim. Sed a dignissim tellus. Maecenas aliquet dolor
                                    ut neque suscipit dignissim. Donec arcu mi, semper nec porttitor sed, lacinia
                                    sagittis leo. Etiam interdum dui tristique ex efficitur, ut viverra neque fringilla.
                                    Nullam mattis tellus finibus nulla facilisis venenatis. Sed in tincidunt turpis.

                                    Morbi posuere nisi vitae luctus imperdiet. Aenean sit amet felis vel sem lobortis
                                    semper. Maecenas tellus ligula, scelerisque in porttitor id, venenatis in nunc.
                                    Integer finibus at velit eu finibus. Sed sed neque sagittis nisi finibus semper eget
                                    id magna. Phasellus mauris justo, lobortis et placerat a, aliquet nec nulla. Nulla
                                    eu dignissim diam. Sed et venenatis magna. Etiam aliquam massa id sem ultrices
                                    lacinia. Donec tincidunt, urna eu rhoncus pulvinar, felis nisl vulputate neque,
                                    vitae pellentesque urna est ac eros. Praesent felis dui, tincidunt non consectetur
                                    ac, dapibus sit amet arcu.</p>
                                <h4 id="scrollspyHeading5">Fifth heading</h4>
                                <hr>
                                <p>...</p>
                                <h4 id="scrollspyHeading6">Fifth heading</h4>
                                <hr>
                                <p>...</p>
                                <h4 id="scrollspyHeading7">Fifth heading</h4>
                                <hr>
                                <p>...</p>
                                <h4 id="scrollspyHeading8">Fifth heading</h4>
                                <hr>
                                <p>...</p>
                                <h4 id="scrollspyHeading9">Fifth heading</h4>
                                <hr>
                                <p>...</p>
                                <h4 id="scrollspyHeading10">Fifth heading</h4>
                                <hr>
                                <p>...</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>

</t:pagetemplate>
