package com.exemplo.biblioteca.mapper;

import com.exemplo.biblioteca.dto.Usuario.UsuarioRequestDto;
import com.exemplo.biblioteca.dto.Usuario.UsuarioResponseDto;
import com.exemplo.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario toEntity(UsuarioRequestDto requestDto){
        return new Usuario(
                requestDto.nome(),
                requestDto.email()
        );
    }

    public UsuarioResponseDto toResponse(Usuario usuario){
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
