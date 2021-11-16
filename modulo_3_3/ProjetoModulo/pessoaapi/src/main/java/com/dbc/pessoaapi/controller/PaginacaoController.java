package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paginacao")
public class PaginacaoController {

    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping("/contatos-ordenados-descricao/")
    public Page<ContatoEntity> contatosOrdenadosDescricao(
            @RequestParam Integer pagina,
            @RequestParam Integer qtdRegistrosPagina){
        Pageable pageable = PageRequest.of(pagina, qtdRegistrosPagina,
                Sort.by("descricao")
        );
        return contatoRepository.findAll(pageable);
    }

    @GetMapping("/enderecos-por-cep/")
    public Page<EnderecoEntity> enderecosPorCEP(
            @RequestParam Integer pagina,
            @RequestParam Integer qtdRegistrosPagina){
        Pageable pageable = PageRequest.of(pagina, qtdRegistrosPagina,
                Sort.by("cep")
        );
        return enderecoRepository.findAll(pageable);
    }

    @GetMapping("/enderecos-por-pais/")
    public Page<EnderecoEntity> enderecosPorPais(
            @RequestParam Integer pagina,
            @RequestParam Integer qtdRegistrosPagina,
            @RequestParam String pais){
        Pageable pageable = PageRequest.of(pagina, qtdRegistrosPagina);
        return enderecoRepository.findByPais(pais, pageable);
    }




}
