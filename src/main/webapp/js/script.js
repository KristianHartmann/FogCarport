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
    $('#confirmOrderForm').submit(function (e){
       e.preventDefault();

       var form = $(this);

        $.ajax({
            url: './' + form.attr('action'),
            type: form.attr('method'),
            data: form.serialize(),
            success: function (response){
                $
                $('#ajaxtest').html("this comes from the servlet :" + JSON.stringify(response));
                $('#confirmModal').modal('show');
            }
        });

    });
})