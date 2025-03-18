package net.weg.gestaoestoque2025.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.gestaoestoque2025.DTO.Response.FabricanteResponseDTO;
import net.weg.gestaoestoque2025.DTO.Response.ProdutoResponseDTO;

@Builder
@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private Integer estoque;

    @Column(nullable = false)
    private String dataValidade;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String codigoBarras;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private double medida;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    private Fabricante fabricante;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    private Categoria categoria;

    public ProdutoResponseDTO toDTO() {
        return new ProdutoResponseDTO(
                this.id,
                this.nome,
                this.preco,
                this.estoque,
                this.dataValidade,
                this.descricao,
                this.codigoBarras,
                this.peso,
                this.medida,
                this.fabricante.getId(),
                this.categoria.getId()
        );
    }

}
