package com.exemplo.biblioteca.controller;


import com.exemplo.biblioteca.dto.Livro.LivroRequestDto;
import com.exemplo.biblioteca.dto.Livro.LivroResponseDto;
import com.exemplo.biblioteca.mapper.LivroMapper;
import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService service;


    public LivroController(LivroService service ){

        this.service = service;
    }

    @PostMapping
    public LivroResponseDto cadastrarLivro(@RequestBody LivroRequestDto livro) {

        try {
           return service.salvarLivro(livro);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @GetMapping
    public List<LivroResponseDto> listarLivros(){
        try {
            return service.ListarLivros();
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @GetMapping("/{id}")
    public LivroResponseDto listarLivroPorId(@PathVariable int id){

        try {
            return service.listarlivroPorId(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @PutMapping("/{id}")
    public LivroResponseDto atualizarLivro(@PathVariable int id, @RequestBody LivroRequestDto livro){

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
