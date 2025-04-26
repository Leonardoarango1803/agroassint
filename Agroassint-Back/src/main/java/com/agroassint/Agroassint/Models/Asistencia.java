package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "asistencias")
@Data
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private LocalTime hora_entrada;
    private LocalTime hora_salida;

    @Enumerated(EnumType.STRING)
    private TipoAsistencia tipo_asistencia = TipoAsistencia.normal;

    public enum TipoAsistencia {
        normal, tardanza, falta
    }
}