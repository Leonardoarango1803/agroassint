package com.agroassint.Agroassint.Controller;

import com.agroassint.Agroassint.DTO.LoginRequest;
import com.agroassint.Agroassint.Models.Usuario;
import com.agroassint.Agroassint.Repositories.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")

@RequiredArgsConstructor
public class AuthController {
    private final UsuariosRepository usuariosRepository;

    @PostMapping("/login")
    public Usuario login(@RequestBody LoginRequest request) {
        Usuario usuario = usuariosRepository.findByUsuario(request.getUsuario());

        if (usuario == null || !usuario.getContraseña().equals(request.getContraseña())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Opcional: ocultar contraseña al devolver el usuario
        usuario.setContraseña("********");

        return usuario;
    }
}
