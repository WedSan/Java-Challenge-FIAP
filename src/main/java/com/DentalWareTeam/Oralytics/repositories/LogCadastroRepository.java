package com.DentalWareTeam.Oralytics.repositories;

import com.DentalWareTeam.Oralytics.model.LogCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogCadastroRepository extends JpaRepository<LogCadastro, Long> {
}
