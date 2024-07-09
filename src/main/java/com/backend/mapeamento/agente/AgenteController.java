package com.backend.mapeamento.agente;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
@AllArgsConstructor
public class AgenteController {

    private AgenteService agenteService;

    @PostMapping
    public ResponseEntity<Agente> cadastrar(
                @Valid @RequestBody AgenteRepresentation.Criar representacao
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(agenteService.cadastrar(representacao));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Agente> atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody AgenteRepresentation.Atualizar representacao
    ) {
        return ResponseEntity
                .ok(agenteService.atualizar(id, representacao));

    }

}
