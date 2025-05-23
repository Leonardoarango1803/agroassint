package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "descuentos_tardanza")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DescuentosTardanza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    private LocalDate fecha;
    private Double montoDescontado;

    @Column
    private String motivo = "Descuento por 3 tardanzas acumuladas";
}