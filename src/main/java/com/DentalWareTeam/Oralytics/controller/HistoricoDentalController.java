package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AdicionarHistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.dto.HistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.model.HistoricoDental;
import com.DentalWareTeam.Oralytics.services.HistoricoDentalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/historico")
public class HistoricoDentalController {

    @Autowired
    private HistoricoDentalService historicoDentalService;

    @GetMapping
    public String listarHistoricos(Model model) {
        List<HistoricoDentalDTO> historicos = historicoDentalService.listarHistoricoDental();
        model.addAttribute("historicos", historicos);
        return "historicos-dentais";
    }

    @GetMapping("/{id}")
    public String obterHistoricoDental(@PathVariable Integer id, Model model) {
        HistoricoDental historico = historicoDentalService.lerHistoricoDental(id);
        model.addAttribute("historico", historico);
        return "detalhes-historico-dental";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("historicoDTO", new AdicionarHistoricoDentalDTO());
        return "formulario-historico-dental";
    }

    @PostMapping
    public String adicionarHistoricoDental(@ModelAttribute("historicoDTO") @Valid AdicionarHistoricoDentalDTO historicoDTO,
                                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formulario-historico-dental";
        }
        historicoDentalService.salvarHistoricoDental(historicoDTO);
        return "redirect:/historicos-dentais";
    }

    @PostMapping("/deletar/{id}")
    public String deletarHistoricoDental(@PathVariable Integer id) {
        historicoDentalService.deletarHistoricoDental(id);
        return "redirect:/historicos-dentais";
    }
}
