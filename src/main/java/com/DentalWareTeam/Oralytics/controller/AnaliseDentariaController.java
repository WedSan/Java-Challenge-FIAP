package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;
import com.DentalWareTeam.Oralytics.services.AnaliseDentariaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AnaliseDentaria")
public class AnaliseDentariaController {

    @Autowired
    private AnaliseDentariaService analiseDentariaService;

    @PostMapping
    public ResponseEntity<AnaliseDentariaDTO> adicionarAnaliseDentaria (@RequestBody @Valid AnaliseDentariaDTO analiseDentariaDTO){
        AnaliseDentariaDTO novaAnaliseDentaria = analiseDentariaService.salvarAnaliseDentaria(analiseDentariaDTO);
        return ResponseEntity.ok(novaAnaliseDentaria);
    }

    @GetMapping
    public ResponseEntity<List<AnaliseDentariaDTO>> listarAnalisesDentarias () {
        List <AnaliseDentariaDTO> analises = analiseDentariaService.listarAnalisesDentarias();
        return ResponseEntity.ok(analises);
    }
}
