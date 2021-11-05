package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.service.DadosPessoaisService;
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
@RequestMapping("/dados-pessoais")

public class DadosPessoaisController {

    private final DadosPessoaisService dadosPessoaisService;

    @ApiOperation(value = "Listar dados pessoais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar dados pessoais"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/listar/")
    public List<DadosPessoaisDTO> listar() {
        return dadosPessoaisService.listar();
    }


    @ApiOperation(value = "Criar dados pessoais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criar dados pessoais"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PostMapping("/criar/")
    public DadosPessoaisDTO criar(@RequestBody DadosPessoaisDTO dadosPessoaisDto) {
        return dadosPessoaisService.criar(dadosPessoaisDto);
    }


    @ApiOperation(value = "Listar dados por cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pesquisar dados por cpf"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/dados-pessoais/{cpf}")
    public DadosPessoaisDTO listarDadosPorCpf(@PathVariable String cpf) throws RegraDeNegocioException {
        return dadosPessoaisService.listarDadosPorCpf(cpf);
    }
}


