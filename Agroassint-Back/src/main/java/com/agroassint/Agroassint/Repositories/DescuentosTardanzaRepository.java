package com.agroassint.Agroassint.Repositories;


import com.agroassint.Agroassint.Models.DescuentosTardanza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentosTardanzaRepository extends JpaRepository<DescuentosTardanza, Integer> {
}