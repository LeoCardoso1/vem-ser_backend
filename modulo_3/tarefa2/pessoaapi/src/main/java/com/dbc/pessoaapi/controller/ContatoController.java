package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(){contatoService = new ContatoService();}

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

}
