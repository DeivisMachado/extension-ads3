package com.backend.mapeamento.agente;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

public interface AgenteRepresentation {

    @Data
    class Criar {
        @NotNull(message = "O campo nome não pode ser nulo.")
        @Size(
                max = 100,
                message = "O campo nome não pode ter mais que 100 caracteres."
        )
        @Size(
                min = 4,
                message = "O campo nome não pode ter menos que 4 caracteres."
        )
        private String nome;

        @NotNull(message = "O campo descricao não pode ser nulo.")
        @Size(
                max = 1500,
                message = "O campo descricao não pode ter mais que 1500 caracteres."
        )
        @Size(
                min = 250,
                message = "O campo descricao não pode ter menos que 250 caracteres."
        )
        private String descricao;

        @NotNull(message = "O campo telefone não pode ser nulo.")
        @Size(
                max = 14,
                min = 13,
                message = "O campo telefone deve ter 13 caracteres."
        )
        private String telefone;

        @NotNull(message = "O campo email não pode ser nulo.")
        @Size(
                max = 150,
                message = "O campo email deve ter no máximo 150 caracteres."
        )
        private String email;

        @NotNull(message = "O campo email não pode ser nulo.")
        private Integer id_cidade;

        @Column(name = "logradouro")
        @NotNull(message = "O logradouro email não pode ser nulo.")
        @Size(
                max = 100
        )
        private String logradouro;

        @Column(name = "numero")
        @NotNull(message = "O campo numero não pode ser nulo.")
        @Size(
                max = 10
        )
        private String numero;

        @Column(name = "cep")
        @NotNull(message = "O campo cep não pode ser nulo.")
        @Size(
                max = 9
        )
        private String cep;

        @Column(name = "bairro")
        @NotNull(message = "O campo bairro não pode ser nulo.")
        @Size(
                max = 100
        )
        private String bairro;

        @Column(name = "complemento")
        @Size(
                max = 50
        )
        private String complemento;

        public Agente transformaEmAgente() {
            return Agente.builder()
                    .nome(this.nome)
                    .descricao(this.descricao)
                    .telefone(this.telefone)
                    .email(this.email)
                    .bairro(this.bairro)
                    .complemento(this.complemento)
                    .cep(this.cep)
                    .numero(this.numero)
                    .logradouro(this.logradouro)
                    .build();
        }
    }


    @Data
    class Atualizar {

        @NotNull(message = "O campo email não pode ser nulo.")
        private Integer id_cidade;

        @NotNull(message = "O campo nome não pode ser nulo.")
        @Size(
                max = 100,
                message = "O campo nome não pode ter mais que 100 caracteres."
        )
        @Size(
                min = 4,
                message = "O campo nome não pode ter menos que 4 caracteres."
        )
        private String nome;

        @NotNull(message = "O campo descricao não pode ser nulo.")
        @Size(
                max = 1500,
                message = "O campo descricao não pode ter mais que 1500 caracteres."
        )
        @Size(
                min = 250,
                message = "O campo descricao não pode ter menos que 250 caracteres."
        )
        private String descricao;

        @NotNull(message = "O campo telefone não pode ser nulo.")
        @Size(
                max = 14,
                min = 13,
                message = "O campo telefone deve ter 13 caracteres."
        )
        private String telefone;

        @NotNull(message = "O campo email não pode ser nulo.")
        @Size(
                max = 150,
                message = "O campo email deve ter no máximo 150 caracteres."
        )
        private String email;

        @Column(name = "logradouro")
        @NotNull(message = "O logradouro email não pode ser nulo.")
        @Size(
                max = 100
        )
        private String logradouro;

        @Column(name = "numero")
        @NotNull(message = "O campo numero não pode ser nulo.")
        @Size(
                max = 10
        )
        private String numero;

        @Column(name = "cep")
        @NotNull(message = "O campo cep não pode ser nulo.")
        @Size(
                max = 9
        )
        private String cep;

        @Column(name = "bairro")
        @NotNull(message = "O campo bairro não pode ser nulo.")
        @Size(
                max = 100
        )
        private String bairro;

        @Column(name = "complemento")
        @Size(
                max = 50
        )
        private String complemento;


        public Agente atualizaAgente(Agente agente) {
            if (this.nome != null) agente.setNome(this.nome);
            if (this.descricao != null) agente.setDescricao(this.descricao);
            if (this.email != null) agente.setEmail(this.email);
            if (this.telefone != null) agente.setTelefone(this.telefone);
            if (this.bairro != null) agente.setBairro(this.bairro);
            if (this.cep != null) agente.setCep(this.cep);
            if (this.logradouro != null) agente.setLogradouro(this.logradouro);
            if (this.numero != null) agente.setNumero(this.numero);
            if (this.complemento != null) agente.setComplemento(this.complemento);

            return agente;
        }
    }
}