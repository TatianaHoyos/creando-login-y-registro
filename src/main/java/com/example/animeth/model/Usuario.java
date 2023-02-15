package com.example.animeth.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;

    @Column(unique=true, nullable=false)
    private String correo;
    @Column(unique=true, nullable=false)
    private String user;
    @Column(nullable = false)
    private String password;


    @Override
    public String toString() {
        return "" +
                "nombre=" + nombre + '\n' +
                "apellido=" + apellido + '\n' +
                "correo=" + correo + '\n' +
                "user=" + user + '\n' +
                "password "+ password + '\n';
    }
}
