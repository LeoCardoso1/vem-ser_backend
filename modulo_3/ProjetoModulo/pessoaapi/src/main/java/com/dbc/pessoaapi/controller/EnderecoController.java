package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/listar")
    public List<EnderecoEntity> list(){return enderecoService.list();}

    @GetMapping("/busca/{idEndereco}")
    public EnderecoEntity buscaEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.buscaEndereco(id);
    }

    @GetMapping("/listar/{idPessoa}/pessoa")
    public List<EnderecoEntity> listarEnderecosPessoa(@PathVariable("idPessoa") Integer id){
        return enderecoService.listarEnderecosPessoa(id);
    }


    @PostMapping("/criar/{idPessoa}")
    public EnderecoEntity criarEnderecoPorIDPessoa (@PathVariable("idPessoa") Integer id,
                                                    @Valid @RequestBody EnderecoEntity endereco) throws RegraDeNegocioException {
        log.info("Iniciando criação de endereço");
        EnderecoEntity enderecoCriado = enderecoService.criarEnderecoPorIDPessoa(id, endereco);
        log.info("Criação de endereço feita com sucesso");
        return enderecoCriado;
    }

    @PutMapping("/editar/{idEndereco}")
    public EnderecoEntity editar(@PathVariable ("idEndereco") Integer id,
                                 @Valid @RequestBody EnderecoEntity endereco) throws RegraDeNegocioException{
        log.info("Iniciando edição do endereço");
        EnderecoEntity enderecoEditado = enderecoService.editar(id, endereco);
        log.info("Edição de endereço feita com sucesso");
        return endereco;
    }

    @DeleteMapping("/excluir/{idEndereco}")
    public void excluiEndereco(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException{
        log.info("Iniciando exclusão de endereço");
        enderecoService.excluiEndereco(id);
        log.info("Exclusão de endereço feita com sucesso");
    }






}
