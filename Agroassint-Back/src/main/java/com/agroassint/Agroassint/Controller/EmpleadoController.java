package com.agroassint.Agroassint.Controller;



import com.agroassint.Agroassint.Models.Empleados;
import com.agroassint.Agroassint.Repositories.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor

public class EmpleadoController {

    private final EmpleadosRepository empleadoRepository;

    @GetMapping
    public List<Empleados> listar() {
        return empleadoRepository.findAll();
    }

    @PostMapping
    public Empleados crear(@RequestBody Empleados empleado) {
        return empleadoRepository.save(empleado);
    }

    @PutMapping("/{id}")
    public Empleados actualizar(@PathVariable Integer id, @RequestBody Empleados empleadoActualizado) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setDni(empleadoActualizado.getDni());
                    empleado.setNombres(empleadoActualizado.getNombres());
                    empleado.setApellidos(empleadoActualizado.getApellidos());
                    empleado.setCorreo(empleadoActualizado.getCorreo());
                    empleado.setTelefono(empleadoActualizado.getTelefono());
                    empleado.setDireccion(empleadoActualizado.getDireccion());
                    empleado.setFechaIngreso(empleadoActualizado.getFechaIngreso());
                    empleado.setCategoria(empleadoActualizado.getCategoria());
                    empleado.setSalarioBase(empleadoActualizado.getSalarioBase());
                    empleado.setArea(empleadoActualizado.getArea());
                    return empleadoRepository.save(empleado);
                })
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        empleadoRepository.deleteById(id);
    }
}