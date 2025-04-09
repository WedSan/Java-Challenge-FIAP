package com.DentalWareTeam.Oralytics.controllers;

import com.DentalWareTeam.Oralytics.dto.*;
import com.DentalWareTeam.Oralytics.exceptions.HistoricoDentalNotFoundException;
import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;
import com.DentalWareTeam.Oralytics.model.user.Usuario;
import com.DentalWareTeam.Oralytics.repositories.ProcedimentoDentarioRepository;
import com.DentalWareTeam.Oralytics.repositories.UsuarioRepository;
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

    @Autowired
    private ProcedimentoDentarioRepository procedimentoDentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Página inicial: lista todos os históricos dentários
    @GetMapping
    public String listarHistoricoDental(Model model) {
        List<HistoricoDentalDTO> historicoDentalList = historicoDentalService.listarHistoricoDental();
        model.addAttribute("historicoDentalList", historicoDentalList);
        return "historicos-dentais";
    }

    // Página para adicionar um novo histórico dental
    @GetMapping("/novo")
    public String mostrarFormularioDeCadastro(Model model) {
        List<ProcedimentoDentario> procedimentos = procedimentoDentarioRepository.findAll();
        List<Usuario> usuarios =  usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("historicoDentalDTO", new AdicionarHistoricoDentalDTO());
        model.addAttribute("procedimentos",procedimentos);
        return "formulario-historico-dental";
    }

    @PostMapping("/novo")
    public String salvarHistoricoDental(@Valid @ModelAttribute("historicoDentalDTO") AdicionarHistoricoDentalDTO historicoDentalDTO,
                                        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "formulario-historico-dental";
        } else {
            HistoricoDentalDTO historicoSalvo = historicoDentalService.salvarHistoricoDental(historicoDentalDTO);
            model.addAttribute("historicoSalvo", historicoSalvo);
            return "redirect:/historico";
        }

    }

    // Página para visualizar um histórico dental
    @GetMapping("/{id}")
    public String visualizarHistoricoDental(@PathVariable("id") Integer id, Model model) {
        try {
            HistoricoDentalDTO historicoDentalDTO = historicoDentalService.lerHistoricoDental(id);
            model.addAttribute("historicoDentalDTO", historicoDentalDTO);
            return "detalhes-historico-dental";
        } catch (HistoricoDentalNotFoundException e) {
            model.addAttribute("error", "Histórico Dental não encontrado.");
            return "error";
        }
    }

    // Página para excluir um histórico dental
    @GetMapping("/deletar/{id}")
    public String deletarHistoricoDental(@PathVariable("id") Integer id) {
        historicoDentalService.deletarHistoricoDental(id);
        return "redirect:/historico";
    }
}
