package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> adicionarUsuario (@RequestBody @Valid UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios (){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("email/{id}")
    public ResponseEntity<UsuarioDTO> atualizarEmail (@PathVariable Integer id, @PathVariable String email){
        UsuarioDTO usuario = usuarioService.atualizarEmail(id, email);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("senha/{id}")
    public ResponseEntity<UsuarioDTO> atualizarSenha (@PathVariable Integer id, @PathVariable String email){
        UsuarioDTO usuario = usuarioService.atualizarSenha(id, email);
        return ResponseEntity.ok(usuario);
    }
}
