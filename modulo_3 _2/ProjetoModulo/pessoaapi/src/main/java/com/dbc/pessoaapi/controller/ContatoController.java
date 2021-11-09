package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/contato")
public class ContatoController {

    final private ContatoService contatoService;

    @ApiOperation(value = "Criar contato por id de pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criar contato por id de pessoa"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PostMapping("/criar/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                                @Valid @RequestBody ContatoCreateDTO contatoCreateDTO)throws RegraDeNegocioException{
            log.info("Iniciando criação de contato");
            ContatoDTO contatoCriado = contatoService.create(idPessoa, contatoCreateDTO);
            log.info("Criação de contato feita com sucesso");
            return contatoCriado;
    }

    @ApiOperation(value = "Listar contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar Contatos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/listar")
    public List<ContatoDTO> list(){return contatoService.list();}


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
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/listar/pessoa")
    public List<ContatoDTO> listByPessoa(@RequestParam("id") Integer id){return contatoService.listByPessoa(id);}


    @ApiOperation(value = "Editar contato por id de contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Editar contato por id de contato"),
            @ApiResponse(code = 400, message = "Contato não encontrado"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PutMapping("/editar/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer id,
                                @Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("Iniciando edição de contato");
        ContatoDTO contatoEditado = contatoService.update(id, contatoCreateDTO);
        log.info("Edição de contato feita com sucesso");
        return contatoEditado;
    }
}
