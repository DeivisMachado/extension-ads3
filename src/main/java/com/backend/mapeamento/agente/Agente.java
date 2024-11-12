package com.backend.mapeamento.agente;

import com.backend.mapeamento.cidade.Cidade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
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
@Entity(name = "agente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Agente {

    @Id
    @Column(name = "id_agente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_agente")
    @NotNull(message = "O campo nome não pode ser nulo.")

    private String nome;

    @Column(name = "descricao")
    @NotNull(message = "O campo descrição não pode ser nulo.")

    private String descricao;

    @Column(name = "telefone")
    @NotNull(message = "O campo telefone não pode ser nulo.")

    private String telefone;

    @Column(name = "email")
    @NotNull(message = "O campo email não pode ser nulo.")

    private String email;

    @NotNull(message = "O campo cidade não pode ser nulo.")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Cidade.class)
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @Column(name = "logradouro")
    @NotNull(message = "O logradouro email não pode ser nulo.")

    private String logradouro;

    @Column(name = "numero")
    @NotNull(message = "O campo numero não pode ser nulo.")

    private String numero;

    @Column(name = "cep")
    @NotNull(message = "O campo cep não pode ser nulo.")

    private String cep;

    @Column(name = "bairro")
    @NotNull(message = "O campo bairro não pode ser nulo.")

    private String bairro;

    @Column(name = "complemento")

    private String complemento;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_agente")
    @NotNull(message = "O tipo de agente não pode ser nulo.")
    private TipoAgente tipo;

    public enum TipoAgente {
        INCUBADORA("Incubadora"),
        PREINCUBADORA("Pré-incubadora"),
        ACELERADORA("Aceleradora");

        public final String nome;

        TipoAgente(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return this.nome;
        }
    }
}