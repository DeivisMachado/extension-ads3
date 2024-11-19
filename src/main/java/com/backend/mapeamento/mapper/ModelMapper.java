package com.backend.mapeamento.mapper;

import com.backend.mapeamento.agente.Agente;
import com.backend.mapeamento.cidade.Cidade;
import com.backend.mapeamento.dto.AgenteDTO;
import com.backend.mapeamento.dto.CidadeDTO;
import com.backend.mapeamento.dto.LoginDTO;
import com.backend.mapeamento.dto.LoginDTO.Request;
import com.backend.mapeamento.login.Login;
import com.backend.mapeamento.login.LoginRepresentation;
import com.backend.mapeamento.login.LoginRepresentation.Criar;

import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public Login toLogin(LoginDTO.Request dto) {
        return Login.builder()
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();
    }

    public LoginDTO.Response toLoginDTO(Login login, String token) {
        return LoginDTO.Response.builder()
                .id(login.getId())
                .email(login.getEmail())
                .token(token)
                .build();
    }

    public Agente toAgente(AgenteDTO.Request dto, Cidade cidade) {
        return Agente.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .telefone(dto.getTelefone())
                .email(dto.getEmail())
                .cidade(cidade)
                .logradouro(dto.getLogradouro())
                .numero(dto.getNumero())
                .cep(dto.getCep())
                .bairro(dto.getBairro())
                .complemento(dto.getComplemento())
                .tipo(dto.getTipo())
                .build();
    }

    public AgenteDTO.Response toAgenteDTO(Agente agente) {
        return AgenteDTO.Response.builder()
                .id(agente.getId())
                .nome(agente.getNome())
                .descricao(agente.getDescricao())
                .telefone(agente.getTelefone())
                .email(agente.getEmail())
                .cidade(toCidadeDTO(agente.getCidade()))
                .logradouro(agente.getLogradouro())
                .numero(agente.getNumero())
                .cep(agente.getCep())
                .bairro(agente.getBairro())
                .complemento(agente.getComplemento())
                .tipo(agente.getTipo())
                .build();
    }

    public CidadeDTO.Response toCidadeDTO(Cidade cidade) {
        return CidadeDTO.Response.builder()
                .id(cidade.getId())
                .nome(cidade.getNome())
                .build();
    }

    public Criar map(Request request, Class<Criar> class1) {
        return LoginRepresentation.Criar.builder()
                .email(request.getEmail())
                .senha(request.getSenha())
                .build();
    }

} 