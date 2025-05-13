package com.agroassint.Agroassint.Service;

import com.agroassint.Agroassint.Models.HistorialAsistencias;
import com.agroassint.Agroassint.Repositories.HistorialAsistenciasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistorialAsistenciasService {
    private final HistorialAsistenciasRepository historialAsistenciasRepository;

    public List<HistorialAsistencias> listarHistorial() {
        return historialAsistenciasRepository.findAll();
    }

    public HistorialAsistencias guardarHistorial(HistorialAsistencias historial) {
        return historialAsistenciasRepository.save(historial);
    }

    public void eliminarHistorial(Integer id) {
        historialAsistenciasRepository.deleteById(id);
    }

    public HistorialAsistencias buscarHistorialPorId(Integer id) {
        return historialAsistenciasRepository.findById(id).orElse(null);
    }
}