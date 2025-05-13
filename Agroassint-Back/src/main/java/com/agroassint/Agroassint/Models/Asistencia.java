package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "asistencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

    @Enumerated(EnumType.STRING)
    private TipoAsistencia tipoAsistencia = TipoAsistencia.normal;

    public enum TipoAsistencia {
        normal, tardanza, falta
    }
}