package com.agenda.app.service;

import com.agenda.app.model.Formacao;
import com.agenda.app.repository.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormacaoService {
    @Autowired
    private FormacaoRepository formacaoRepository;

    public List<Formacao> listarTodas() {
        return formacaoRepository.findAll();
    }

    public Formacao salvar(Formacao formacao) {
        return formacaoRepository.save(formacao);
    }

    public Formacao buscarPorId(Long id) {
        return formacaoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        formacaoRepository.deleteById(id);
    }
    
}