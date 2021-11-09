package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;


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

    @Enumerated(EnumType.ORDINAL)
    @Column(name="tipo")
    private TipoContato tipoContato;

    @Column(name="numero")
    private String numero;

    @Column(name="descricao")
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