package com.agenda.app.service;

import com.agenda.app.model.RedeSocial;
import com.agenda.app.repository.RedeSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedeSocialService {
    @Autowired
    private RedeSocialRepository redeSocialRepository;

    public List<RedeSocial> listarTodas() {
        return redeSocialRepository.findAll();
    }

    public RedeSocial salvar(RedeSocial redeSocial) {
        return redeSocialRepository.save(redeSocial);
    }

    public RedeSocial buscarPorId(Long id) {
        return redeSocialRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        redeSocialRepository.deleteById(id);
    }
    
}