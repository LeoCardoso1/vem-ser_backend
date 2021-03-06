package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

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

//    @Column(name= "id_pessoa")
//    private Integer idPessoa;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="tipo")
    private TipoEndereco tipo;

    @Column(name="logradouro")
    private String logradouro;

    @Column(name= "numero")
    private Integer numero;

    @Column(name= "complemento")
    private String complemento;

    @Column(name= "cep")
    private String cep;

    @Column(name= "cidade")
    private String cidade;

    @Column(name= "estado")
    private String estado;

    @Column(name= "pais")
    private String pais;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;
}
