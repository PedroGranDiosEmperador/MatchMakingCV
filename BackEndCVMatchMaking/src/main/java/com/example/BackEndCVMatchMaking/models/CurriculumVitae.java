package com.example.BackEndCVMatchMaking.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurriculum;

    private String nombre;
    private String telefono;
    private String correo;
    private String contrasena;
    private char genero;
    private byte edad;

    private List<String> referencias;

    private byte tipoTrabajo;
    private byte nivelEducativo;
    private byte experiencia;

    private float sueldoEsperado;

    private String[] habilidadesBlandas;
    private String[] habilidadesFuertes;

    /* POTENCIALMENTE >/> GENERAR 1-1 CON EMPLEADO */
}
