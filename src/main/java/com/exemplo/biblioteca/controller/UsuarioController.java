package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.dto.Usuario.UsuarioRequestDto;
import com.exemplo.biblioteca.dto.Usuario.UsuarioResponseDto;
import com.exemplo.biblioteca.model.Usuario;
import com.exemplo.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping
    public UsuarioResponseDto inserirUsuario(@RequestBody Usuario user){

        try {
            return service.salvarUsuario(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @GetMapping
    public List<UsuarioResponseDto> listarUsuarios(){
        try {
            return service.listarUsuarios();
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto listarusuarioPorId(@PathVariable int id){
        try {
            return service.listarUserPorId(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @PutMapping("/{id}")
    public UsuarioResponseDto atualizarUsuario(@PathVariable int id, @RequestBody Usuario user){
        try {
            return service.atualizarUser(id , user);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @DeleteMapping("/{id}")
    public void deletarUser(@PathVariable int id){
        try {
            service.deletarUser(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
