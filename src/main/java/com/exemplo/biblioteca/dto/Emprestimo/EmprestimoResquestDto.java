package com.exemplo.biblioteca.dto.Emprestimo;

import java.sql.Date;

public record EmprestimoResquestDto(

        int livro_id,
        int usuario_id,
        Date dataEmprestimo,
        Date dataDevolução
) {
}
