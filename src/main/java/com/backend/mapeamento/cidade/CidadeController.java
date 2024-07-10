package com.backend.mapeamento.cidade;

import com.backend.mapeamento.agente.Agente;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
@CrossOrigin("*")
@AllArgsConstructor
public class CidadeController {

    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> cadastrar(
            @Valid @RequestBody CidadeRepresentation.Criar representacao
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.cadastrar(representacao));
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> buscarVarios() {
        return ResponseEntity.ok(cidadeService.buscaTodos());
    }


}
