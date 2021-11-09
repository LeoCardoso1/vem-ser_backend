package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQUENCIA")
    @SequenceGenerator(name = "CONTATO_SEQUENCIA", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    @Column(name= "id_pessoa")
    private Integer idPessoa;

    @Column(name="tipo")
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private TipoContato tipoContato;

    @Column(name="numero")
    @NotNull
    @NotEmpty
    @Size(max = 13)
    private String numero;

    @Column(name="descricao")
    @NotNull
    @NotEmpty
    private String descricao;

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
