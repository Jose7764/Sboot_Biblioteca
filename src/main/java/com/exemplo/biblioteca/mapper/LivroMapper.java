package com.exemplo.biblioteca.mapper;

import com.exemplo.biblioteca.dto.Livro.LivroRequestDto;
import com.exemplo.biblioteca.dto.Livro.LivroResponseDto;
import com.exemplo.biblioteca.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
    public Livro toEntity(LivroRequestDto requestDto){
        return new Livro(
                requestDto.titulo(),
                requestDto.autor(),
                requestDto.anoPublicacao()
        );
    }

    public LivroResponseDto toResponse(Livro livro){
        return new LivroResponseDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAnoPublicacao());
    }
}