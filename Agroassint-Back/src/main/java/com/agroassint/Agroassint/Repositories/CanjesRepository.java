package com.agroassint.Agroassint.Repositories;


import com.tuempresa.control_asistencia_agroindustrial.Models.Canjes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanjesRepository extends JpaRepository<Canjes, Integer> {
}