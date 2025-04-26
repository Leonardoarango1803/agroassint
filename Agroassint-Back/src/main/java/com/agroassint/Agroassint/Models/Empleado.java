package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "empleados")
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String dni;

    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String direccion;

    @Temporal(TemporalType.DATE)
    private Date fecha_ingreso;

    private String categoria;
    private Double salario_base;

    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;
}