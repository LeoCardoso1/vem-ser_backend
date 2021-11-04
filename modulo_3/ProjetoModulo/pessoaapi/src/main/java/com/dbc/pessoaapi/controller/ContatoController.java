package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @ApiOperation(value = "Criar contato por id de pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criar contato por id de pessoa"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PostMapping("/criar/{idPessoa}")
    public ContatoEntity create(@PathVariable("idPessoa") Integer idPessoa,
                                @Valid @RequestBody ContatoEntity contato)throws RegraDeNegocioException{
            log.info("Iniciando criação de contato");
            ContatoEntity contatoCriado = contatoService.create(idPessoa, contato);
            log.info("Criação de contato feita com sucesso");
            return contatoCriado;
    }

    @ApiOperation(value = "Listar contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar Contatos"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/listar")
    public List<ContatoEntity> list(){return contatoService.list();}


    @ApiOperation(value = "Deletar contato por id de contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletar contato por id de contato"),
            @ApiResponse(code = 400, message = "Contato não encontrado"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @DeleteMapping("/deletar/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("Iniciando exclusão de contato");
        contatoService.delete(id);
        log.info("Exclusão de contato feita com sucesso");
    }

    @ApiOperation(value = "Listar contatos por id de pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar contatos por id de pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/listar/pessoa")
    public List<ContatoEntity> listByContact(@RequestParam("id") Integer id){return contatoService.listByContact(id);}


    @ApiOperation(value = "Editar contato por id de contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Editar contato por id de contato"),
            @ApiResponse(code = 400, message = "Contato não encontrado"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PutMapping("/editar/{idContato}")
    public ContatoEntity update(@PathVariable("idContato") Integer id,
                                @Valid @RequestBody ContatoEntity contato) throws RegraDeNegocioException {
        log.info("Iniciando edição de contato");
        ContatoEntity contatoEditado = contatoService.editar(id, contato);
        log.info("Edição de contato feita com sucesso");
        return contatoEditado;
    }
}
