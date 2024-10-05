package com.DentalWareTeam.Oralytics.controller;

import com.DentalWareTeam.Oralytics.dto.DadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.services.DadoMonitoramentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DadosMonitoramento")
public class DadosMonitoramentoController {

    @Autowired
    private DadoMonitoramentoService dadoMonitoramentoService;

    @PostMapping
    public ResponseEntity<DadosMonitoramentoDTO> adicionarDadoMonitoramento (@RequestBody @Valid DadosMonitoramentoDTO dadosMonitoramentoDTO){
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
        DadosMonitoramentoDTO dado = dadoMonitoramentoService.lerDadoMonitoramento(id);
        return ResponseEntity.ok(dado);
    }
}
