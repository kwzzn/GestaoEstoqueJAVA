package net.weg.gestaoestoque2025.Controller;

import net.weg.gestaoestoque2025.DTO.Response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.text.html.parser.Entity;
import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDTO> handleNoSuchElementException(NoSuchElementException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(error, HttpStatus.LOCKED);
    }

//    @ExceptionHandler(exception = {
//            NoSuchElementException.class,
//            NoSuchFieldError.class
//    })
//    public ResponseEntity<ErrorResponseDTO> handleNoSuch(Exception exception) {
//        ErrorResponseDTO error = new ErrorResponseDTO(exception.getMessage(), Instant.now());
//        return new ResponseEntity<>(error, HttpStatus.LOCKED);
//    }

}
