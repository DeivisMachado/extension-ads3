package com.backend.mapeamento.login;

import com.backend.mapeamento.exception.ClientRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.backend.mapeamento.config.JwtService;
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

    public LoginRepresentation.Retorno logIn(LoginRepresentation.Singin representacao) {
        Login login = loginRepository.findByEmailIgnoreCase(representacao.getEmail())
                .orElseThrow(() -> new ClientRequestException("Email não cadastrado!"));

        if (!login.getSenha().equals(representacao.getSenha())) throw new ClientRequestException("Senha incorreta!");

        String token = jwtService.gerarToken(login.getEmail());
        return LoginRepresentation.Retorno.geraRetorno(login, token);
    }
}
