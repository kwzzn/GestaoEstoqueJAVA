package net.weg.gestaoestoque2025.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import net.weg.gestaoestoque2025.Entity.Categoria;

public record CategoriaPostRequestDTO(
        @NotBlank String nome,
        String descricao
) {
    public Categoria toEntity() {
        return Categoria.builder()
                .nome(this.nome)
                .descricao(this.descricao)
                .build();
    }
}
