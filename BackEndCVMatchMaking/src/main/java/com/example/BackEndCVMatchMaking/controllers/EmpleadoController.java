package com.example.BackEndCVMatchMaking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEndCVMatchMaking.models.Empleado;
import com.example.BackEndCVMatchMaking.models.Empresa;
import com.example.BackEndCVMatchMaking.services.EmpleadoService;

@RestController
@RequestMapping("MatchMakingCV/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/getAll")
    public List<Empleado> getAllEmpleados(){

        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/getById/{id}")
    public Empleado getEmpleadoById(@PathVariable Integer id){

        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping("/add")
    public Empleado addEmpleado(@RequestBody Empleado empleado){

        return empleadoService.addEmpleado(empleado);
    }

    @PutMapping("/update/{id}")
    public boolean updateEmpleado(@RequestBody Empleado empleado, @PathVariable Integer id){

        return empleadoService.updateEmpleado(empleado, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmpleado(@PathVariable Integer id){

        return empleadoService.deleteEmpleado(id);
    }

    @GetMapping("/login/{correo}/{contrasena}")
    public Empleado loginEmpleado(@PathVariable String correo, @PathVariable String contrasena){

        return empleadoService.loginEmpleado(correo, contrasena);  
    }

}
