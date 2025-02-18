package com.agenda.app.service;

import com.agenda.app.model.Experiencia;
import com.agenda.app.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> listarTodas() {
        return experienciaRepository.findAll();
    }

    public Experiencia salvar(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public Experiencia buscarPorId(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        experienciaRepository.deleteById(id);
    }
    
}
