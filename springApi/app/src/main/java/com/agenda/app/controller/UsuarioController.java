package com.agenda.app.controller;

import com.agenda.app.model.Usuario;
import com.agenda.app.service.UsuarioService;
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

@CrossOrigin(origins = "http://localhost:3000") // p requisi do React -> ver o url
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodos();
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @PutMapping("/editarCurriculo")
    public Usuario editarCurriculo(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/atualizarFoto")
    public Usuario atualizarFoto(@RequestParam("id") Long id, @RequestParam("foto") String foto) {
        Usuario usuario = usuarioService.buscarPorId(id);
        usuario.setFoto(foto); 
        return usuarioService.salvar(usuario);
    }

    @GetMapping("/exibirCurriculo")
    public Usuario exibirCurriculo() {
        return usuarioService.buscarPorId(1L); 
    }
}