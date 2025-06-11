package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.Models.HistorialAsistencias;
import com.agroassint.Agroassint.Repositories.HistorialAsistenciasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial-asistencias")
@RequiredArgsConstructor

public class HistorialAsistenciasController {

    private final HistorialAsistenciasRepository historialAsistenciasRepository;

    @GetMapping
    public List<HistorialAsistencias> listar() {
        return historialAsistenciasRepository.findAll();
    }

    @PostMapping
    public HistorialAsistencias crear(@RequestBody HistorialAsistencias historial) {
        return historialAsistenciasRepository.save(historial);
    }

    @PutMapping("/{id}")
    public HistorialAsistencias actualizar(@PathVariable Integer id, @RequestBody HistorialAsistencias historialActualizado) {
        return historialAsistenciasRepository.findById(id)
                .map(h -> {
                    h.setFecha(historialActualizado.getFecha());
                    h.setHoraEntrada(historialActualizado.getHoraEntrada());
                    h.setHoraSalida(historialActualizado.getHoraSalida());
                    h.setTipoAsistencia(historialActualizado.getTipoAsistencia()); // Aquí es setTipoAsistencia, no setTipo
                    return historialAsistenciasRepository.save(h);
                })
                .orElseThrow(() -> new RuntimeException("Historial de asistencia no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        historialAsistenciasRepository.deleteById(id);
    }
}
