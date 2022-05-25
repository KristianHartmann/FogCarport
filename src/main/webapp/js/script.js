$('#isShed').change(function () {
    var radioShedVali = document.getElementsByClassName('radioShedVali');
    if (!(document.getElementById('isShed').checked)) {
        for (let i = 0; i < radioShedVali.length; i++) {
            radioShedVali.item(i).required = false;
        }
        document.getElementById('cpshedlengthdiv').style.display = "none";
        document.getElementById('cpshedwidthdiv').style.display = "none";
    } else {
        for (let i = 0; i < radioShedVali.length; i++) {
            radioShedVali.item(i).required = true;
        }
        document.getElementById('cpshedlengthdiv').style.display = "block";
        document.getElementById('cpshedwidthdiv').style.display = "block";
    }
});

$('#isRaised').change(function () {
    if (!(document.getElementById('isRaised').checked)) {
        document.getElementById('raisedRoofdiv').style.display = "none";
    } else {
        document.getElementById('raisedRoofdiv').style.display = "block";
    }
});

$('#requestCreateUserCheck').change(function () {
    if (!(document.getElementById('requestCreateUserCheck').checked)) {
        document.getElementById('requestCreateUserPassword').style.display = "none";
    } else {
        document.getElementById('requestCreateUserPassword').style.display = "block";
    }
    checkPasswordCheckbox();
});

function checkPasswordCheckbox(){
    var contactPassCheck = document.getElementById("requestCreateUserCheck");
    var passwordInput = document.getElementById("inputPassword");
    if (contactPassCheck.checked){
        passwordInput.required = true;
    }else{
        passwordInput.required = false;
    }
}

$('#isRequest').change(function (){
    var orderBtn = document.getElementById('orderBtn');
    var hiddenInput = document.getElementById('hiddenRequestInput');
    var isRequestInput = document.getElementById('isRequest');
    var contactInfo = document.getElementById('contactInfodiv');
    var requestInfoVali = document.getElementsByClassName('contactvali');
    if (isRequestInput.checked) {
        for (let i = 0; i < requestInfoVali.length; i++) {
            requestInfoVali.item(i).required = true;
        }
        contactInfo.style.display = "block";
        orderBtn.innerText = "Forespørg";
        hiddenInput.setAttribute('value', 'request');
        checkPasswordCheckbox();
    } else {
        for (let i = 0; i < requestInfoVali.length; i++) {
            requestInfoVali.item(i).required = false;
        }
        contactInfo.style.display = "none";
        orderBtn.innerText = "Bestil";
        hiddenInput.setAttribute('value', 'order');
    }
});

function checkShed() {
    let minLengthForShed = 510;
    let carportWidth = document.getElementById('cpwidth').value;
    let carportLength = document.getElementById('cplength').value;
    let shedLabel = document.getElementById('isShedLabel');
    let shedButton = document.getElementById('isShed');
    let shedMaxLength = carportLength - 390 - 30;
    $('#cpshedlength > option').each(function () {
        if ($(this).val() > shedMaxLength) {
            this.disabled = true;
        } else {
            this.disabled = false;
        }
    });
    let offValue = 0.25;
    for (let i = 1; i < 5; i++) {
        let radio = document.getElementById('inlineRadio' + i);
        radio.value = (carportWidth - 70) * offValue;
        radio.disabled = radio.value < 100;
        offValue = offValue + 0.25;
    }
    if (carportLength <= 0 || carportWidth <= 0) {
        shedButton.disabled = true;
    } else {
        if (carportLength < minLengthForShed) {
            shedButton.disabled = true;
        } else {
            shedButton.disabled = false;
        }
    }
    if (shedButton.disabled === true) {
        shedButton.checked = false;
        $('#isShed').trigger("change");
        if (carportLength <= 0 || carportWidth <= 0) {
            shedLabel.innerHTML = "Tilføj redskabskur (vælg længde og bredde først!)";
        } else {
            shedLabel.innerHTML = "Tilføj redskabskur (længde og bredde stemmer ikke overens!)";
        }
    } else {
        shedLabel.innerHTML = "Tilføj redskabskur";
    }
}

function formCheckboxCheck() {
    var isRaised = document.getElementById("isRaised");
    var isShed = document.getElementById("isShed");
    var cpshedlength = document.getElementById("cpshedlength");
    var roofangle = document.getElementById("roofangle");
    var rooftype = document.getElementById("rooftype");

    cpshedlength.required = !!isShed.checked;
    if (isRaised.checked) {
        rooftype.required = true;
        roofangle.required = true;
    } else {
        rooftype.required = false;
        roofangle.required = false;
    }
}

$(document).ready(function () {
    // popovers initialization
    const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]');
    const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl));

    // // toasts initialization
    // const toastElList = document.querySelectorAll('.toast');
    // const toastList = [...toastElList].map(toastEl => new bootstrap.Toast(toastEl, option));

    $('#isRequest').trigger("change");

    $('#profileOrderForm').submit(function (e) {
        e.preventDefault();

        var form = $(this);

        $.ajax({
            url: './' + form.attr('action'),
            type: form.attr('method'),
            data: form.serialize(),
            dataType: 'json',
            success: function (response) {
                $('#sideView-tab-pane').html(response.sideview);
                $('#topView-tab-pane').html(response.topview);
                $('#svgOrderModalLabel').html("Tegninger for ordre " + response.order)
                $('#offcanvasOrderLabel').html("Ordre " + response.order);
                $('#offcanvasOrder').offcanvas('show');
            }
        })
    });


    $('#confirmOrderForm').submit(function (e) { // vores bestil form's submit funktion

        formCheckboxCheck(); // checker om du har valgt raised roof eller skur

        e.preventDefault(); // sørger for at vores submit ikke laver et postback, det vil sige refresher vores side.

        var form = $(this); // sætter en variabel som indeholder vores form

        if ($(form)[0].checkValidity() === false) { // checker for om formen er blevet valideret eller ej
            e.stopPropagation();
        } else {
            $.ajax({ // ajax er til for at vi kan fange et server response fra en servlet uden at skulle request.getDispatcher til en eller anden jsp side
                url: './' + form.attr('action'), // sætter urlen på requesten til at være vores forms action hvilket i dette tilfælde er TestServlet
                type: form.attr('method'), // sætter vores metode/method til vores forms metode/method som i dette tilfælde er post
                data: form.serialize(), // sætter den data vi gerne vil have med ind i TestServlet
                dataType: 'json', // vores data type for vores response, som vil være json, så vi kan få fat i de værdier vi nu vil sende tilbage til siden
                success: function (response) { // funktion for hvis ajax kaldet lykkedes, det parameter den får er vores response fra TestServlet

                    $('#svgSideViewPreview').html(response.sideview);
                    $('#svgTopViewPreview').html(response.topview);
                    if(response.request === "false"){
                        $('#confirmModal').modal('show'); // jQuery funktion der kan kalde vores modal så den kommer frem på skærmen
                    }else{
                        alert(response.request);
                    }
                }
            });
        }
        $(form).addClass('was-validated');
    });
});