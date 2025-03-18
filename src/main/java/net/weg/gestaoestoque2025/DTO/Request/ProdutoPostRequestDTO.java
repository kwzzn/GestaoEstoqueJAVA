package net.weg.gestaoestoque2025.DTO.Request;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import net.weg.gestaoestoque2025.Entity.Categoria;
import net.weg.gestaoestoque2025.Entity.Fabricante;
import net.weg.gestaoestoque2025.Entity.Produto;
import net.weg.gestaoestoque2025.Service.ProdutoService;

public record ProdutoPostRequestDTO(
        @NotBlank String nome,
        @Positive @NotNull double preco,
        @PositiveOrZero @NotNull Integer estoque,
        @NotBlank String dataValidade,
        @NotBlank String descricao,
        @NotBlank String codigoBarras,
        @NotNull double peso,
        @NotNull double medida,
        @NotNull Integer fabricante_id,
        @NotNull Integer categoria_id
) {

}
