package net.weg.gestaoestoque2025.DTO.Response;

import java.time.Instant;

public record ErrorResponseDTO(
        String mensagem, Instant instant
) {
}
