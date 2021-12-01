package com.dbc.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PessoaComContatoDTO {

    @NotNull
    private PessoaDTO pessoa;

    private List<ContatoDTO> contatos;

}
