package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.dao.UsuarioDAO;
import com.exemplo.biblioteca.dto.Usuario.UsuarioResponseDto;
import com.exemplo.biblioteca.mapper.UsuarioMapper;
import com.exemplo.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioDAO repository, UsuarioMapper mapper){
        this.mapper = mapper;
        this.repository = repository;
    }

    public UsuarioResponseDto salvarUsuario(Usuario user) throws SQLException {
        return mapper.toResponse(repository.inserirUser(user));
    }

    public List<UsuarioResponseDto> listarUsuarios()throws SQLException{
        return repository.listarUsuarios().stream()
                                          .map(mapper::toResponse)
                                          .toList();
    }

    public UsuarioResponseDto listarUserPorId(int id)throws SQLException{
        return mapper.toResponse(repository.listarUserPorId(id));
    }

    public UsuarioResponseDto atualizarUser(int id, Usuario user)throws SQLException{
        return mapper.toResponse(repository.atualizarUser(id ,user));
    }

    public void deletarUser(int id)throws SQLException{
        repository.deletarUser(id);
    }
}
