package com.backend.mapeamento.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LoginDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull(message = "O campo email não pode ser nulo.")
        @Size(max = 100, message = "O campo email não pode ter mais que 100 caracteres.")
        @Size(min = 3, message = "O campo email não pode ter menos que 3 caracteres.")
        private String email;

        @NotNull(message = "O campo senha não pode ser nulo.")
        @Size(max = 10, message = "O campo senha não pode ter mais que 10 caracteres.")
        @Size(min = 6, message = "O campo senha não pode ter menos que 6 caracteres.")
        private String senha;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Integer id;
        private String email;
        private String token;
    }
} 