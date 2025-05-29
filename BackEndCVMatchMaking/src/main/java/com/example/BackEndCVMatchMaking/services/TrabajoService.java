package com.example.BackEndCVMatchMaking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BackEndCVMatchMaking.models.Trabajo;
import com.example.BackEndCVMatchMaking.repositories.TrabajoRepository;

public class TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    public List<Trabajo> getAllTrabajo(){

        return trabajoRepository.findAll();
    }

    public Trabajo getTrabajoById(Integer id){

        Optional <Trabajo> trabajo = trabajoRepository.findById(id);
        return trabajo.get();
    }

    public Trabajo addTrabajo(Trabajo trabajo){

        return trabajoRepository.save(trabajo);
    }

    public boolean updateTrabajo(Trabajo trabajo, Integer id){

        Optional<Trabajo> job = trabajoRepository.findById(id);
        if(job.isPresent()){

            trabajo.setIdTrabajo(id);
            trabajoRepository.save(trabajo);
            return true;
        } else {

            return false;
        }
    }

    public boolean deleteTrabajo(Integer id){

        Optional<Trabajo> job = trabajoRepository.findById(id);
        if(job.isPresent()){

            trabajoRepository.deleteById(id);
            return true;
        } else {

            return false;
        }
    }

    public List<String> recuperarHabilidadesFuertes(Trabajo t){
        return t.getHabilidadesBlandas();
    }

}
