package com.DentalWareTeam.Oralytics.repositories;

import com.DentalWareTeam.Oralytics.model.HistoricoDental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoDentalRepository extends JpaRepository <HistoricoDental, Integer> {
    boolean existsById(Integer historicoDentalId);
}
