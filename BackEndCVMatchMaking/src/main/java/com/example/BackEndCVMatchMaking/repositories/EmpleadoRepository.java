package com.example.BackEndCVMatchMaking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.BackEndCVMatchMaking.models.Empleado;

public interface EmpleadoRepository extends JpaRepository <Empleado, Integer> {

    @Query("SELECT e FROM Empleado e WHERE e.correo = :correo and e.contrasena = :contrasena")
    Optional<Empleado> loginEmpleado(@Param("correo")String correo, @Param("contrasena")String contrasena);
}
