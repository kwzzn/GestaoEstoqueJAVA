package net.weg.gestaoestoque2025.DTO.Response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import net.weg.gestaoestoque2025.Entity.Categoria;
import net.weg.gestaoestoque2025.Entity.Fabricante;

public record ProdutoResponseDTO(
        Integer id,
        String nome,
        double preco,
        Integer estoque,
        String dataValidade,
        String descricao,
        String codigoBarras,
        double peso,
        double medida,
        Integer fabricante_id,
        Integer categoria_id
) {
}
