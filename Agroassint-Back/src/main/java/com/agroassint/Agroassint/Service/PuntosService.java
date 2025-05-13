package com.agroassint.Agroassint.Service;
import com.agroassint.Agroassint.Models.Punto;
import com.agroassint.Agroassint.Repositories.PuntosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PuntosService {
    private final PuntosRepository puntosRepository;

    public List<Punto> listarPuntos() {
        return puntosRepository.findAll();
    }

    public Punto guardarPuntos(Punto puntos) {
        return puntosRepository.save(puntos);
    }

    public void eliminarPuntos(Integer id) {
        puntosRepository.deleteById(id);
    }

    public Punto buscarPuntosPorId(Integer id) {
        return puntosRepository.findById(id).orElse(null);
    }
}