package com.agroassint.Agroassint.Repositories;

// Repositories/AreaRepository.java

import com.agroassint.Agroassint.Models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
}
