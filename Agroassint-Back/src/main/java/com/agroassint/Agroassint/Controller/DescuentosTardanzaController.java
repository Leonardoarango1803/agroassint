package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.Models.DescuentosTardanza;
import com.agroassint.Agroassint.Repositories.DescuentosTardanzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descuentos-tardanza")
@RequiredArgsConstructor

public class DescuentosTardanzaController {

    private final DescuentosTardanzaRepository descuentosTardanzaRepository;

    @GetMapping
    public List<DescuentosTardanza> listar() {
        return descuentosTardanzaRepository.findAll();
    }

    @PostMapping
    public DescuentosTardanza crear(@RequestBody DescuentosTardanza descuento) {
        return descuentosTardanzaRepository.save(descuento);
    }

    @PutMapping("/{id}")
    public DescuentosTardanza actualizar(@PathVariable Integer id, @RequestBody DescuentosTardanza descuentoActualizado) {
        return descuentosTardanzaRepository.findById(id)
                .map(d -> {
                    d.setFecha(descuentoActualizado.getFecha());
                    d.setMontoDescontado(descuentoActualizado.getMontoDescontado()); // Nombre correcto
                    d.setMotivo(descuentoActualizado.getMotivo());
                    return descuentosTardanzaRepository.save(d);
                })
                .orElseThrow(() -> new RuntimeException("Descuento no encontrado"));
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        descuentosTardanzaRepository.deleteById(id);
    }
}