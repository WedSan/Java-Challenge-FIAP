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

import java.util.List;

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
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosMonitoramentoDTO> obterDadosMonitoramento (@PathVariable Integer id) {
        DadoMonitoramento dadoMonitoramento = dadoMonitoramentoService.lerDadoMonitoramento(id);
        return ResponseEntity.ok(DadosMonitoramentoMapper.toDTO(dadoMonitoramento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarDadosMonitoramento(@PathVariable Integer id){
        dadoMonitoramentoService.apagarDadosMonitoramento(id);
        return ResponseEntity.noContent().build();
    }
}
