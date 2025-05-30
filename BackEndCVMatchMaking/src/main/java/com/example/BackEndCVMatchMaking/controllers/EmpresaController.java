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

import com.example.BackEndCVMatchMaking.models.Empresa;
import com.example.BackEndCVMatchMaking.services.EmpresaService;

@RestController
@RequestMapping("MatchMakingCV/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/getAll")
    public List<Empresa> getAllEmpresas(){

        return empresaService.getAllEmpresas();
    }

    @GetMapping("/getById/{id}")
    public Empresa getEmpresaById(@PathVariable Integer id){

        return empresaService.getEmpresaById(id);
    }

    @PostMapping("/add")
    public Empresa addEmpresa(@RequestBody Empresa empresa){

        return empresaService.addEmpresa(empresa);
    }

    @PutMapping("/update/{id}")
    public boolean updateEmpresa(@RequestBody Empresa empresa, @PathVariable Integer id){

        return empresaService.updateEmpresa(empresa, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmpresa(@PathVariable Integer id){

        return empresaService.deleteEmpresa(id);
    }

}
