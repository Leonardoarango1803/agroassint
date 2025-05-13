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
public class Canjes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private Integer puntosUsados;
    private LocalDate fechaCanje;

    // Agregar estos campos si los necesitas
    private String descripcion;  // Campo descripción
    private String estado;       // Campo estado
}
