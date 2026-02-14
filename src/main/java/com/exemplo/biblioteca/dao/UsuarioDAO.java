package com.exemplo.biblioteca.dao;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.model.Usuario;
import com.exemplo.biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDAO {

    public Usuario inserirUser(Usuario user)throws SQLException {
        String query = """
                INSERT INTO usuario
                (nome, email)
                values (?,?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, user.getNome());
            stmt.setString(2,user.getEmail());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
              user.setId(rs.getInt(1));
              return user;
            }
        }
        return null;
    }

    public List<Usuario> listarUsuarios()throws SQLException{
        List<Usuario> listaUser = new ArrayList<>();
        String query =  """
                SELECT id, nome, email
                FROM usuario 
                """;

        Usuario user;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                user = new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("email"));

                listaUser.add(user);
            }
        }
        return listaUser;
    }

    public Usuario listarUserPorId(int id)throws SQLException{
        String query = """
                SELECT id, nome, email
                FROM usuario
                WHERE id = ?
                """;
        Usuario user;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                user = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                return user;
            }
        }
        return null;
    }

    public Usuario atualizarUser(int id, Usuario user)throws SQLException{
        String query = """
                UPDATE usuario 
                set nome = ?,
                email = ?
                WHERE id = ? 
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3,id);
            stmt.executeUpdate();



        }
        return new Usuario(id, user.getNome(), user.getEmail());
    }

    public void deletarUser(int id )throws SQLException{
        String query = """
                DELETE FROM usuario 
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
}
