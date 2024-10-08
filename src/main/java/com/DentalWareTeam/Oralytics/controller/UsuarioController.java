package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AtualizacaoEmailDTO;
import com.DentalWareTeam.Oralytics.dto.AtualizacaoSenhaDTO;
import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.mapper.UsuarioMapper;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios (){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> obterUsuario (@PathVariable Integer id){
        Usuario usuario = usuarioService.lerUsuario(id);
        return ResponseEntity.ok(UsuarioMapper.toDTO(usuario));
    }

    @PatchMapping("email/{id}")
    public ResponseEntity<UsuarioDTO> atualizarEmail(@PathVariable Integer id, @RequestBody AtualizacaoEmailDTO emailDTO){
        Usuario usuario = usuarioService.atualizarEmail(id, emailDTO.getNovoEmail());
        return ResponseEntity.ok(UsuarioMapper.toDTO(usuario));
    }

    @PatchMapping("senha/{id}")
    public ResponseEntity<UsuarioDTO> atualizarSenha(@PathVariable Integer id, @RequestBody AtualizacaoSenhaDTO senhaDTO){
        Usuario usuario = usuarioService.atualizarSenha(id, senhaDTO.getNovaSenha());
        return ResponseEntity.ok(UsuarioMapper.toDTO(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
