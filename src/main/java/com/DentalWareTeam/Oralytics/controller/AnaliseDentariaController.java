package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AdicionarAnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.dto.AnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.mapper.AnaliseDentariaMapper;
import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;
import com.DentalWareTeam.Oralytics.services.AnaliseDentariaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/analise-dentaria")
public class AnaliseDentariaController {

    @Autowired
    private AnaliseDentariaService analiseDentariaService;

    @PostMapping
    public ResponseEntity<AnaliseDentariaDTO> adicionarAnaliseDentaria (@RequestBody @Valid AdicionarAnaliseDentariaDTO analiseDentariaDTO){
        AnaliseDentariaDTO novaAnaliseDentaria = analiseDentariaService.salvarAnaliseDentaria(analiseDentariaDTO);
        return ResponseEntity.ok(novaAnaliseDentaria);
    }

    @GetMapping
    public ResponseEntity<List<AnaliseDentariaDTO>> listarAnalisesDentarias () {
        List <AnaliseDentariaDTO> analises = analiseDentariaService.listarAnalisesDentarias();
        List<AnaliseDentariaDTO> analisesComLinks = analises.stream().map(analise -> {
            analise.add(linkTo(methodOn(AnaliseDentariaController.class).obterAnaliseDentaria(analise.getId())).withSelfRel());
            return analise;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(analisesComLinks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnaliseDentariaDTO> obterAnaliseDentaria (@PathVariable Integer id) {
        AnaliseDentaria analiseDentaria = analiseDentariaService.lerAnaliseDentaria(id);
        analiseDentaria.add(linkTo(methodOn(AnaliseDentariaController.class).listarAnalisesDentarias()).withRel("Lista de Análises"));
        return ResponseEntity.ok(AnaliseDentariaMapper.toDTO(analiseDentaria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarAnaliseDentaria(@PathVariable Integer id) {
        analiseDentariaService.apagarAnaliseDentaria(id);
        return ResponseEntity.noContent().build();
    }
}
