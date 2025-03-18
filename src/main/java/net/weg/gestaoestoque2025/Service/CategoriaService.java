package net.weg.gestaoestoque2025.Service;

import lombok.AllArgsConstructor;
import net.weg.gestaoestoque2025.DTO.Request.CategoriaPostRequestDTO;
import net.weg.gestaoestoque2025.DTO.Response.CategoriaResponseDTO;
import net.weg.gestaoestoque2025.Entity.Categoria;
import net.weg.gestaoestoque2025.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaResponseDTO adicionarCategoria (CategoriaPostRequestDTO categoriaPostRequestDTO) {

        if (repository.existsByNome(categoriaPostRequestDTO.nome())){
            throw new RuntimeException("Categoria com nome ja existente");
        }

        Categoria categoria = repository.save(categoriaPostRequestDTO.toEntity());
        return categoria.toDTO();
    }

    public CategoriaResponseDTO buscarCategoria (int id) {
        Categoria categoria = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return categoria.toDTO();
    }

    public Categoria buscarCategoriaEntidade (int id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<CategoriaResponseDTO> listarCategoria () {
         return repository.findAll().stream().map(Categoria::toDTO).collect(Collectors.toList());
    }

    public CategoriaResponseDTO atualizarCategoria (CategoriaPostRequestDTO categoriaPostRequestDTO, int id) {
        buscarCategoria(id);

        Categoria categoria = categoriaPostRequestDTO.toEntity();
        categoria.setId(id);
        repository.save(categoria);
        return categoria.toDTO();
    }

    public void excluirCategoria (int id) {
        buscarCategoria(id);
        repository.deleteById(id);
    }

}
