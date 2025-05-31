package com.example.BackEndCVMatchMaking.models;

public class ResultadoEvalT {
    CurriculumVitae curriculum;
    float puntuacion;
    int claseResultado;

    public ResultadoEvalT(CurriculumVitae curriculum, float puntuacion, int claseResultado) {
        this.curriculum = curriculum;
        this.puntuacion = puntuacion;
        this.claseResultado = claseResultado;
    }

    public ResultadoEvalT(CurriculumVitae curriculum, float puntuacion) {
        this.curriculum = curriculum;
        this.puntuacion = puntuacion;
        this.claseResultado = 0;
    }

    public CurriculumVitae getCurriculum() {
        
        return curriculum;
    }

    public void setCurriculum(CurriculumVitae curriculum) {
        
        this.curriculum = curriculum;
    }

    public float getPuntuacion() {
        
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        
        this.puntuacion = puntuacion;
    }

    public int getClaseResultado() {
        
        return claseResultado;
    }
    
    public void setClaseResultado(int claseResultado) {
        
        this.claseResultado = claseResultado;
    } 

}
