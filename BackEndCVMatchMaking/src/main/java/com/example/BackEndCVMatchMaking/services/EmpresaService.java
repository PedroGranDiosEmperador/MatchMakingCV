package com.example.BackEndCVMatchMaking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEndCVMatchMaking.models.Empleado;
import com.example.BackEndCVMatchMaking.models.Empresa;
import com.example.BackEndCVMatchMaking.repositories.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> getAllEmpresas(){

        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Integer id){

        Optional <Empresa> empleado = empresaRepository.findById(id);
        return empleado.get();
    }

    public Empresa addEmpresa(Empresa empresa){

        return empresaRepository.save(empresa);
    }

    public boolean updateEmpresa(Empresa empresa, Integer id){

        Optional<Empresa> enterprice = empresaRepository.findById(id);
        if(enterprice.isPresent()){

            empresa.setIdEmpresa(id);
            empresaRepository.save(empresa);
            return true;
        } else {

            return false;
        }
    }

    public boolean deleteEmpresa(Integer id){

        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(empresa.isPresent()){

            empresaRepository.deleteById(id);
            return true;
        } else {

            return false;
        }
    }

    /* SERVICIOS ADICIONALES */
    public Empresa loginEmpresa(String correo, String contrasena){

        Optional<Empresa> empresa = empresaRepository.loginEmpresa(correo, contrasena);
        return empresa.get();
    }
}
