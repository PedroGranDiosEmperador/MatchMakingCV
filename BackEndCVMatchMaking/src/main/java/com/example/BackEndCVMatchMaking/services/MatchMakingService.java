package com.example.BackEndCVMatchMaking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEndCVMatchMaking.models.CurriculumVitae;
import com.example.BackEndCVMatchMaking.models.Trabajo;

@Service
public class MatchMakingService {

    @Autowired
    private TrabajoService trabajoService;
    private CurriculumVitaeService curriculumService;
    
    // < -- PESOS PARA LA EVALUACION DE APLICANTES [TRABAJO --> CURRICULUM]
    private float pagoEsperadoT = 0.20f;
    private float pesoHBlandasT = 0.30f;
    private float pesoHFuertesT = 0.50f;

    

    /* METODOS PARA EL CALCULO DE COINCIDENCIA */
    public float SumaHabilidades(String[] habilidadesCV, String[] habilidadesT){

        int numHRequeridas = habilidadesT.length;   //<-- CANTIDAD TOTAL DE HABILIDADES REQUERIDAS
        int numHIdentificadas = 0;                  //<-- CANTIDAD DE HABILIDADES IDENTIFICADAS

        for(int i = 0; i < numHRequeridas; i++){

            if(habilidadesT[i] == (habilidadesCV[i])){

                numHIdentificadas++;
            }
        }

        return numHIdentificadas / numHRequeridas;
    }

    public float evaluacionSueldo(float sueldoEsperado, float sueldoPropuesto ){

        float razonSueldo = sueldoPropuesto / sueldoEsperado;

        if(razonSueldo >= 1.5)   //<-- SUELDO ESPERADO RESULTA 50% INFERIOR AL SUELDO PROPUESTO POR EL TRABAJO
            return 1.2f;
        if(razonSueldo >= 1)     //<-- SUELDO ESPERADO 49% - 0% INFERIOR AL SUELDO PROPUESTO POR EL TRABAJO
            return 1;
        if(razonSueldo < 0.5)    //<-- SUELDO ESPERADO EXCEDE EN 50% EL SUELDO PROPUESTO POR EL TRABAJO
            return 0;
        
        return razonSueldo;     //<-- SUELDO PROPUESTO EXCEDE 49% - 0% EL SUELDO PROPUESTO
    }

}

