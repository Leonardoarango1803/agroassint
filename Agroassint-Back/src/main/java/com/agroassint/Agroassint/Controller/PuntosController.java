package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.Models.Punto;
import com.agroassint.Agroassint.Repositories.PuntosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puntos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PuntosController {

    private final PuntosRepository puntosRepository;

    @GetMapping
    public List<Punto> listar() {
        return puntosRepository.findAll();
    }

    @PostMapping
    public Punto crear(@RequestBody Punto puntos) {
        return puntosRepository.save(puntos);
    }

    @PutMapping("/{id}")
    public Punto actualizar(@PathVariable Integer id, @RequestBody Punto puntosActualizados) {
        return puntosRepository.findById(id)
                .map(p -> {
                    p.setPuntosAcumulados(puntosActualizados.getPuntosAcumulados());
                    p.setFechaUltimoRegistro(puntosActualizados.getFechaUltimoRegistro());
                    return puntosRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Puntos no encontrados"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        puntosRepository.deleteById(id);
    }
}
