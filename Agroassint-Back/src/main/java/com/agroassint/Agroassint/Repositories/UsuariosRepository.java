package com.agroassint.Agroassint.Repositories;

import com.tuempresa.control_asistencia_agroindustrial.Models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
}