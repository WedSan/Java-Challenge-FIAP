package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AdicionarAnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.dto.AnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;
import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import com.DentalWareTeam.Oralytics.services.AnaliseDentariaService;
import com.DentalWareTeam.Oralytics.services.DadoMonitoramentoService;
import com.DentalWareTeam.Oralytics.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/analises-dentarias")
public class AnaliseDentariaController {

    @Autowired
    private AnaliseDentariaService analiseDentariaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DadoMonitoramentoService dadoMonitoramentoService;

    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("analiseDentaria", new AdicionarAnaliseDentariaDTO());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("dadosMonitoramento", dadoMonitoramentoService.listarDadosMonitoramento());
        return "formulario-analise-dentaria";
    }

    @PostMapping
    public String adicionarAnaliseDentaria(@ModelAttribute("analiseDentaria") @Valid AdicionarAnaliseDentariaDTO analiseDentariaDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "formulario-analise-dentaria";
        }

        analiseDentariaService.salvarAnaliseDentaria(analiseDentariaDTO);
        return "redirect:/analises-dentarias";
    }

    @GetMapping
    public String listarAnalisesDentarias(Model model) {
        List<AnaliseDentariaDTO> analises = analiseDentariaService.listarAnalisesDentarias();
        model.addAttribute("analisesDentarias", analises);
        return "analises-dentarias";
    }

    @GetMapping("/{id}")
    public String exibirDetalhesAnaliseDentaria(@PathVariable Integer id, Model model) {
        try {
            AnaliseDentaria analiseDentaria = analiseDentariaService.lerAnaliseDentaria(id);
            model.addAttribute("analiseDentaria", analiseDentaria);
        } catch (EntityNotFoundException e) {
            model.addAttribute("erro", "Análise Dentária não encontrada");
            return "erro";
        }
        return "detalhes-analise-dentaria";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAnaliseDentaria(@PathVariable("id") Integer id) {
        try {
            analiseDentariaService.apagarAnaliseDentaria(id);
        } catch (EntityNotFoundException e) {
            return "redirect:/analises-dentarias?erro=AnáliseDentariaNaoEncontrada";
        }
        return "redirect:/analises-dentarias";
    }

}
