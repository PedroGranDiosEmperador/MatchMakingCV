package com.example.BackEndCVMatchMaking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.BackEndCVMatchMaking.models.Empleado;
import com.example.BackEndCVMatchMaking.models.Empresa;

public interface EmpresaRepository extends JpaRepository <Empresa, Integer>{

    @Query("SELECT e FROM Empresa e WHERE e.correo = :correo and e.contrasena = :contrasena")
    Optional<Empresa> loginEmpresa(@Param("correo")String correo, @Param("contrasena")String contrasena);
}
