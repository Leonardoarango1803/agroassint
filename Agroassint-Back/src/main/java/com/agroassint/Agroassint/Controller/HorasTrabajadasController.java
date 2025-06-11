package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.Models.HorasTrabajadas;
import com.agroassint.Agroassint.Repositories.HorasTrabajadasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horas-trabajadas")
@RequiredArgsConstructor

public class HorasTrabajadasController {

    private final HorasTrabajadasRepository horasTrabajadasRepository;

    @GetMapping
    public List<HorasTrabajadas> listar() {
        return horasTrabajadasRepository.findAll();
    }

    @PostMapping
    public HorasTrabajadas crear(@RequestBody HorasTrabajadas horasTrabajadas) {
        return horasTrabajadasRepository.save(horasTrabajadas);
    }

    @PutMapping("/{id}")
    public HorasTrabajadas actualizar(@PathVariable Integer id, @RequestBody HorasTrabajadas horasTrabajadasActualizada) {
        return horasTrabajadasRepository.findById(id)
                .map(ht -> {
                    ht.setFecha(horasTrabajadasActualizada.getFecha());
                    ht.setHorasNormales(horasTrabajadasActualizada.getHorasNormales());
                    ht.setHorasExtras(horasTrabajadasActualizada.getHorasExtras());
                    return horasTrabajadasRepository.save(ht);
                })
                .orElseThrow(() -> new RuntimeException("Horas trabajadas no encontradas"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        horasTrabajadasRepository.deleteById(id);
    }
}