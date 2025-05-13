package com.agroassint.Agroassint.Service;

import com.agroassint.Agroassint.Models.Empleados;
import com.agroassint.Agroassint.Repositories.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadosService {
    private final EmpleadosRepository empleadosRepository;

    public List<Empleados> listarEmpleados() {
        return empleadosRepository.findAll();
    }

    public Empleados guardarEmpleado(Empleados empleado) {
        return empleadosRepository.save(empleado);
    }

    public void eliminarEmpleado(Integer id) {
        empleadosRepository.deleteById(id);
    }

    public Empleados buscarEmpleadoPorId(Integer id) {
        return empleadosRepository.findById(id).orElse(null);
    }
}