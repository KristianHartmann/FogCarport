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
    $('#confirmOrderBtn').click(function (){
        $.ajax({
            url: './TestServlet',
            type: 'POST',
            data: {'msg': 'hello from the servlet'},
            success: function (response){
                $('#ajaxtest').html(response);
                $('#confirmModal').modal('show');
            }
        });
    });
})