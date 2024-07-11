package com.backend.mapeamento.login;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "login")
public class Login {

    @Id
    @Column(name = "id_login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    @NotNull(message = "O campo email não pode ser nulo.")
    @Size(
            max = 100,
            message = "O campo email não pode ter mais que 100 caracteres."
    )
    @Size(
            min = 3,
            message = "O campo email não pode ter menos que 3 caracteres."
    )
    private String email;

    @Column(name = "senha")
    @NotNull(message = "O campo senha não pode ser nulo.")
    @Size(
            max = 10,
            message = "O campo senha não pode ter mais que 10 caracteres."
    )
    @Size(
            min = 6,
            message = "O campo senha não pode ter menos que 6 caracteres."
    )
    private String senha;

}
