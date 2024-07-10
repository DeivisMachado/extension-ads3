package com.backend.mapeamento.cidade;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public interface CidadeRepresentation {

    @Data
    class Criar {

        @NotNull(message = "O campo nome não pode ser nulo.")
        private String nome;

        public Cidade transformaEmCidade() {
            return Cidade.builder().nome(this.nome).build();
        }
    }
}
