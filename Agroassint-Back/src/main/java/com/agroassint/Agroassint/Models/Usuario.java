package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private Integer intentosFallidos = 0;
    private Boolean bloqueado = false;

    public enum Rol {
        administrador, trabajador
    }
}