package net.weg.gestaoestoque2025.Repository;

import net.weg.gestaoestoque2025.Entity.Categoria;
import net.weg.gestaoestoque2025.Entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>, JpaSpecificationExecutor<Produto> {

    Page<Produto> findByCategoriaId(Integer id, Pageable pageable);

}
