package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DadosPessoaisService {

    private final DadosPessoaisClient dadosPessoaisClient;

    public List<DadosPessoaisDTO> listar(){
        return dadosPessoaisClient.listar();
    }

    public DadosPessoaisDTO criar(DadosPessoaisDTO dadosPessoaisDTO){
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO listarDadosPorCpf(String cpf) throws RegraDeNegocioException {
        return dadosPessoaisClient.getPorCpf(cpf);
    }


}
