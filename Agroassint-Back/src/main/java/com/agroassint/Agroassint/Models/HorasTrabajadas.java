package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "horas_trabajadas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoraTrabajada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    private LocalDate fecha;
    private Double horasNormales;
    private Double horasExtras;
}