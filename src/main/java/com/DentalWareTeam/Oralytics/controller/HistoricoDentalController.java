package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AdicionarHistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.dto.HistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.mapper.HistoricoDentalMapper;
import com.DentalWareTeam.Oralytics.model.HistoricoDental;
import com.DentalWareTeam.Oralytics.services.HistoricoDentalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico-dental")
public class HistoricoDentalController {

    @Autowired
    private HistoricoDentalService historicoDentalService;

    @PostMapping
    public ResponseEntity<HistoricoDentalDTO> adicionarHistoricoDental (@RequestBody @Valid AdicionarHistoricoDentalDTO historicoDentalDTO){
        HistoricoDentalDTO historico = historicoDentalService.salvarHistoricoDental(historicoDentalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(historico);
    }

    @GetMapping
    public ResponseEntity<List<HistoricoDentalDTO>> listarHistoricos () {
        List<HistoricoDentalDTO> historicos = historicoDentalService.listarHistoricoDental();
        return ResponseEntity.ok(historicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoDentalDTO> obterHistoricoDental (@PathVariable Integer id) {
        HistoricoDental historico = historicoDentalService.lerHistoricoDental(id);
        return ResponseEntity.ok(HistoricoDentalMapper.toDTO(historico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHistoricoDental(@PathVariable Integer id){
        historicoDentalService.deletarHistoricoDental(id);
        return ResponseEntity.noContent().build();
    }
}
