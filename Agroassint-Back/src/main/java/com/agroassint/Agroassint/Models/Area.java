package com.agroassint.Agroassint.Models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "areas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;
}