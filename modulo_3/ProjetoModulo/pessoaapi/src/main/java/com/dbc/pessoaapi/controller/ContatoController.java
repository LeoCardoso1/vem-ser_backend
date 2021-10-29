package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/criar/{idPessoa}")
    public Contato create(@PathVariable("idPessoa") Integer idPessoa,
            @Valid @RequestBody Contato contato)throws RegraDeNegocioException
            {return contatoService.create(idPessoa, contato);}

    @GetMapping("/listar")
    public List<Contato> list(){return contatoService.list();}

    @DeleteMapping("/deletar/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }

    @GetMapping("/listar/pessoa")
    public List<Contato> listByContact(@RequestParam("id") Integer id){return contatoService.listByContact(id);}

    @PutMapping("/editar/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @Valid @RequestBody Contato contato) throws RegraDeNegocioException {
        return contatoService.editar(id, contato);
    }
}
