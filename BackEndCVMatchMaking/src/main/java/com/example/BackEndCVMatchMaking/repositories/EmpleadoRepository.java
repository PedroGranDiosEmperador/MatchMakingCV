package com.example.BackEndCVMatchMaking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackEndCVMatchMaking.models.Empleado;

public interface EmpleadoRepository extends JpaRepository <Empleado, Integer> {

}
