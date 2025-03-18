package net.weg.gestaoestoque2025.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.gestaoestoque2025.DTO.Response.FabricanteResponseDTO;

import java.util.List;

@Builder
@Entity
@Table(name = "fabricante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "fabricante")
    List<Produto> produtoList;

    public FabricanteResponseDTO toDTO() {
        return new FabricanteResponseDTO(
                this.id,
                this.nome,
                this.descricao
        );
    }
}
