package com.DentalWareTeam.Oralytics.repositories;

import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseDentariaRepository extends JpaRepository<AnaliseDentaria, Integer> {

}
