package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AdicionarDadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.dto.DadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.model.user.Usuario;
import com.DentalWareTeam.Oralytics.repositories.UsuarioRepository;
import com.DentalWareTeam.Oralytics.services.DadoMonitoramentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

@Controller
@RequestMapping("/dados-monitoramento")
public class DadosMonitoramentoController {

    @Autowired
    private DadoMonitoramentoService dadoMonitoramentoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/salvar")
    public String adicionarDadoMonitoramento (@ModelAttribute @Valid AdicionarDadosMonitoramentoDTO dadosMonitoramentoDTO){
        dadoMonitoramentoService.salvarDadoMonitoramento(dadosMonitoramentoDTO);
        return "redirect:/dados-monitoramento";
    }

    @GetMapping
    public String listarDadosMonitoramento (Model model) {
        List <DadosMonitoramentoDTO> dados = dadoMonitoramentoService.listarDadosMonitoramento();
        model.addAttribute("dadosMonitoramento", dados);
        return "dados-monitoramento";
    }

    @GetMapping("/{id}")
    public String obterDadosMonitoramento (@PathVariable Integer id, Model model) {
        DadosMonitoramentoDTO dadoMonitoramento = dadoMonitoramentoService.lerDadoMonitoramento(id);
        model.addAttribute("dadoMonitoramento", dadoMonitoramento);
        return "detalhes-dado-monitoramento";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo (Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("dadoMonitoramento", new AdicionarDadosMonitoramentoDTO());
        return "formulario-dado-monitoramento";
    }

    @PostMapping("/deletar/{id}")
    public String apagarDadosMonitoramento(@PathVariable Integer id){
        dadoMonitoramentoService.apagarDadosMonitoramento(id);
        return "redirect: /dados-monitoramento";
    }
}
