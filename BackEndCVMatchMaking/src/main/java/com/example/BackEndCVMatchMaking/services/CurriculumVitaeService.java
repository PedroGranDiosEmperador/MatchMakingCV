package com.example.BackEndCVMatchMaking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BackEndCVMatchMaking.models.CurriculumVitae;
import com.example.BackEndCVMatchMaking.models.Trabajo;
import com.example.BackEndCVMatchMaking.repositories.CurriculumVitaeRepository;
import com.example.BackEndCVMatchMaking.repositories.TrabajoRepository;

public class CurriculumVitaeService {

    @Autowired
    private CurriculumVitaeRepository curriculumRepository;

    public List<CurriculumVitae> getAllCurriculumVitaes(){

        return curriculumRepository.findAll();
    }

    public CurriculumVitae getcurriculumVitaeById(Integer id){

        Optional <CurriculumVitae> curriculum = curriculumRepository.findById(id);
        return curriculum.get();
    }

    public CurriculumVitae addCurriculumVitae(CurriculumVitae curriculum){

        return curriculumRepository.save(curriculum);
    }

    public boolean updateCurriculumVitae(CurriculumVitae curriculum, Integer id){

        Optional<CurriculumVitae> cur = curriculumRepository.findById(id);
        if(cur.isPresent()){

            curriculum.setIdCurriculum(id);
            curriculumRepository.save(curriculum);
            return true;
        } else {

            return false;
        }
    }

    public boolean deleteCurriculumVitae(Integer id){

        Optional<CurriculumVitae> curriculum = curriculumRepository.findById(id);
        if(curriculum.isPresent()){

            curriculumRepository.deleteById(id);
            return true;
        } else {

            return false;
        }
    }

}
