package com.agroassint.Agroassint.Service;

import com.agroassint.Agroassint.Models.Usuario;
import com.agroassint.Agroassint.Repositories.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    public List<Usuario> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    public void eliminarUsuario(Integer id) {
        usuariosRepository.deleteById(id);
    }

    public Usuario buscarUsuarioPorId(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }
}