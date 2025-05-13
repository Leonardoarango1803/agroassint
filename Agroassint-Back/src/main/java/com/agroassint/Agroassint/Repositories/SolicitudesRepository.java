package com.agroassint.Agroassint.Repositories;

import com.agroassint.Agroassint.Models.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {
}