package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "historial_asistencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorialAsistencias {
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
    @Column(name = "tipo_asistencia")  // Asegúrate de que el nombre de la columna coincida
    private TipoAsistencia tipoAsistencia;

    public enum TipoAsistencia {
        normal, tardanza, falta
    }
}
