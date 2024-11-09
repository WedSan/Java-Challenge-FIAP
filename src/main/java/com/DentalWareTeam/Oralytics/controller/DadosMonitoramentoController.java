package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.AdicionarDadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.dto.DadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.mapper.DadosMonitoramentoMapper;
import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import com.DentalWareTeam.Oralytics.services.DadoMonitoramentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dados-monitoramento")
public class DadosMonitoramentoController {

    @Autowired
    private DadoMonitoramentoService dadoMonitoramentoService;

    @PostMapping
    public ResponseEntity<DadosMonitoramentoDTO> adicionarDadoMonitoramento (@RequestBody @Valid AdicionarDadosMonitoramentoDTO dadosMonitoramentoDTO){
        DadosMonitoramentoDTO dadoMonitoramento = dadoMonitoramentoService.salvarDadoMonitoramento(dadosMonitoramentoDTO);
        return ResponseEntity.ok(dadoMonitoramento);
    }

    @GetMapping
    public ResponseEntity<List<DadosMonitoramentoDTO>> listarDadosMonitoramento () {
        List <DadosMonitoramentoDTO> dados = dadoMonitoramentoService.listarDadosMonitoramento();
        List <DadosMonitoramentoDTO> dadosComLinks = dados.stream().map(dado -> {
            dado.add(linkTo(methodOn(DadosMonitoramentoController.class).obterDadosMonitoramento(dado.getId())).withSelfRel());
            return dado;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dadosComLinks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosMonitoramentoDTO> obterDadosMonitoramento (@PathVariable Integer id) {
        DadoMonitoramento dadoMonitoramento = dadoMonitoramentoService.lerDadoMonitoramento(id);
        dadoMonitoramento.add(linkTo(methodOn(DadosMonitoramentoController.class).listarDadosMonitoramento()).withRel("Lista de Análises"));
        return ResponseEntity.ok(DadosMonitoramentoMapper.toDTO(dadoMonitoramento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarDadosMonitoramento(@PathVariable Integer id){
        dadoMonitoramentoService.apagarDadosMonitoramento(id);
        return ResponseEntity.noContent().build();
    }
}
