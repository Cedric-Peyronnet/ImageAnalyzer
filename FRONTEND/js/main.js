$(document).ready(function(){

    $("#input-file").change(function() {
        readURL(this);
        var imgFile = $('#input-file')[0].files[0];
        sendFile(imgFile);
    });

    $("#upfile").click(function () {
        $("#input-file").trigger('click');
    });

}); 

function readURL(input) {
    if (input.files && input.files[0]) {
      var reader = new FileReader();
  
      reader.onload = function(e) {
        $('#img-display').attr('src', e.target.result);
      }
  
      reader.readAsDataURL(input.files[0]);
    }
}
  

function sendFile(imgFile) {
    //todo : check if file exists
    fd = new FormData();
    fd.append("file-img", imgFile);
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/palette',
        data: fd,
        success:function(data){
            var palette = $.parseJSON(data);
            displayPalette(palette.mainColor, palette.secondColor, palette.thirdColor);
        },
        processData: false,
        contentType: false
    });
}

function displayPalette(mainColor, secondColor, thirdColor) {
    $("#main").css('background-color', mainColor);
    $("#second").css('background-color', secondColor);
    $("#third").css('background-color', thirdColor);
}
