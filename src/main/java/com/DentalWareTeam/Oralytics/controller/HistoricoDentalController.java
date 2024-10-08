package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.HistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.services.HistoricoDentalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicoDental")
public class HistoricoDentalController {

    @Autowired
    private HistoricoDentalService historicoDentalService;

    @PostMapping
    public ResponseEntity<HistoricoDentalDTO> adicionarHistoricoDental (@RequestBody @Valid HistoricoDentalDTO historicoDentalDTO){
        HistoricoDentalDTO historico = historicoDentalService.salvarHistoricoDental(historicoDentalDTO);
        return ResponseEntity.ok(historico);
    }

    @GetMapping
    public ResponseEntity<List<HistoricoDentalDTO>> listarHistoricos () {
        List<HistoricoDentalDTO> historicos = historicoDentalService.listarHistoricoDental();
        return ResponseEntity.ok(historicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoDentalDTO> obterHistoricoDental (@PathVariable Integer id) {
        HistoricoDentalDTO historico = historicoDentalService.lerHistoricoDental(id);
        return ResponseEntity.ok(historico);
    }
}
