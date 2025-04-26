package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.ListagemUsuarioDTO;
import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.services.UsuarioService;
import com.DentalWareTeam.Oralytics.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        model.addAttribute("roles", roleService.listarTodasRoles());
        return "formulario-usuario";
    }

    @PostMapping
    public String adicionarUsuario (@ModelAttribute("usuario") @Valid UsuarioDTO usuarioDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("roles", roleService.listarTodasRoles());
            return "formulario-usuario";
        }
        usuarioService.salvarUsuario(usuarioDTO);
        return "redirect:/usuarios";
    }

    @GetMapping("/atualizar/email/{id}")
    public String exibirFormularioAtualizarEmail(@PathVariable Integer id, Model model) {
        model.addAttribute("usuarioId", id);
        return "atualizar-email";
    }

    @PostMapping("/atualizar/email/{id}")
    public String atualizarEmail(@PathVariable Integer id, @RequestParam String novoEmail){
        usuarioService.atualizarEmail(id, novoEmail);
        return "redirect:/usuarios";
    }

    @GetMapping("/atualizar/senha/{id}")
    public String exibirFormularioAtualizarSenha(@PathVariable Integer id, Model model) {
        model.addAttribute("usuarioId", id);
        return "atualizar-senha";
    }

    @PostMapping("atualizar/senha/{id}")
    public String atualizarSenha(@PathVariable Integer id, @RequestParam String novaSenha){
        usuarioService.atualizarSenha(id, novaSenha);
        return "redirect:/usuarios";
    }


    @GetMapping
    public String listarUsuarios (Model model){
        List<ListagemUsuarioDTO> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }


    @GetMapping("/{id}")
    public String exibirDetalhesUsuario (@PathVariable Integer id, Model model){
        Usuario usuario = usuarioService.lerUsuario(id);
        model.addAttribute("usuario", usuario);
        return "detalhes-usuario";
    }


    @GetMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable("id") Integer id){
        usuarioService.deletarUsuario(id);
        return "redirect:/usuarios";
    }
}