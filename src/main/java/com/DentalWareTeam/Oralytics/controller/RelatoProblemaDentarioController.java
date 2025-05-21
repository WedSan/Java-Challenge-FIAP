package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AdicionarRelatoProblemaDentarioDTO;
import com.DentalWareTeam.Oralytics.dto.RelatoProblemaDentarioDTO;
import com.DentalWareTeam.Oralytics.service.RelatoProblemaDentarioService;
import com.DentalWareTeam.Oralytics.services.DadoMonitoramentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/relatos-problema-dentario")
public class RelatoProblemaDentarioController {

    @Autowired
    private RelatoProblemaDentarioService relatoProblemaDentarioService;

    @Autowired
    private DadoMonitoramentoService dadoMonitoramentoService;

    @GetMapping
    public String listarRelatos(Model model) {
        List<RelatoProblemaDentarioDTO> relatos = relatoProblemaDentarioService.listarTodosRelatos();
        model.addAttribute("relatos", relatos);
        return "relatos-problema-dentario";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("dadosMonitoramento", dadoMonitoramentoService.listarDadosMonitoramento());
        model.addAttribute("adicionarRelatoProblemaDentarioDTO", new AdicionarRelatoProblemaDentarioDTO());
        return "formulario-relato-problema-dentario";
    }

    @PostMapping("/salvar")
    public String salvarRelato(@ModelAttribute @Valid AdicionarRelatoProblemaDentarioDTO dto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("dadosMonitoramento", dadoMonitoramentoService.listarDadosMonitoramento());
            return "formulario-relato-problema-dentario";
        }
        RelatoProblemaDentarioDTO relatoSalvo = relatoProblemaDentarioService.salvarRelato(dto);
        return "redirect:/relatos-problema-dentario";
    }

    @GetMapping("/{id}")
    public String exibirDetalhes(@PathVariable Integer id, Model model) {
        try {
            RelatoProblemaDentarioDTO relato = relatoProblemaDentarioService.encontrarRelatoPorId(id);
            model.addAttribute("relato", relato);
            return "detalhes-relato-problema-dentario";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "erro";
        }
    }

    @PostMapping("/deletar/{id}")
    public String deletarRelato(@PathVariable Integer id) {
        relatoProblemaDentarioService.excluirRelato(id);
        return "redirect:/relatos-problema-dentario";
    }
}
