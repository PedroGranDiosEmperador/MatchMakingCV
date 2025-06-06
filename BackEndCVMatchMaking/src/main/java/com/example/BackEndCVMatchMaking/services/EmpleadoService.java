package com.example.BackEndCVMatchMaking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEndCVMatchMaking.models.Empleado;
import com.example.BackEndCVMatchMaking.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados(){

        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(Integer id){

        Optional <Empleado> empleado = empleadoRepository.findById(id);
        return empleado.get();
    }

    public Empleado addEmpleado(Empleado empleado){

        return empleadoRepository.save(empleado);
    }

    public boolean updateEmpleado(Empleado empleado, Integer id){

        Optional<Empleado> worker = empleadoRepository.findById(id);
        if(worker.isPresent()){

            empleado.setIdEmpleado(id);
            empleadoRepository.save(empleado);
            return true;
        } else {

            return false;
        }
    }

    public boolean deleteEmpleado(Integer id){

        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if(empleado.isPresent()){

            empleadoRepository.deleteById(id);
            return true;
        } else {

            return false;
        }
    }

    /* SERVICIOS ADICIONALES */
    public Empleado loginEmpleado(String correo, String contrasena){

        Optional<Empleado> empleado = empleadoRepository.loginEmpleado(correo, contrasena);
        return empleado.get();
    }

}
