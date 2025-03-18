package net.weg.gestaoestoque2025.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.gestaoestoque2025.DTO.Response.CategoriaResponseDTO;

import java.util.List;


@Builder
@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtoList;

    public CategoriaResponseDTO toDTO() {
        return new CategoriaResponseDTO(
                this.id,
                this.nome,
                this.descricao
        );
    }
}
