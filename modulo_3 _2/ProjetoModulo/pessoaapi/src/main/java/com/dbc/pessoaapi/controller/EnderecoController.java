//package com.dbc.pessoaapi.controller;
//
//import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
//import com.dbc.pessoaapi.entity.EnderecoEntity;
//import com.dbc.pessoaapi.service.EnderecoService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Slf4j
//@Validated
//@RestController
//@RequestMapping("/endereco")
//public class EnderecoController {
//
//    @Autowired
//    private EnderecoService enderecoService;
//
//
//    @ApiOperation(value = "Retorna a lista de endereços")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna a lista de endereços"),
//            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
//    })
//    @GetMapping("/listar")
//    public List<EnderecoEntity> list(){return enderecoService.list();}
//
//
//    @ApiOperation(value = "Busca um endereço")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna a lista de endereços"),
//            @ApiResponse(code = 400, message = "Endereço não encontrado"),
//            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
//    })
//    @GetMapping("/busca/{idEndereco}")
//    public EnderecoEntity buscaEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
//        return enderecoService.buscaEndereco(id);
//    }
//
//    @ApiOperation(value = "Retorna endereços da pessoa")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna endereços da pessoa"),
//            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
//            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
//    })
//    @GetMapping("/listar/{idPessoa}/pessoa")
//    public List<EnderecoEntity> listarEnderecosPessoa(@PathVariable("idPessoa") Integer id){
//        return enderecoService.listarEnderecosPessoa(id);
//    }
//
//
//    @ApiOperation(value = "Cria endereço pelo id da pessoa")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Cria endereço pelo id da pessoa"),
//            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
//    })
//    @PostMapping("/criar/{idPessoa}")
//    public EnderecoEntity criarEnderecoPorIDPessoa (@PathVariable("idPessoa") Integer id,
//                                                    @Valid @RequestBody EnderecoEntity endereco) throws RegraDeNegocioException {
//        log.info("Iniciando criação de endereço");
//        EnderecoEntity enderecoCriado = enderecoService.criarEnderecoPorIDPessoa(id, endereco);
//        log.info("Criação de endereço feita com sucesso");
//        return enderecoCriado;
//    }
//
//    @ApiOperation(value = "Edita endereço pelo id da pessoa")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Edita endereço pelo id da pessoa"),
//            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
//            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
//    })
//    @PutMapping("/editar/{idEndereco}")
//    public EnderecoEntity editar(@PathVariable ("idEndereco") Integer id,
//                                 @Valid @RequestBody EnderecoEntity endereco) throws RegraDeNegocioException{
//        log.info("Iniciando edição do endereço");
//        EnderecoEntity enderecoEditado = enderecoService.editar(id, endereco);
//        log.info("Edição de endereço feita com sucesso");
//        return endereco;
//    }
//
//    @ApiOperation(value = "Exclui endereço pelo id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Exclui endereço pelo id"),
//            @ApiResponse(code = 400, message = "Endereço não encontrado"),
//            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
//    })
//    @DeleteMapping("/excluir/{idEndereco}")
//    public void excluiEndereco(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException{
//        log.info("Iniciando exclusão de endereço");
//        enderecoService.excluiEndereco(id);
//        log.info("Exclusão de endereço feita com sucesso");
//    }
//
//
//
//
//
//
//}
