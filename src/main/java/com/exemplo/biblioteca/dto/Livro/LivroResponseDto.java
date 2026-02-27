package com.exemplo.biblioteca.dto.Livro;

public record LivroResponseDto(
        int id,
        String titulo,
        String autor,
        int anoPublicacao

) {

}
