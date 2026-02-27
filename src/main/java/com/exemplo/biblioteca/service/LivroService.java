package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.dto.Livro.LivroRequestDto;
import com.exemplo.biblioteca.dto.Livro.LivroResponseDto;
import com.exemplo.biblioteca.mapper.LivroMapper;
import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;
import com.exemplo.biblioteca.dao.LivroDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO repository;
    private final LivroMapper mapper;

    public LivroService(LivroDAO repository,LivroMapper mapper){
        this.mapper = mapper;
        this.repository = repository;
    }

    public LivroResponseDto salvarLivro(LivroRequestDto livroRequestDto)throws SQLException {
        Livro livro = mapper.toEntity(livroRequestDto);
        return mapper.toResponse(repository.cadastrarLivro(livro));
    }

    public List<LivroResponseDto> ListarLivros()throws SQLException{

       return repository.listarLivros().stream()
                                       .map(mapper::toResponse)
                                       .toList();
    }

    public LivroResponseDto listarlivroPorId(int id)throws SQLException {

        return mapper.toResponse(repository.listarlivroPorId(id));
    }

    public LivroResponseDto atualizarLivro(int id, LivroRequestDto livroRequestDto)throws SQLException{
        Livro livro = mapper.toEntity(livroRequestDto);
        return mapper.toResponse(repository.atualizarLivro(id, livro));
    }

    public void deletarLivro(int id)throws SQLException{
        repository.deletarLivro(id);
    }


}
