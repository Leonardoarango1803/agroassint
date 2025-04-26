package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "historial_puntos")
@Data
public class HistorialPunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String motivo;
    private Integer puntos;
}