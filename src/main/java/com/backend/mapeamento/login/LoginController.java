package com.backend.mapeamento.login;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.mapeamento.dto.LoginDTO;
import com.backend.mapeamento.mapper.ModelMapper;


@RestController
@RequestMapping("/login")
@CrossOrigin("*")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<LoginRepresentation.Retorno> login(
            @Valid @RequestBody LoginDTO.Request request
    ) {
        return ResponseEntity.ok(loginService.logIn(request));
    }

    @PostMapping("/cadastra")
    public ResponseEntity<LoginRepresentation.Retorno> cadastra(
            @Valid @RequestBody LoginDTO.Request request
    ) {
        var representation = mapper.map(request, LoginRepresentation.Criar.class);
        return ResponseEntity.ok(loginService.cadastra(representation));
    }
}
