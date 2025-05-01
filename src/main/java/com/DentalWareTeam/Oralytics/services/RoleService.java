package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.model.Role;
import com.DentalWareTeam.Oralytics.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> listarTodasRoles() {
        return roleRepository.findAll();
    }
}