package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.Repositories.AreaRepository;

import com.agroassint.Agroassint.Models.Area;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/areas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AreaController {

    private final AreaRepository areaRepository;

    @GetMapping
    public List<Area> listar() {
        return areaRepository.findAll();
    }

    @PostMapping
    public Area crear(@RequestBody Area area) {
        return areaRepository.save(area);
    }

    @PutMapping("/{id}")
    public Area actualizar(@PathVariable Integer id, @RequestBody Area areaActualizada) {
        return areaRepository.findById(id)
                .map(area -> {
                    area.setNombre(areaActualizada.getNombre());
                    return areaRepository.save(area);
                })
                .orElseThrow(() -> new RuntimeException("Área no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        areaRepository.deleteById(id);
    }
}