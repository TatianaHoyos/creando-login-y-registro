 $(document).ready(function(){
          $("#contenedorRegistrar").hide();
          $("#alertErrorRegistrar").hide();

    $("#tab-login").click(function(){
      $("#contenedorRegistrar").hide();
      $("#contenedorLogin").show();
    });

    $("#tab-register").click(function(){
      $("#contenedorLogin").hide();
      $("#contenedorRegistrar").show();
    });

    $("#btn-registrar").click(function(event){
      event.preventDefault();

      var formData = {
        nombre:$("#registerName").val(),
        apellido:$("#registerApellidos").val(),
        correo:$("#registerEmail").val(),
        user:$("#registerUsername").val(),
        password:$("#registerPassword").val(),
      };

      if($("#registerPassword").val() != $("#registerRepeatPassword").val()) {
        $("#alertErrorRegistrar").show();
        $("#alertErrorRegistrar").text("Las contraseñas no coinciden");
        return;
      }

      var onExito = function(data){
              $("#alertErrorRegistrar").removeClass("alert-danger");
              $("#alertErrorRegistrar").addClass("alert-success");
              $("#alertErrorRegistrar").show();
              $("#alertErrorRegistrar").text(data.message);
            };

      var onError = function(error){
              $("#alertErrorRegistrar").removeClass("alert-success");
              $("#alertErrorRegistrar").addClass("alert-danger");
              $("#alertErrorRegistrar").show();
              $("#alertErrorRegistrar").text(error.responseJSON.message);
            };

      var settings = {
        "url": "http://localhost:8080/api/registrar",
        "method": "POST",
        "timeout": 0,
        "headers": {
          "Content-Type": "application/json"
        },
        "data": JSON.stringify(formData),
        success: onExito,
        error: onError



       ,
      };

      $.ajax(settings).done(function (response) {
        console.log(response);
      });

    });
  });