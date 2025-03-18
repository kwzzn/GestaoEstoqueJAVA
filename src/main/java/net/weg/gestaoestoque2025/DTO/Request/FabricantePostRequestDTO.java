package net.weg.gestaoestoque2025.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import net.weg.gestaoestoque2025.Entity.Fabricante;

public record FabricantePostRequestDTO(
        @NotBlank String nome,
        String descricao
) {
    public Fabricante toEntity() {
        return Fabricante.builder()
                .nome(this.nome)
                .descricao(this.descricao)
                .build();
    }
}
