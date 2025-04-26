package com.agroassint.Agroassint.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "solicitudes")
@Data
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    private String tipo;
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha_solicitud;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.pendiente;

    public enum Estado {
        pendiente, aprobado, rechazado
    }
}
