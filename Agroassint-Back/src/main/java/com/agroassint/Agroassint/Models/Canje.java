package com.agroassint.Agroassint.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "canjes")
@Data
public class Canje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private Integer puntos_usados;

    @Temporal(TemporalType.DATE)
    private Date fecha_canje;
}