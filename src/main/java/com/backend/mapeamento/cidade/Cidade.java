package com.backend.mapeamento.cidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "cidade")
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
