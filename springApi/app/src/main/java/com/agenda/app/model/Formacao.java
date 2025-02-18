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
@Table(name = "formacoes")
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor

public class Formacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;
    private String instituicao;
    private String tipo;  
    private int ano;
    private int anoConclusao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
