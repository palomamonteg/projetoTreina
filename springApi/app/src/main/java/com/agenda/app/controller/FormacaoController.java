package com.agenda.app.controller;

import com.agenda.app.model.Formacao;
import com.agenda.app.service.FormacaoService;
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
@RequestMapping("/formacoes")
public class FormacaoController {
    
    @Autowired
    private FormacaoService formacaoService;

    @GetMapping
    public List<Formacao> listarFormacoes() {
        return formacaoService.listarTodas();
    }

    @PostMapping
    public Formacao salvarFormacao(@RequestBody Formacao formacao) {
        return formacaoService.salvar(formacao);
    }

    @GetMapping("/{id}")
    public Formacao buscarFormacaoPorId(@PathVariable Long id) {
        return formacaoService.buscarPorId(id);
    }

    @PutMapping("/editarFormacao")
    public Formacao editarFormacao(@RequestParam("id") Long id, @RequestBody Formacao formacaoAtualizada) {
        Formacao formacao = formacaoService.buscarPorId(id);
        formacao.setCurso(formacaoAtualizada.getCurso());
        formacao.setInstituicao(formacaoAtualizada.getInstituicao());
        formacao.setAnoConclusao(formacaoAtualizada.getAnoConclusao());
        return formacaoService.salvar(formacao);
    }

    @DeleteMapping("/{id}")
    public void deletarFormacao(@PathVariable Long id) {
        formacaoService.deletar(id);
    }
}