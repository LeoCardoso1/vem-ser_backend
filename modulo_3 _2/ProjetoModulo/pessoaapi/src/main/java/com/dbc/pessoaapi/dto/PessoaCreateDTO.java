package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    @NotEmpty
    @NotBlank
    @ToString.Exclude
    @ApiModelProperty(value = "Nome da pessoa")
    private String nome;

    @NotNull
    @ApiModelProperty(value = "Nascimento")
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
    @NotNull
    @ApiModelProperty(value = "Cpf")
    private String cpf;

    @Email
    @ApiModelProperty(value = "Email")
    private String email;
}