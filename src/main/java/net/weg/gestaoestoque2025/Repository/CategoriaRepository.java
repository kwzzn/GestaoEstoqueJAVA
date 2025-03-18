package net.weg.gestaoestoque2025.Repository;

import net.weg.gestaoestoque2025.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    public boolean existsByNome(String nome);

}
