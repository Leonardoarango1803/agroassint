package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "historial_asistencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorialAsistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private TipoAsistencia tipoAsistencia;

    public enum TipoAsistencia {
        normal, tardanza, falta
    }
}