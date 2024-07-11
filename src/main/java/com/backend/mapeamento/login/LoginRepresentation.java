package com.backend.mapeamento.login;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

public interface LoginRepresentation {

    @Data
    class Singin {

        @NotNull(message = "O campo email não pode ser nulo.")
        private String email;

        @NotNull(message = "O campo senha não pode ser nulo.")
        private String senha;
    }

    @Data
    @Builder
    class Retorno {
        private Integer id;
        private String email;

        public static Retorno geraRetorno(Login login) {
            return Retorno.builder()
                    .id(login.getId())
                    .email(login.getEmail())
                    .build();
        }
    }

    @Data
    class Criar {

        @NotNull(message = "O campo email não pode ser nulo.")
        private String email;

        @NotNull(message = "O campo senha não pode ser nulo.")
        private String senha;

        public Login transformaEmLogin() {
            return Login.builder()
                    .email(this.email)
                    .senha(this.senha)
                    .build();
        }
    }
}
