package com.agroassint.Agroassint.Controller;
import com.agroassint.Agroassint.Models.Usuario;
import com.agroassint.Agroassint.Repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuarioActualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setUsuario(usuarioActualizado.getUsuario());
                    usuario.setContraseña(usuarioActualizado.getContraseña());
                    usuario.setRol(usuarioActualizado.getRol());
                    usuario.setIntentosFallidos(usuarioActualizado.getIntentosFallidos());
                    usuario.setBloqueado(usuarioActualizado.getBloqueado());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
    }
}