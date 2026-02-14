package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;
import com.exemplo.biblioteca.dao.LivroDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO repository;

    public LivroService(LivroDAO repository){
        this.repository = repository;
    }

    public Livro salvarLivro(Livro livro)throws SQLException {
        return repository.cadastrarLivro(livro);
    }

    public List<Livro> ListarLivros()throws SQLException{
        return repository.listarLivros();
    }

    public Livro listarlivroPorId(int id)throws SQLException {
        return repository.listarlivroPorId(id);
    }

    public Livro atualizarLivro(int id, Livro livro)throws SQLException{
        return repository.atualizarLivro(id,livro);
    }

    public void deletarLivro(int id)throws SQLException{
        repository.deletarLivro(id);
    }


}
