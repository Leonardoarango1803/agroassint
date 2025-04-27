package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    private String correo;
    private String telefono;
    private String direccion;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    private String categoria;

    @Column(precision = 10, scale = 2)
    private Double salarioBase;

    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;
}