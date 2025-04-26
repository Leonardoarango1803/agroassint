package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(unique = true, nullable = false)
    private String usuario;

    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private Integer intentos_fallidos = 0;
    private Boolean bloqueado = false;

    public enum Rol {
        administrador, trabajador
    }
}