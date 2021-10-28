package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/criar")
    public Contato create(@RequestBody Contato contato){return contatoService.create(contato);}

    @GetMapping("/listar")
    public List<Contato> list(){return contatoService.list();}

    @DeleteMapping("/deletar/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/listar/pessoa")
    public List<Contato> listByContact(@RequestParam("id") Integer id){return contatoService.listByContact(id);}

    @PutMapping("/editar/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contato) throws Exception {
        return contatoService.editar(id, contato);
    }
}
