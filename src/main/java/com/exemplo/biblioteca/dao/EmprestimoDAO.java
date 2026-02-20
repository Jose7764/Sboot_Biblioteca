package com.exemplo.biblioteca.dao;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<Emprestimo> buscarTodos() throws SQLException {
        String query = """
                SELECT id, livro_id, usuario_id, data_emprestimo
                FROM emprestimo
        """;

        List<Emprestimo> emprestimos = new ArrayList<>();

        try(Connection conn = Conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int livro_id = rs.getInt("livro_id");
                int usuario_id = rs.getInt("usuario_id");
                Date data_emprestimo = rs.getDate("data_emprestimo");

                emprestimos.add(new Emprestimo(livro_id, usuario_id, data_emprestimo));
            }

            return emprestimos;
        }
    }

    public Emprestimo buscarPorId(int id) throws SQLException{
        String query = """
                SELECT id, livro_id, usuario_id, data_emprestimo
                FROM emprestimo
                WHERE id = ?
        """;

        try(Connection conn = Conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int livro_id = rs.getInt("livro_id");
                int usuario_id = rs.getInt("usuario_id");
                Date data_emprestimo = rs.getDate("data_emprestimo");

                return new Emprestimo(id, livro_id, usuario_id, data_emprestimo);
            }

            return null;
        }
    }

    public Emprestimo atualizarDataEmprestimo(Emprestimo emprestimo) throws SQLException{

        String query = """
                UPDATE emprestimo 
                SET data_emprestimo = ?
                WHERE id = ?
        """;

        try(Connection conn = Conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setDate(1, emprestimo.getDataEmprestimo());
            stmt.setInt(2, emprestimo.getId());

            stmt.executeUpdate();

            return emprestimo;
        }

    }

    public Emprestimo atualizarDataDevolucao(Emprestimo emprestimo) throws SQLException{

        String query = """
                UPDATE emprestimo
                SET data_devolucao = ?
                WHERE id = ?
        """;

        try(Connection conn = Conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setDate(1, emprestimo.getDataDevolução());
            stmt.setInt(2, emprestimo.getId());

            stmt.executeUpdate();


            return emprestimo;
        }

    }



    public void deletar(int id) throws SQLException{
        String query = """
                DELETE FROM emprestimo
                WHERE id = ?
        """;

        try(Connection conn = Conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
