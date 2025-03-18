package net.weg.gestaoestoque2025.DTO.Response;

import jakarta.validation.constraints.NotBlank;

public record CategoriaResponseDTO (
        Integer id,
        String nome,
        String descricao
) {
}
