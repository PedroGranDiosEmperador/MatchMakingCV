package com.example.BackEndCVMatchMaking.models;

public class ResultadoEvalCV {
    Trabajo trabajo;
    float puntuacion;
    int claseResultado;

    public ResultadoEvalCV(Trabajo trabajo, float puntuacion, int claseResultado) {
        this.trabajo = trabajo;
        this.puntuacion = puntuacion;
        this.claseResultado = claseResultado;
    }

    public ResultadoEvalCV(Trabajo trabajo, float puntuacion) {
        this.trabajo = trabajo;
        this.puntuacion = puntuacion;
        this.claseResultado = 0;
    }

    public Trabajo getTrabajo() {
        
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        
        this.trabajo = trabajo;
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
