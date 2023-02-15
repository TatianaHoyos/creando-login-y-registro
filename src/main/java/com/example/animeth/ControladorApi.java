package com.example.animeth;

import com.example.animeth.model.Usuario;
import com.example.animeth.model.api.Response;
import com.example.animeth.model.exception.BussinessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorApi {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "api/registrar", produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> guardarUsuario(@RequestBody Usuario usuario){
        System.out.println("usuario");
        //usuarioService.guardarUsuario(usuario);
        System.out.println("se guardo un usuario" + usuario.toString());
        System.out.println("repeat password" );
        if (usuario.getNombre() != null && !usuario.getNombre().isEmpty() &&
        usuario.getApellido() != null && !usuario.getApellido().isEmpty() &&
        usuario.getCorreo() != null && !usuario.getCorreo().isEmpty() &&
        usuario.getUser() != null && !usuario.getUser().isEmpty() &&
        usuario.getPassword() != null && !usuario.getPassword().isEmpty()){
          try {
              usuarioService.guardarUsuario(usuario);
              return ResponseEntity.ok(new Response("Exito", "Registro exitoso"));
          } catch (BussinessError e) {
              return ResponseEntity.status(HttpStatus.CONFLICT)
                      .body(new Response("error", e.getMessage()));
          }
          catch (Exception e){
              e.printStackTrace();
              return ResponseEntity.internalServerError().body(new Response("error", "ocurrio un error inesperado"));
          }
        }else {
            return ResponseEntity.badRequest().body(new Response("error", "por favor validar datos"));

        }

    }
}
