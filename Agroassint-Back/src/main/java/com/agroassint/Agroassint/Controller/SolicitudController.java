package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.Models.Solicitud;
import com.agroassint.Agroassint.Repositories.SolicitudesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor

public class SolicitudController {

    private final SolicitudesRepository solicitudRepository;

    @GetMapping
    public List<Solicitud> listar() {
        return solicitudRepository.findAll();
    }

    @GetMapping("/empleado/{idEmpleado}")
    public List<Solicitud> listarPorEmpleado(@PathVariable Integer idEmpleado) {
        return solicitudRepository.findByEmpleadoId(idEmpleado);
    }

    @PostMapping
    public Solicitud crear(@RequestBody Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @PutMapping("/{id}")
    public Solicitud actualizar(@PathVariable Integer id, @RequestBody Solicitud solicitudActualizada) {
        return solicitudRepository.findById(id)
                .map(sol -> {
                    sol.setTipo(solicitudActualizada.getTipo());
                    sol.setDescripcion(solicitudActualizada.getDescripcion());
                    sol.setFechaSolicitud(solicitudActualizada.getFechaSolicitud());
                    sol.setEstado(solicitudActualizada.getEstado());
                    return solicitudRepository.save(sol);
                })
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        solicitudRepository.deleteById(id);
    }
}