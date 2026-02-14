package com.exemplo.biblioteca.dao;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public class EmprestimoDAO {

    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo)throws SQLException{
        String query = """
                INSERT INTO emprestimo
                (livro_id, usuario_id, data_emprestimo)
                VALUES (?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setInt(1, emprestimo.getLivro_id());
            stmt.setInt(2, emprestimo.getUsuario_id());
            stmt.setDate(3, emprestimo.getDataEmprestimo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                emprestimo.setId(rs.getInt(1));
                return emprestimo;
            }
        }
        return null;
    }
}
