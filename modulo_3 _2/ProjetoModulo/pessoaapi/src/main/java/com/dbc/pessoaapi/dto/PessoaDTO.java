package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaDTO {
    private Integer idPessoa;
    @NotEmpty
    @NotBlank
    @ToString.Exclude
    @ApiModelProperty(value = "Nome da pessoa")
    private String nome;

    @NotNull
    @ApiModelProperty(value = "Data de nascimento")
    private LocalDate dataNascimento;

    @NotNull
    @ApiModelProperty(value = "Email")
    private String email;
}