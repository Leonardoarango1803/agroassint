package com.agroassint.Agroassint.Service;

import com.agroassint.Agroassint.Models.DescuentosTardanza;
import com.agroassint.Agroassint.Repositories.DescuentosTardanzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DescuentosTardanzaService {
    private final DescuentosTardanzaRepository descuentosTardanzaRepository;

    public List<DescuentosTardanza> listarDescuentos() {
        return descuentosTardanzaRepository.findAll();
    }

    public DescuentosTardanza guardarDescuento(DescuentosTardanza descuento) {
        return descuentosTardanzaRepository.save(descuento);
    }

    public void eliminarDescuento(Integer id) {
        descuentosTardanzaRepository.deleteById(id);
    }

    public DescuentosTardanza buscarDescuentoPorId(Integer id) {
        return descuentosTardanzaRepository.findById(id).orElse(null);
    }
}