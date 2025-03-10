package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AdicionarProcedimentosDentarioDTO;
import com.DentalWareTeam.Oralytics.dto.ProcedimentoDentarioDTO;
import com.DentalWareTeam.Oralytics.repositories.HistoricoDentalRepository;
import com.DentalWareTeam.Oralytics.services.ProcedimentoDentarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/procedimentos")
public class ProcedimentoDentarioController {

    @Autowired
    private ProcedimentoDentarioService procedimentoDentarioService;

    @Autowired
    private HistoricoDentalRepository historicoDentalRepository;

    @GetMapping
    public String listarProcedimentos(Model model) {
        List<ProcedimentoDentarioDTO> procedimentos = procedimentoDentarioService.listarTodosProcedimentos();
        model.addAttribute("procedimentos", procedimentos);
        return "procedimentos-dentarios";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("procedimento", new AdicionarProcedimentosDentarioDTO());
        model.addAttribute("historicos", historicoDentalRepository.findAll());
        return "formulario-procedimento-dentario";
    }

    @PostMapping("/salvar")
    public String salvarProcedimento(@ModelAttribute("procedimento") @Valid AdicionarProcedimentosDentarioDTO procedimentoDTO,
                                     BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formulario-procedimento-dentario";
        }
        procedimentoDentarioService.salvar(procedimentoDTO);
        return "redirect:/procedimentos";
    }


    @GetMapping("/excluir/{id}")
    public String excluirProcedimento(@PathVariable Integer id) {
        procedimentoDentarioService.excluir(id);
        return "redirect:/procedimentos";
    }
}

