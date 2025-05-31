package com.example.BackEndCVMatchMaking.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEndCVMatchMaking.models.CurriculumVitae;
import com.example.BackEndCVMatchMaking.models.ResultadoEvalCV;
import com.example.BackEndCVMatchMaking.models.ResultadoEvalT;
import com.example.BackEndCVMatchMaking.models.Trabajo;
import com.example.BackEndCVMatchMaking.services.MatchMakingService;

@RestController
@RequestMapping("MatchMakingCV/controller")
public class MatchMakingController {

    @Autowired
    MatchMakingService matchMakingService;

    @GetMapping("/valorarTrabajos/{id}")
    public List<ResultadoEvalCV> valorizarTrabajos(@PathVariable Integer id){
        
        return matchMakingService.valorizarTrabajos(id);
    }

    @GetMapping("/valorarCurriculums/{id}")
    public List<ResultadoEvalT> valorizarCurriculums(@PathVariable Integer id){
        
        return matchMakingService.valorizarCurriculums(id);
    }

}
