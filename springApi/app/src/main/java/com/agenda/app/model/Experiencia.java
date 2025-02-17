package com.agenda.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "experiencias")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empresa;
    private String cargo;
    private String funcao;
    private String dataInicio;
    private int anoInicio;
    private String dataFim;
    private int anoFim;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    
}
