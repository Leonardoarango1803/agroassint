package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.Models.Asistencia;
import com.agroassint.Agroassint.Repositories.AsistenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AsistenciaController {

    private final AsistenciaRepository asistenciaRepository;

    @GetMapping
    public List<Asistencia> listar() {
        return asistenciaRepository.findAll();
    }

    @PostMapping
    public Asistencia crear(@RequestBody Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @PutMapping("/{id}")
    public Asistencia actualizar(@PathVariable Integer id, @RequestBody Asistencia asistenciaActualizada) {
        return asistenciaRepository.findById(id)
                .map(asistencia -> {
                    asistencia.setFecha(asistenciaActualizada.getFecha());
                    asistencia.setHoraEntrada(asistenciaActualizada.getHoraEntrada());
                    asistencia.setHoraSalida(asistenciaActualizada.getHoraSalida());
                    asistencia.setTipoAsistencia(asistenciaActualizada.getTipoAsistencia());
                    return asistenciaRepository.save(asistencia);
                })
                .orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        asistenciaRepository.deleteById(id);
    }
}