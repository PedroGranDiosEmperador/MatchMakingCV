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

import com.example.BackEndCVMatchMaking.models.CurriculumVitae;
import com.example.BackEndCVMatchMaking.services.CurriculumVitaeService;

@RestController
@RequestMapping("MatchMakingCV/curriculum")
public class CurriculumVitaeController {

    @Autowired
    private CurriculumVitaeService curriculumService;

    @GetMapping("getAll")
    public List<CurriculumVitae> getAllCurriculumVitaes(){

        return curriculumService.getAllCurriculumVitaes();
    }

    @GetMapping("getById/{id}")
    public CurriculumVitae getcurriculumVitaeById(@PathVariable Integer id){

        return curriculumService.getcurriculumVitaeById(id);
    }

    @PostMapping("/add")
    public CurriculumVitae addCurriculumVitae(@RequestBody CurriculumVitae curriculum){

        return curriculumService.addCurriculumVitae(curriculum);
    }

    @PutMapping("/update/{id}")
    public boolean updateCurriculumVitae(@RequestBody CurriculumVitae curriculum, @PathVariable Integer id){

        return curriculumService.updateCurriculumVitae(curriculum, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCurriculumVitae(@PathVariable Integer id){

        return curriculumService.deleteCurriculumVitae(id);
    }

}
