package com.backend.mapeamento.login;

import com.backend.mapeamento.exception.ClientRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginRepresentation.Retorno cadastra(LoginRepresentation.Criar representacao) {
        Login loginValidado = validacadastro(representacao);
        return LoginRepresentation.Retorno.geraRetorno(loginRepository.save(loginValidado));
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

        return LoginRepresentation.Retorno.geraRetorno(login);
    }
}
