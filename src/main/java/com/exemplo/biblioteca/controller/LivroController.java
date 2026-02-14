package com.exemplo.biblioteca.controller;


import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service){
        this.service = service;
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {

        try {
           return service.salvarLivro(livro);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @GetMapping
    public List<Livro> listarLivros(){
        try {
            return service.ListarLivros();
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @GetMapping("/{id}")
    public Livro listarLivroPorId(@PathVariable int id){

        try {
            return service.listarlivroPorId(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable int id, @RequestBody Livro livro){

        try {
            return service.atualizarLivro(id,livro);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @DeleteMapping("/{id}")
    public void deletarlivro(@PathVariable int id){
        try {
            service.deletarLivro(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
