package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "puntos")
@Data
public class Punto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    private Integer puntos_acumulados = 0;

    @Temporal(TemporalType.DATE)
    private Date fecha_ultimo_registro;
}