package com.agenda.app.controller;

import com.agenda.app.model.Experiencia;
import com.agenda.app.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping
    public List<Experiencia> listarExperiencias() {
        return experienciaService.listarTodas();
    }

    @PostMapping
    public Experiencia salvarExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaService.salvar(experiencia);
    }

    @GetMapping("/{id}")
    public Experiencia buscarExperienciaPorId(@PathVariable Long id) {
        return experienciaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Experiencia atualizarExperiencia(@PathVariable Long id, @RequestBody Experiencia experienciaAtualizada) {
        Experiencia experiencia = experienciaService.buscarPorId(id);
        experiencia.setEmpresa(experienciaAtualizada.getEmpresa());
        experiencia.setCargo(experienciaAtualizada.getCargo());
        experiencia.setDataInicio(experienciaAtualizada.getDataInicio());
        experiencia.setDataFim(experienciaAtualizada.getDataFim());
        return experienciaService.salvar(experiencia);
    }

    @DeleteMapping("/{id}")
    public void deletarExperiencia(@PathVariable Long id) {
        experienciaService.deletar(id);
    }
}