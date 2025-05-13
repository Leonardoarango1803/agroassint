package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "reportes_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double totalHorasNormales;
    private Double totalHorasExtras;
    private Double totalPago;
}