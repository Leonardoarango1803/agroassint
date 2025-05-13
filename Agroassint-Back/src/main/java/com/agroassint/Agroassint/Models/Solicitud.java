package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private LocalDate fechaSolicitud;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado = EstadoSolicitud.pendiente;

    public enum EstadoSolicitud {
        pendiente, aprobado, rechazado
    }
}