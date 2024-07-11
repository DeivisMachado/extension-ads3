package com.backend.mapeamento.login;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginRepresentation.Retorno> login(
            @Valid @RequestBody LoginRepresentation.Singin representacao
    ) {
        return ResponseEntity.ok(loginService.logIn(representacao));
    }

    @PostMapping("/cadastra")
    public ResponseEntity<LoginRepresentation.Retorno> cadastra(
            @Valid @RequestBody LoginRepresentation.Criar representacao
    ) {
        return ResponseEntity.ok(loginService.cadastra(representacao));
    }
}
