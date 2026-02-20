package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.dao.EmprestimoDAO;
import com.exemplo.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoDAO repository;

    public EmprestimoService(EmprestimoDAO repository){
        this.repository = repository;
    }

    public Emprestimo salvarEmprestimo(Emprestimo emprestimo)throws SQLException{
        return repository.cadastrarEmprestimo(emprestimo);
    }

    public List<Emprestimo> buscarTodos() throws SQLException {
        return repository.buscarTodos();

    }

    public Emprestimo buscarPorId(int id) throws SQLException{
        return repository.buscarPorId(id);

    }

    public Emprestimo atualizarDataEmprestimo(int id, Emprestimo emprestimo) throws SQLException{
        emprestimo.setId(id);

        return repository.atualizarDataEmprestimo(emprestimo);
    }

    public Emprestimo atualizarDataDevolucao(int id, Emprestimo emprestimo) throws SQLException{
        emprestimo.setId(id);

        return repository.atualizarDataDevolucao(emprestimo);
    }

    public void deletar(int id) throws SQLException{
        repository.deletar(id);
    }
}
