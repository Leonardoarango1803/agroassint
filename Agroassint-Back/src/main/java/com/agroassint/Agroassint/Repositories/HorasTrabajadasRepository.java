package com.agroassint.Agroassint.Repositories;

import com.agroassint.Agroassint.Models.HorasTrabajadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasTrabajadasRepository extends JpaRepository<HorasTrabajadas, Integer> {
}