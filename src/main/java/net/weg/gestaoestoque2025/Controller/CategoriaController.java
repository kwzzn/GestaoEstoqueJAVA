package net.weg.gestaoestoque2025.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.gestaoestoque2025.DTO.Request.CategoriaPostRequestDTO;
import net.weg.gestaoestoque2025.DTO.Response.CategoriaResponseDTO;
import net.weg.gestaoestoque2025.Service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaController {

    private CategoriaService service;

    @Operation(description = "Método para postar Categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro do Cliente"),
            @ApiResponse(responseCode = "500", description = "Erro do Server")
    })
    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> postCategoria(@RequestBody @Valid CategoriaPostRequestDTO categoriaPostRequestDTO) {
        try {
            return new ResponseEntity<>(service.adicionarCategoria(categoriaPostRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> getCategoria() {
        try {
            return new ResponseEntity<>(service.listarCategoria(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> getCategoriaById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.buscarCategoria(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> putCategoria(@RequestBody @Valid CategoriaPostRequestDTO categoriaPostRequestDTO, @PathVariable int id) {
        try {
            return new ResponseEntity<>(service.atualizarCategoria(categoriaPostRequestDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable int id) {
        try {
            service.excluirCategoria(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
