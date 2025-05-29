package com.example.BackEndCVMatchMaking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BackEndCVMatchMaking.models.CurriculumVitae;
import com.example.BackEndCVMatchMaking.models.Trabajo;

public class MatchMakingService {

    @Autowired
    private TrabajoService trabajoService;
    private CurriculumVitaeService curriculumService;

    /* METODOS PARA EL CALCULO DE COINCIDENCIA */
    public float SumaHabilidades(CurriculumVitae cv, Trabajo t){
        List<String> habilidadesFuertes= curriculumService.recuperarHabilidadesFuertes(cv);
        List<String> habilidadesBlandas= curriculumService.recuperarHabilidadesBlandas(cv);

        
    }

    public int calificacionSueldo(CurriculumVitae cv, Trabajo t){
        
    }

}
