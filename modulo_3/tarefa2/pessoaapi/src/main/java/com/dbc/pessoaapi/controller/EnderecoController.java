package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/listar")
    public List<Endereco> list(){return enderecoService.list();}

    @GetMapping("/busca/{idEndereco}")
    public Endereco buscaEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.buscaEndereco(id);
    }

    @GetMapping("/listar/{idPessoa}/pessoa")
    public List<Endereco> listarEnderecosPessoa(@PathVariable("idPessoa") Integer id){
        return enderecoService.listarEnderecosPessoa(id);
    }


    @PostMapping("/criar/{idPessoa}")
    public Endereco criarEnderecoPorIDPessoa (@PathVariable("idPessoa") Integer id, @RequestBody Endereco endereco){
        return enderecoService.criarEnderecoPorIDPessoa(id, endereco);
    }

    @PutMapping("/editar/{idEndereco}")
    public Endereco editar(@PathVariable ("idEndereco") Integer id,
            @RequestBody Endereco endereco) throws Exception{
        return enderecoService.editar(id, endereco);
    }

    @DeleteMapping("/excluir/{idEndereco}")
    public void excluiEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
        enderecoService.excluiEndereco(id);
    }






}
