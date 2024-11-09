package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AtualizacaoEmailDTO;
import com.DentalWareTeam.Oralytics.dto.AtualizacaoSenhaDTO;
import com.DentalWareTeam.Oralytics.dto.ListagemUsuarioDTO;
import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.mapper.UsuarioMapper;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<ListagemUsuarioDTO>> listarUsuarios (){
        List<ListagemUsuarioDTO> usuarios = usuarioService.listarUsuarios();
        List<ListagemUsuarioDTO> usuariosComLink = usuarios.stream().map(usuario -> {
            usuario.add(linkTo(methodOn(UsuarioController.class).obterUsuario(usuario.getId())).withSelfRel());
            return usuario;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(usuariosComLink);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListagemUsuarioDTO> obterUsuario (@PathVariable Integer id){
        Usuario usuario = usuarioService.lerUsuario(id);
        usuario.add(linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("Lista de Usuários"));
        return ResponseEntity.ok(UsuarioMapper.toListagemUsuarioDTO(usuario));
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
