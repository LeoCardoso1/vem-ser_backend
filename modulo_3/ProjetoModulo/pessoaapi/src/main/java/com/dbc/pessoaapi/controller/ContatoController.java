package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
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

    @PostMapping("/criar/{idPessoa}")
    public ContatoEntity create(@PathVariable("idPessoa") Integer idPessoa,
                                @Valid @RequestBody ContatoEntity contato)throws RegraDeNegocioException{
            log.info("Iniciando criação de contato");
            ContatoEntity contatoCriado = contatoService.create(idPessoa, contato);
            log.info("Criação de contato feita com sucesso");
            return contatoCriado;
    }


    @GetMapping("/listar")
    public List<ContatoEntity> list(){return contatoService.list();}

    @DeleteMapping("/deletar/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("Iniciando exclusão de contato");
        contatoService.delete(id);
        log.info("Exclusão de contato feita com sucesso");
    }

    @GetMapping("/listar/pessoa")
    public List<ContatoEntity> listByContact(@RequestParam("id") Integer id){return contatoService.listByContact(id);}

    @PutMapping("/editar/{idContato}")
    public ContatoEntity update(@PathVariable("idContato") Integer id,
                                @Valid @RequestBody ContatoEntity contato) throws RegraDeNegocioException {
        log.info("Iniciando edição de contato");
        ContatoEntity contatoEditado = contatoService.editar(id, contato);
        log.info("Edição de contato feita com sucesso");
        return contatoEditado;
    }
}
