package com.agroassint.Agroassint.Service;

import com.agroassint.Agroassint.Models.Area; // Asegúrate de importar tu modelo 'Area'
import com.agroassint.Agroassint.Repositories.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreasService {
    private final AreaRepository areasRepository;

    public List<Area> listarAreas() {
        return areasRepository.findAll();
    }

    public Area guardarArea(Area area) {
        return areasRepository.save(area);
    }

    public void eliminarArea(Integer id) {
        areasRepository.deleteById(id);
    }

    public Area buscarAreaPorId(Integer id) {
        return areasRepository.findById(id).orElse(null);
    }
}
