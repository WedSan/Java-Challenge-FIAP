package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.HistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.model.HistoricoDental;
import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.repositories.HistoricoDentalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HistoricoDentalService {

    private final HistoricoDentalRepository historicoDentalRepository;
    private final UsuarioService usuarioService;

    public HistoricoDentalService(HistoricoDentalRepository historicoDentalRepository, UsuarioService usuarioService) {
        this.historicoDentalRepository = historicoDentalRepository;
        this.usuarioService = usuarioService;
    }

    @Transactional
    public HistoricoDental salvarHistoricoDental (HistoricoDentalDTO historicoDentalDTO, Integer usuarioId) {
        HistoricoDental historicoDental = new HistoricoDental();
        historicoDental.setDataConsulta(historicoDentalDTO.getDataConsulta());
        historicoDental.setCondicaoDente(historicoDentalDTO.getCondicaoDente());
        Usuario usuario = usuarioService.lerUsuario(usuarioId);
        historicoDental.setUsuario(usuario);

        Set<ProcedimentoDentario> listaProcedimentosDentarios = historicoDental
                .getProcedimentosDentarios()
                .stream()
                .map(pd -> new ProcedimentoDentario(null,
                        pd.getProcedimento())).collect(Collectors.toSet());

        historicoDental.setProcedimentosDentarios(listaProcedimentosDentarios);

        return historicoDentalRepository.save(historicoDental);
    }
}
