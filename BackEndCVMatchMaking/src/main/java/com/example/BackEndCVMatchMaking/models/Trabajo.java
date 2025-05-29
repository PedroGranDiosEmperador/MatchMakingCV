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
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrabajo;

    private String titulo;
    private String descripcion;
    private String nombreEmpresa;
    private String locacion;

    private char genero;
    private byte edad;

    private float sueldo;

    private byte tipoTrabajo;
    private byte nivelEducativo;
    private byte experiencia;

    private List<String> habilidadesBlandas;
    private List<String> habilidadesFuertes;

}
