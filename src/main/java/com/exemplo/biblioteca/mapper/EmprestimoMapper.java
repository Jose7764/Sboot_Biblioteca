package com.exemplo.biblioteca.mapper;

import com.exemplo.biblioteca.dto.Emprestimo.EmprestimoResponseDto;
import com.exemplo.biblioteca.dto.Emprestimo.EmprestimoResquestDto;
import com.exemplo.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {

    public Emprestimo toEntity(EmprestimoResquestDto responseDto){
        return new Emprestimo(
                responseDto.livro_id(),
                responseDto.usuario_id(),
                responseDto.dataEmprestimo()
        );
    }

    public EmprestimoResponseDto toResponse(Emprestimo emprestimo){
        return new EmprestimoResponseDto(
                emprestimo.getId(),
                emprestimo.getLivro_id(),
                emprestimo.getUsuario_id(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolução()
        );
    }
}
