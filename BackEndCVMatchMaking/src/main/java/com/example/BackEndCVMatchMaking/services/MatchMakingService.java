package com.example.BackEndCVMatchMaking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BackEndCVMatchMaking.models.CurriculumVitae;
import com.example.BackEndCVMatchMaking.models.Resultado;
import com.example.BackEndCVMatchMaking.models.Trabajo;

public class MatchMakingService {

    @Autowired
    private TrabajoService trabajoService;
    private CurriculumVitaeService curriculumService;
    
    // < -- PESOS PARA LA EVALUACION DE APLICANTES [TRABAJO --> CURRICULUM]
    private float pagoEsperadoT = 0.30f;
    private float pesoHBlandasT = 0.20f;
    private float pesoHFuertesT = 0.50f;

    //Cuando el pago es muy parecido a lo que el cliente busca
    private float pesoPagoJusto= 1f;
    //cuando el pago es superior a lo que el cliente busca
    private float pesoPagoSuperior= 1.5f;
    //cuando el pago es muy inferior a lo que el cliente busca;
    private float pesoPagoInferior=0f;

    //Tipos de trabajos
    private float trabajo3=1f;
    private float trabajo2=0.80f;
    private float trabajo1= 0.5f;

    

    /* METODOS PARA EL CALCULO DE COINCIDENCIA */
        public static float SumaHabilidades(String[] habilidadesCV, String[] habilidadesT){

        float numHRequeridas = habilidadesT.length;   //<-- CANTIDAD TOTAL DE HABILIDADES REQUERIDAS
        float numHIdentificadas = 0;                  //<-- CANTIDAD DE HABILIDADES IDENTIFICADAS

        for(String habilidades : habilidadesCV){

          for (String habilidadR: habilidadesT) {

              if(habilidades == (habilidadR)){

                numHIdentificadas++;
            }
          }
        }
        return (float)(numHIdentificadas / numHRequeridas);
    }

    public float evaluacionSueldo(float sueldoEsperado, float sueldoPropuesto ){

        float razonSueldo = sueldoPropuesto / sueldoEsperado;

        if(razonSueldo >= 1.5)   //<-- SUELDO ESPERADO RESULTA 50% INFERIOR AL SUELDO PROPUESTO POR EL TRABAJO
            return pesoPagoSuperior;
        if(razonSueldo >= 1)     //<-- SUELDO ESPERADO 49% - 0% INFERIOR AL SUELDO PROPUESTO POR EL TRABAJO
            return pesoPagoJusto;
        if(razonSueldo < 0.5)    //<-- SUELDO ESPERADO EXCEDE EN 50% EL SUELDO PROPUESTO POR EL TRABAJO
            return pesoPagoInferior;
        
        return razonSueldo;     //<-- SUELDO PROPUESTO EXCEDE 49% - 0% EL SUELDO PROPUESTO
    }

    public List<Resultado> valorizarTrabajos(Integer id){
        //Todas las variables necesarias...
        List <Trabajo> listaTrabajos= trabajoService.getAllTrabajo();
        CurriculumVitae cv= curriculumService.getcurriculumVitaeById(id);
        List <Resultado> listaResultante= new ArrayList<>();

        //Metodo If checando que el Curriculum exista

        if(cv!=null){
            for (Trabajo trabajo : listaTrabajos) {
               if(trabajo.getTipoTrabajo()!= cv.getTipoTrabajo())
               continue;
                if (trabajo.getNivelEducativo()>cv.getNivelEducativo()) 
                continue;
                if(trabajo.getExperiencia()>cv.getExperiencia())
                continue;
                if(trabajo.getSueldo()<(.50*cv.getSueldoEsperado()))
                continue;

                float resultadoSueldo;
                float resultadoHabilidadesFuertes;
                float resultadoHabilidadesDebiles;
                int tipoTrabajo;
        //Variables que vamos a trabajar
                resultadoSueldo=evaluacionSueldo(cv.getSueldoEsperado(), trabajo.getSueldo());
                resultadoHabilidadesDebiles= SumaHabilidades(cv.getHabilidadesBlandas(),trabajo.getHabilidadesBlandas());
                resultadoHabilidadesFuertes= SumaHabilidades(cv.getHabilidadesFuertes(), trabajo.getHabilidadesFuertes());
                
                resultadoHabilidadesDebiles= resultadoHabilidadesDebiles*pesoHBlandasT;
                resultadoHabilidadesFuertes= resultadoHabilidadesFuertes*pesoHFuertesT;

                float resultadoHabilidades= resultadoHabilidadesDebiles+resultadoHabilidadesFuertes;

                resultadoSueldo= evaluacionSueldo(cv.getSueldoEsperado(), trabajo.getSueldo());
                resultadoSueldo= resultadoSueldo*pagoEsperadoT;
                float pesoTrabajo= resultadoHabilidades+resultadoSueldo;
               
                tipoTrabajo= tipificarTrabajo(pesoTrabajo);
                Resultado resultado= new Resultado(trabajo, pesoTrabajo, tipoTrabajo);

                listaResultante.add(resultado);
                
           }
           //Finalizacion de ciclo for, se manda la listaResultante
           return listaResultante;
        }
        else{
            return null;
        }
    } 
    public int tipificarTrabajo(float pt){
        if(pt >=trabajo3){
            return 3;
        }
        if(pt >=trabajo2){
            return 2;
        }
        if(pt >= trabajo1){
            return 1;
        }
        return 0;
    }

}

