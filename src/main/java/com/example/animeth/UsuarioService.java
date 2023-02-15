package com.example.animeth;

import com.example.animeth.model.Usuario;
import com.example.animeth.model.exception.BussinessError;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public void guardarUsuario(Usuario usuario) throws BussinessError {
       Usuario obtenerUsuarioDB = usuarioRepository.findByCorreoOrUser(usuario.getCorreo(),usuario.getUser());
       if (obtenerUsuarioDB != null){
           if (obtenerUsuarioDB.getUser() != null && obtenerUsuarioDB.getUser().equals(usuario.getUser())){
               throw new BussinessError("Ya existe el usuario");
           }else if (obtenerUsuarioDB.getCorreo() != null && obtenerUsuarioDB.getCorreo().equals(usuario.getCorreo())){
               throw new BussinessError("Ya existe el correo");
           }

       }
       usuarioRepository.save(usuario);

    }

    public Usuario obtenerUsuario(String user, String pass){
        return usuarioRepository.findByUserAndPassword(user,pass);
    }
}
