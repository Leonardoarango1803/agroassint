package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "canjes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Canje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private Integer puntosUsados;
    private LocalDate fechaCanje;
}