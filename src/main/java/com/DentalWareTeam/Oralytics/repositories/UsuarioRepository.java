package com.DentalWareTeam.Oralytics.repositories;

import com.DentalWareTeam.Oralytics.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
