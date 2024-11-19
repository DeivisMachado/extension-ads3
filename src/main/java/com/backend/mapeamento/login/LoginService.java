package com.backend.mapeamento.login;

import com.backend.mapeamento.exception.ClientRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.backend.mapeamento.config.JwtService;
import com.backend.mapeamento.dto.LoginDTO;
import com.backend.mapeamento.login.LoginRepresentation;

@Service
@AllArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    private final JwtService jwtService;

    public LoginRepresentation.Retorno cadastra(LoginRepresentation.Criar representacao) {
        Login loginValidado = validacadastro(representacao);
        Login loginSalvo = loginRepository.save(loginValidado);
        String token = jwtService.gerarToken(loginSalvo.getEmail());
        return LoginRepresentation.Retorno.geraRetorno(loginSalvo, token);
    }

    private Login validacadastro(LoginRepresentation.Criar representacao) {
        if (loginRepository.existsByEmailIgnoreCase(representacao.getEmail()))
            throw new ClientRequestException("Login já existente.");
        return representacao.transformaEmLogin();
    }

    public LoginRepresentation.Retorno logIn(LoginDTO.Request request) {
        Login login = loginRepository.findByEmailIgnoreCase(request.getEmail())
                .orElseThrow(() -> new ClientRequestException("Email não cadastrado!"));

        if (!login.getSenha().equals(request.getSenha())) throw new ClientRequestException("Senha incorreta!");

        String token = jwtService.gerarToken(login.getEmail());
        return LoginRepresentation.Retorno.geraRetorno(login, token);
    }
}
