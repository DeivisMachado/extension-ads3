package com.backend.mapeamento.login;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginRepresentation {

    @Data
    static class Singin {

        @NotNull(message = "O campo email não pode ser nulo.")
        private String email;

        @NotNull(message = "O campo senha não pode ser nulo.")
        private String senha;
    }

    @Data
    @Builder
    static class Retorno {
        private Integer id;
        private String email;
        private String token;

        public static Retorno geraRetorno(Login login, String token) {
            return Retorno.builder()
                    .id(login.getId())
                    .email(login.getEmail())
                    .token(token)
                    .build();
        }
    }

    @Data
    @Builder
    public static class Criar {
        private String email;
        private String senha;
        // adicione outros campos necessários

        public Login transformaEmLogin() {
            return Login.builder()
                .email(this.email)
                .senha(this.senha)
                .build();
        }
    }
}
