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

import com.example.BackEndCVMatchMaking.models.Trabajo;
import com.example.BackEndCVMatchMaking.services.TrabajoService;

@RestController
@RequestMapping("MatchMakingCV/trabajo")
public class TrabajoController {

    @Autowired
    private TrabajoService trabajoService;

    @GetMapping("/getAll")
    public List<Trabajo> getAllTrabajo(){

        return trabajoService.getAllTrabajo();
    }

    @GetMapping("/getById/{id}")
    public Trabajo getTrabajoById(@PathVariable Integer id){

        return trabajoService.getTrabajoById(id);
    }

    @PostMapping("/add")
    public Trabajo addTrabajo(@RequestBody Trabajo trabajo){

        return trabajoService.addTrabajo(trabajo);
    }

    @PutMapping("/update/{id}")
    public boolean updateTrabajo(@RequestBody Trabajo trabajo, @PathVariable Integer id){

        return trabajoService.updateTrabajo(trabajo, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteTrabajo(@PathVariable Integer id){

        return trabajoService.deleteTrabajo(id);
    }

}
