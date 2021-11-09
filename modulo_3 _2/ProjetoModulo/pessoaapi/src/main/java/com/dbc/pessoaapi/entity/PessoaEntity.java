package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQUENCIA")
    @SequenceGenerator(name = "PESSOA_SEQUENCIA", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name="nome")
    private String nome;

    @Column(name="data_nascimento")
    private LocalDate dataNascimento;

    @Column(name="cpf")
    private String cpf;

    @Column(name="email")
    private String email;

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}