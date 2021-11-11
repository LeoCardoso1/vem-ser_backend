package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.service.EnderecoService;
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
@RestController
@RequiredArgsConstructor
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @ApiOperation(value = "Cria endereço pelo id da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria endereço pelo id da pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PostMapping("/criar/{idPessoa}")
    public EnderecoDTO criarEnderecoPorIDPessoa (@PathVariable("idPessoa") Integer id,
                                                 @Valid @RequestBody EnderecoCreateDTO enderecoCreateDTO)
            throws RegraDeNegocioException {
        log.info("Iniciando criação de endereço");
        EnderecoDTO enderecoDTO = enderecoService.create(enderecoCreateDTO);
        log.info("Criação de endereço feita com sucesso");
        return enderecoDTO;
    }

    @ApiOperation(value = "Retorna a lista de endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de endereços"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @GetMapping("/listar")
    public List<EnderecoDTO> list(){return enderecoService.list();}

//    @ApiOperation(value = "Busca um endereço")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna a lista de endereços"),
//            @ApiResponse(code = 400, message = "Endereço não encontrado"),
//            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
//    })
//    @GetMapping("/busca/{idEndereco}")
//    public EnderecoDTO listByEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
//        return enderecoService.listbyEndereco(idEndereco);
//    }

//    @ApiOperation(value = "Retorna os endereços da pessoa")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna endereços da pessoa"),
//            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
//            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
//    })
//    @GetMapping("/listar/{idPessoa}/pessoa")
//    public List<EnderecoDTO> listByPessoa(@PathVariable("idPessoa") Integer idPessoa){
//        return enderecoService.listByPessoa(idPessoa);
//    }


    @ApiOperation(value = "Edita endereço pelo id da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Edita endereço pelo id da pessoa"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @PutMapping("/editar/{idEndereco}")
    public EnderecoDTO uptade(@PathVariable ("idEndereco") Integer idEndereco,
                                 @Valid @RequestBody EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException{
        log.info("Iniciando edição do endereço");
        EnderecoDTO enderecoDTO = enderecoService.update(idEndereco, enderecoCreateDTO);
        log.info("Edição de endereço feita com sucesso");
        return enderecoDTO;
    }

    @ApiOperation(value = "Exclui endereço pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exclui endereço pelo id"),
            @ApiResponse(code = 400, message = "Endereço não encontrado"),
            @ApiResponse(code = 403, message = "Você não tem permissao para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão"),
    })
    @DeleteMapping("/excluir/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException{
        log.info("Iniciando exclusão de endereço");
        enderecoService.delete(idEndereco);
        log.info("Exclusão de endereço feita com sucesso");
    }

}
