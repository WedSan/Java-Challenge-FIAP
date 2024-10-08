package com.DentalWareTeam.Oralytics.repositories;

import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadoMonitoramentoRepository extends JpaRepository<DadoMonitoramento, Integer> {

}
