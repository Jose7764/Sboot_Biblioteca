package com.exemplo.biblioteca.dto.Emprestimo;

import java.sql.Date;

public record EmprestimoResponseDto (
        int id,
        int livro_id,
        int usuario_id,
        Date dataEmprestimo,
        Date dataDevolução
){

}
