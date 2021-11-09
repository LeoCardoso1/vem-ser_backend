package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ENDERECO_PESSOA")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQUENCIA")
    @SequenceGenerator(name = "ENDERECO_SEQUENCIA", sequenceName = "seq_endereco", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Column(name= "id_pessoa")
    private Integer idPessoa;

    @Column(name="tipo")
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private TipoEndereco tipo;

    @Column(name="logadouro")
    @NotNull
    @Size(max = 250)
    private String logadouro;

    @Column(name= "numero")
    @NotNull
    private Integer numero;

    @Column(name= "complemento")
    private String complemento;

    @Column(name= "cep")
    @NotNull
    @Size(min = 8, max = 8)
    private String cep;

    @Column(name= "cidade")
    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @Column(name= "estado")
    @NotNull
    private String estado;

    @Column(name= "pais")
    @NotNull
    private String pais;

}
