package com.agroassint.Agroassint.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "puntos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Punto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    private Integer puntosAcumulados = 0;
    private LocalDate fechaUltimoRegistro;
}