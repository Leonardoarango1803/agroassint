package com.agroassint.Agroassint.Service;

import com.agroassint.Agroassint.Models.Canjes;
import com.agroassint.Agroassint.Repositories.CanjesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CanjesService {
    private final CanjesRepository canjesRepository;

    public List<Canjes> listarCanjes() {
        return canjesRepository.findAll();
    }

    public Canjes guardarCanje(Canjes canje) {
        return canjesRepository.save(canje);
    }

    public void eliminarCanje(Integer id) {
        canjesRepository.deleteById(id);
    }

    public Canjes buscarCanjePorId(Integer id) {
        return canjesRepository.findById(id).orElse(null);
    }
}