package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.dao.EmprestimoDAO;
import com.exemplo.biblioteca.dto.Emprestimo.EmprestimoResponseDto;
import com.exemplo.biblioteca.dto.Emprestimo.EmprestimoResquestDto;
import com.exemplo.biblioteca.mapper.EmprestimoMapper;
import com.exemplo.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoDAO repository;
    private final EmprestimoMapper mapper;

    public EmprestimoService(EmprestimoDAO repository, EmprestimoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public EmprestimoResponseDto salvarEmprestimo(EmprestimoResquestDto emprestimoResquestDto)throws SQLException{
        Emprestimo emprestimo = mapper.toEntity(emprestimoResquestDto);
        return mapper.toResponse(repository.cadastrarEmprestimo(emprestimo));
    }

    public List<EmprestimoResponseDto> buscarTodos() throws SQLException {
        return repository.buscarTodos().stream()
                                       .map(mapper::toResponse)
                                       .toList();

    }

    public EmprestimoResponseDto buscarPorId(int id) throws SQLException{
        return mapper.toResponse(repository.buscarPorId(id));

    }

    public EmprestimoResponseDto atualizarDataEmprestimo(int id, EmprestimoResquestDto emprestimoResquestDto) throws SQLException{
        Emprestimo emprestimo = mapper.toEntity(emprestimoResquestDto);

        emprestimo.setId(id);
        return mapper.toResponse(repository.atualizarDataEmprestimo(emprestimo));
    }

    public EmprestimoResponseDto atualizarDataDevolucao(int id, Emprestimo emprestimo) throws SQLException{
        emprestimo.setId(id);

        return mapper.toResponse(repository.atualizarDataDevolucao(emprestimo));
    }

    public void deletar(int id) throws SQLException{
        repository.deletar(id);
    }
}
