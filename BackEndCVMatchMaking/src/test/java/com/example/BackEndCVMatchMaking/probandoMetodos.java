 package com.example.BackEndCVMatchMaking;

public class probandoMetodos {

       /* METODOS PARA EL CALCULO DE COINCIDENCIA */
    public static float SumaHabilidades(String[] habilidadesCV, String[] habilidadesT){

        int numHRequeridas = habilidadesT.length;   //<-- CANTIDAD TOTAL DE HABILIDADES REQUERIDAS
        int numHIdentificadas = 0;                  //<-- CANTIDAD DE HABILIDADES IDENTIFICADAS

        for(int i = 0; i < numHRequeridas; i++){

          for (String habilidades : habilidadesCV) {

              if(habilidades == (habilidadesCV[i])){

                numHIdentificadas++;
            }
          }
        }

        return numHIdentificadas / numHRequeridas;
    }
    public static void main(String[] args) {
        String [] habilidadesCliente={"programador","Java", "Python"}, habilidadesTrabajo={"Python", "programador","documentador"};

        float resultado=SumaHabilidades(habilidadesCliente,habilidadesTrabajo);
        System.console().printf("El resultado es: %f", resultado);
    }
}