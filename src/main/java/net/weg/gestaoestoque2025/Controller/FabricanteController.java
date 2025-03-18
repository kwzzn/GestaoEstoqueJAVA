package net.weg.gestaoestoque2025.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.gestaoestoque2025.DTO.Request.FabricantePostRequestDTO;
import net.weg.gestaoestoque2025.DTO.Response.FabricanteResponseDTO;
import net.weg.gestaoestoque2025.Service.FabricanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricante")
@AllArgsConstructor
public class FabricanteController {

    private FabricanteService service;

    @PostMapping
    public ResponseEntity<FabricanteResponseDTO> postFabricante(@RequestBody @Valid FabricantePostRequestDTO fabricantePostRequestDTO) {
        try {
            return new ResponseEntity<>(service.adicionarFabricante(fabricantePostRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<FabricanteResponseDTO>> getFabricante() {
        try {
            return new ResponseEntity<>(service.listarFabricante(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> getFabricanteById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.buscarFabricante(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> putFabricante(@RequestBody @Valid FabricantePostRequestDTO fabricantePostRequestDTO, @PathVariable int id) {
        try {
            return new ResponseEntity<>(service.atualizarFabricante(fabricantePostRequestDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricante(@PathVariable int id) {
        try {
            service.excluirFabricante(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
