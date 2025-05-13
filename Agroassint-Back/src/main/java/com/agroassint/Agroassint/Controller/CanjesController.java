package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.Models.Canjes;
import com.agroassint.Agroassint.Repositories.CanjesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canjes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CanjesController {

    private final CanjesRepository canjesRepository;

    @GetMapping
    public List<Canjes> listar() {
        return canjesRepository.findAll();
    }

    @PostMapping
    public Canjes crear(@RequestBody Canjes canje) {
        return canjesRepository.save(canje);
    }

    @PutMapping("/{id}")
    public Canjes actualizar(@PathVariable Integer id, @RequestBody Canjes canjeActualizado) {
        return canjesRepository.findById(id)
                .map(c -> {
                    c.setFechaCanje(canjeActualizado.getFechaCanje());
                    c.setDescripcion(canjeActualizado.getDescripcion());
                    c.setEstado(canjeActualizado.getEstado());
                    return canjesRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Canje no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        canjesRepository.deleteById(id);
    }
}