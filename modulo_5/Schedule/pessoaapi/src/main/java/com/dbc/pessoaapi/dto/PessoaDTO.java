package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @ApiModelProperty(value = "Data de nascimento, formato ano-mes-dia")
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "Deve conter 11 dígitos")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("CPF da pessoa, sómente números")
    private String cpf;

    @NotNull
    @ApiModelProperty(value = "Email da pessoa")
    private String email;
}