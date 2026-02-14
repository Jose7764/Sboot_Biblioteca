package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.dao.EmprestimoDAO;
import com.exemplo.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EmprestimoService {

    private final EmprestimoDAO repository;

    public EmprestimoService(EmprestimoDAO repository){
        this.repository = repository;
    }

    public Emprestimo salvarEmprestimo(Emprestimo emprestimo)throws SQLException{
        return repository.cadastrarEmprestimo(emprestimo);
    }
}
