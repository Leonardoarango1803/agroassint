package com.agroassint.Agroassint.Service;

import com.agroassint.Agroassint.Models.Asistencia;
import com.agroassint.Agroassint.Repositories.AsistenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsistenciasService {
    private final AsistenciaRepository asistenciasRepository;

    public List<Asistencia> listarAsistencias() {
        return asistenciasRepository.findAll();
    }

    public Asistencia guardarAsistencia(Asistencia asistencia) {
        return asistenciasRepository.save(asistencia);
    }

    public void eliminarAsistencia(Integer id) {
        asistenciasRepository.deleteById(id);
    }

    public Asistencia buscarAsistenciaPorId(Integer id) {
        return asistenciasRepository.findById(id).orElse(null);
    }
}