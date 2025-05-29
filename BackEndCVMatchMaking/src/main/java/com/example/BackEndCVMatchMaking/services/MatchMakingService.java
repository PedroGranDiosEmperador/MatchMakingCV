package com.example.BackEndCVMatchMaking.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BackEndCVMatchMaking.models.CurriculumVitae;
import com.example.BackEndCVMatchMaking.models.Trabajo;

public class MatchMakingService {

    @Autowired
    private TrabajoService trabajoService;
    private CurriculumVitaeService curriculumService;

    /* METODOS PARA EL CALCULO DE COINCIDENCIA */
    public float SumaHabilidades(CurriculumVitae cv, Trabajo t){

        
    }

}
