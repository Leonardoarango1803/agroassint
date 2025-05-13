package com.agroassint.Agroassint.Repositories;

import com.agroassint.Agroassint.Models.Punto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntosRepository extends JpaRepository<Punto, Integer> {
}