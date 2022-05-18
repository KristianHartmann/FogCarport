function showShed() {
    if (!(document.getElementById('cpshed').checked)) {
        document.getElementById('cpshedlengthdiv').style.display = "none";
        document.getElementById('cpshedwidthdiv').style.display = "none";
    } else {
        document.getElementById('cpshedlengthdiv').style.display = "block";
        document.getElementById('cpshedwidthdiv').style.display = "block";
    }
}

$(document).ready(function() {
    $('#confirmOrderForm').submit(function (e){ // vores bestil form's submit funktion
       e.preventDefault(); // sørger for at vores submit ikke laver et postback, det vil sige refresher vores side.

       var form = $(this); // sætter en variabel som indeholder vores form

        $.ajax({ // ajax er til for at vi kan fange et server response fra en servlet uden at skulle request.getDispatcher til en eller anden jsp side
            url: './' + form.attr('action'), // sætter urlen på requesten til at være vores forms action hvilket i dette tilfælde er TestServlet
            type: form.attr('method'), // sætter vores metode/method til vores forms metode/method som i dette tilfælde er post
            data: form.serialize(), // sætter den data vi gerne vil have med ind i TestServlet
            dataType: 'json', // vores data type for vores response, som vil være json, så vi kan få fat i de værdier vi nu vil sende tilbage til siden
            success: function (response){ // funktion for hvis ajax kaldet lykkedes, det parameter den får er vores response fra TestServlet
                $('#svgSideViewPreview').html(response.sideview);
                $('#svgTopViewPreview').html(response.topview);

                $('#confirmModal').modal('show'); // jQuery funktion der kan kalde vores modal så den kommer frem på skærmen
            }
        });
    });
})