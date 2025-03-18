package net.weg.gestaoestoque2025.Service;

import lombok.AllArgsConstructor;
import net.weg.gestaoestoque2025.DTO.Request.FabricantePostRequestDTO;
import net.weg.gestaoestoque2025.DTO.Response.FabricanteResponseDTO;
import net.weg.gestaoestoque2025.Entity.Fabricante;
import net.weg.gestaoestoque2025.Repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FabricanteService {

    private FabricanteRepository repository;

    public FabricanteResponseDTO adicionarFabricante (FabricantePostRequestDTO fabricantePostRequestDTO) {
        Fabricante fabricante = repository.save(fabricantePostRequestDTO.toEntity());
        return fabricante.toDTO();
    }

    public FabricanteResponseDTO buscarFabricante (int id) {
        Fabricante fabricante = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return fabricante.toDTO();
    }

    public Fabricante buscarFabricanteEntidade (int id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<FabricanteResponseDTO> listarFabricante () {
        return repository.findAll().stream().map(Fabricante::toDTO).collect(Collectors.toList());
    }

    /**
     *
     * @param fabricantePostRequestDTO
     * @param id
     * @return DTO de Resposta do Fabricante
     *Funcionamento: Executa a função buscarFabricante(id), para
     */
    public FabricanteResponseDTO atualizarFabricante (FabricantePostRequestDTO fabricantePostRequestDTO, int id) {
        buscarFabricante(id);

        Fabricante fabricante = fabricantePostRequestDTO.toEntity();
        fabricante.setId(id);
        repository.save(fabricante);
        return fabricante.toDTO();
    }

    public void excluirFabricante (int id) {
        buscarFabricante(id);
        repository.deleteById(id);
    }
    
}
