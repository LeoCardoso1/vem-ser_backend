//package com.dbc.pessoaapi.dto;
//
//
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//import javax.validation.constraints.*;
//import java.time.LocalDate;
//
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
//
//public class PessoaEDadosPessoaisDTO {
//
//    @Past
//    @NotNull
//    @ApiModelProperty("Data de Nascimento")
//    private LocalDate dataNascimento;
//
//    @Email
//    @NotEmpty
//    @NotBlank
//    @ApiModelProperty("Email da pessoa")
//    private String email;
//
////    private DadosPessoaisDTO dadosPessoaisDTO;
//}
