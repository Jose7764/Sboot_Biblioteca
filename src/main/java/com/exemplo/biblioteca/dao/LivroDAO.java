package com.exemplo.biblioteca.dao;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroDAO {

    public Livro cadastrarLivro(Livro livro)throws SQLException {
        String query = """
                INSERT INTO livro
                (titulo, autor, ano_publicacao)
                VALUES (?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1,livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3,livro.getAnoPublicacao());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                livro.setId(rs.getInt(1));
                return livro;
            }

        }
        return null;
    }

    public List<Livro> listarLivros()throws SQLException{
        List<Livro> listaLivro = new ArrayList<>();
        String query =  """
                SELECT id, titulo, autor, ano_publicacao
                FROM livro 
                """;

        Livro livro;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                livro = new Livro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("ano_publicacao") );

                listaLivro.add(livro);
            }
        }
        return listaLivro;
    }

    public Livro listarlivroPorId(int id)throws SQLException{
        String query = """
                SELECT id, titulo, autor, ano_publicacao
                FROM livro
                WHERE id = ?
                """;
        Livro livro;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano_publicacao"));
                return livro;
            }
        }
        return null;
    }

    public Livro atualizarLivro(int id, Livro livro)throws SQLException{
        String query = """
                UPDATE livro 
                set titulo = ?,
                autor = ?,
                ano_publicacao = ?
                WHERE id = ? 
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3,livro.getAnoPublicacao());
            stmt.setInt(4,id);
            stmt.executeUpdate();



        }
        return new Livro(id, livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
    }

    public void deletarLivro(int id )throws SQLException{
        String query = """
                DELETE FROM livro 
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }

}
