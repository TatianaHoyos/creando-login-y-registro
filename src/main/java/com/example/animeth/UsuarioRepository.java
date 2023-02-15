package com.example.animeth;

import com.example.animeth.model.Usuario;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Integer> {

    //@Transactional
    //@Modifying
    //@Query("FROM Usuario u WHERE u.user in ?1 AND u.password in ?2")
    Usuario findByUserAndPassword(String user, String Password);
    Usuario findByCorreo(String correo);
    Usuario findByCorreoOrUser(String correo, String user);


}
