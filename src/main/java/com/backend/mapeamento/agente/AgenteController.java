package com.backend.mapeamento.agente;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agente")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgente (@PathVariable Integer id) {
         return agenteService.deletar(id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Agente> buscarUm(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(agenteService.buscaPeloId(id));
    }

    @GetMapping
    public ResponseEntity<List<Agente>> buscarVarios() {
        return ResponseEntity.ok(agenteService.buscarVarios());
    }


}
