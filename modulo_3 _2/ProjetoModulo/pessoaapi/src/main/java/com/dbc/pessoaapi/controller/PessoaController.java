package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.service.PessoaService;
import freemarker.template.TemplateException;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Validated
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;


    @ApiOperation(value = "Cria uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PostMapping("/criar")
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoaDTO) throws Exception{
        log.info("Iniciando criação de pessoa");
        PessoaDTO pessoaCriada = pessoaService.create(pessoaDTO);
        log.info("Pessoa criada com sucesso!");
        return pessoaCriada;
    }

    @ApiOperation(value = "Retorna a lista de pessoas")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna lista de pessoas"),
        @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/listar")
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @ApiOperation(value = "Retorna a lista de pessoas por nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lista de pessoas por nome"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @ApiOperation(value = "Edita uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Edita uma pessoa"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PutMapping("/editar/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                               @Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException,
            MessagingException, TemplateException, IOException {
        log.info("Iniciando edição de pessoa");
        PessoaDTO pessoaEditada = pessoaService.update(id, pessoaCreateDTO);
        log.info("Edição de pessoa feita com sucesso");
        return pessoaEditada;
    }

    @ApiOperation(value = "Deleta uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleta uma pessoa"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException, MessagingException,
            TemplateException, IOException {
        log.info("Iniciando exclusão de pessoa");
        pessoaService.delete(id);
        log.info("Exclusão de pessoa feita com sucesso");
    }



}
