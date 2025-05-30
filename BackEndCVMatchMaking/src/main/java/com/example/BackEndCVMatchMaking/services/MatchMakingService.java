package com.example.BackEndCVMatchMaking.services;

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
    private float pagoEsperadoT = 0.20f;
    private float pesoHBlandasT = 0.30f;
    private float pesoHFuertesT = 0.50f;

    


    /* METODOS PARA EL CALCULO DE COINCIDENCIA */
    // public float SumaHabilidades(CurriculumVitae cv, Trabajo t){

    //     List<String> listaHabilidadesBlandas= t.getHabilidadesBlandas();
    //     List<String> listaHabilidadesFuertes= t.getHabilidadesFuertes();
    //     List<String> habilidadesFuertesCliente= cv.getHabilidadesFuertes();
    //     List<String> habilidadesBlandasCliente= cv.getHabilidadesBlandas();
    //     //Wah, hay que hacerlo super facil, que tal si hacemos nuevos objetos llamados resultados que 
    //     //son la union de un curricullum vitalae y de los puntos que obtiene aca

    //     int puntosHabilidadesFuertes=0;
    //     int puntosHabilidadesDebiles=0;
    //     float pesoHabilidadesFuertes=1;
    //     float pesoHabilidadesDebiles=0.5F;
    //     //FOR para determinar cuantos puntos fuertes coinciden
    //     for (String habilidadCliente : habilidadesBlandasCliente) {
    //         for (String string2 : listaHabilidadesBlandas) {
                
    //         }
    //     }
    // 
    // < -- PESOS PARA LA EVALUACION DE APLICANTES [TRABAJO --> CURRICULUM]
    private float pagoEsperadoT = 0.20f;
    private float pesoHBlandasT = 0.30f;
    private float pesoHFuertesT = 0.50f;

    //Cuando el pago es muy parecido a lo que el cliente busca
    private float pesoPagoJusto= 1f;
    //cuando el pago es superior a lo que el cliente busca
    private float pesoPagoSuperior= 1.5f;
    //cuando el pago es muy inferior a lo que el cliente busca;
    private float pesoPagoInferior=0f;

    

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
        List <Resultado> listaResultante;
        List <Trabajo> listaAuxiliarTrabajo;

       
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
        //Variables que vamos a trabajar
                resultadoSueldo=evaluacionSueldo(cv.getSueldoEsperado(), trabajo.getSueldo());
                resultadoHabilidadesDebiles= SumaHabilidades(cv.getHabilidadesBlandas().toArray(),trabajo.getHabilidadesBlandas());


            }
        }
        else{
            return null;
        }
    } 
}

