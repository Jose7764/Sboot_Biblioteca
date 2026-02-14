package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.dao.UsuarioDAO;
import com.exemplo.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO repository;

    public UsuarioService(UsuarioDAO repository){
        this.repository = repository;
    }

    public Usuario salvarUsuario(Usuario user) throws SQLException {
        return repository.inserirUser(user);
    }

    public List<Usuario> listarUsuarios()throws SQLException{
        return repository.listarUsuarios();
    }

    public Usuario listarUserPorId(int id)throws SQLException{
        return repository.listarUserPorId(id);
    }

    public Usuario atualizarUser(int id, Usuario user)throws SQLException{
        return repository.atualizarUser(id ,user);
    }

    public void deletarUser(int id)throws SQLException{
        repository.deletarUser(id);
    }
}
