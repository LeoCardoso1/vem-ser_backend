package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Validated
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }


    @PostMapping("/criar")
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoaDTO) throws Exception{
        log.info("Iniciando criação de pessoa");
        PessoaDTO pessoaCriada = pessoaService.create(pessoaDTO);
        log.info("Pessoa criada com sucesso!");
        return pessoaCriada;
    }


    @GetMapping("/listar")
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                               @Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("Iniciando edição de pessoa");
        PessoaDTO pessoaEditada = pessoaService.update(id, pessoaCreateDTO);
        log.info("Edição de pessoa feita com sucesso");
        return pessoaEditada;
    }


    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException{
        log.info("Iniciando exclusão de pessoa");
        pessoaService.delete(id);
        log.info("Exclusão de pessoa feita com sucesso");
    }
}
