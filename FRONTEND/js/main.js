$(document).ready(function(){

  $("#btn-send").click(function(){
        var imgFile = $('#input-file')[0].files[0];
        console.log(imgFile);
        sendFile(imgFile);
    
  });

}); 


function sendFile(imgFile) {
    //todo : check if file exists
    fd = new FormData();
    fd.append("file-img", imgFile);
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/palette',
        data: fd,
        success:function(data){
            console.log(data);
        },
        processData: false,
        contentType: false
    });
}
