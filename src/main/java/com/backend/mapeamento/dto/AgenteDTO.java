package com.backend.mapeamento.dto;

import com.backend.mapeamento.agente.Agente;
import com.backend.mapeamento.dto.CidadeDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AgenteDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull(message = "O campo nome não pode ser nulo.")
        private String nome;
        
        @NotNull(message = "O campo descrição não pode ser nulo.")
        private String descricao;
        
        @NotNull(message = "O campo telefone não pode ser nulo.")
        private String telefone;
        
        @NotNull(message = "O campo email não pode ser nulo.")
        private String email;
        
        @NotNull(message = "O campo cidade não pode ser nulo.")
        private Integer idCidade;
        
        @NotNull(message = "O logradouro não pode ser nulo.")
        private String logradouro;
        
        @NotNull(message = "O campo numero não pode ser nulo.")
        private String numero;
        
        @NotNull(message = "O campo cep não pode ser nulo.")
        private String cep;
        
        @NotNull(message = "O campo bairro não pode ser nulo.")
        private String bairro;
        
        private String complemento;
        
        @NotNull(message = "O tipo de agente não pode ser nulo.")
        private Agente.TipoAgente tipo;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Integer id;
        private String nome;
        private String descricao;
        private String telefone;
        private String email;
        private CidadeDTO.Response cidade;
        private String logradouro;
        private String numero;
        private String cep;
        private String bairro;
        private String complemento;
        private Agente.TipoAgente tipo;
    }
} 