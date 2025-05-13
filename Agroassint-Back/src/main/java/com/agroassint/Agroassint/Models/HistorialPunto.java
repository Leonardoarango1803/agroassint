package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "historial_puntos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorialPunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    private LocalDate fecha;
    private String motivo;
    private Integer puntos;
}