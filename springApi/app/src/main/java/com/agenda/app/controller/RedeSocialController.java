package com.agenda.app.controller;

import com.agenda.app.model.RedeSocial;
import com.agenda.app.service.RedeSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/redes-sociais")
public class RedeSocialController {
    
    @Autowired
    
    private RedeSocialService redeSocialService;

    @GetMapping
    public List<RedeSocial> listarRedesSociais() {
        return redeSocialService.listarTodas();
    }

    @PostMapping
    public RedeSocial salvarRedeSocial(@RequestBody RedeSocial redeSocial) {
        return redeSocialService.salvar(redeSocial);
    }

    @GetMapping("/{id}")
    public RedeSocial buscarRedeSocialPorId(@PathVariable Long id) {
        return redeSocialService.buscarPorId(id);
    }

    @PutMapping("/editarRedeSocial")
    public RedeSocial editarRedeSocial(@RequestParam("id") Long id, @RequestBody RedeSocial redeSocialAtualizada) {
        RedeSocial redeSocial = redeSocialService.buscarPorId(id);
        redeSocial.setNome(redeSocialAtualizada.getNome());
        redeSocial.setUrl(redeSocialAtualizada.getUrl());
        return redeSocialService.salvar(redeSocial);
    }

    @DeleteMapping("/{id}")
    public void deletarRedeSocial(@PathVariable Long id) {
        redeSocialService.deletar(id);
    }
}