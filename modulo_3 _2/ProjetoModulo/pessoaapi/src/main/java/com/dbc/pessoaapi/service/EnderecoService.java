//package com.dbc.pessoaapi.service;
//
//import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
//import com.dbc.pessoaapi.entity.EnderecoEntity;
//import com.dbc.pessoaapi.repository.EnderecoRepository;
//import com.dbc.pessoaapi.repository.PessoaRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Slf4j
//public class EnderecoService {
//
//    @Autowired
//    private EnderecoRepository enderecoRepository;
//
//    @Autowired
//    private PessoaRepository pessoaRepository;
//
//    public List<EnderecoEntity> list(){return enderecoRepository.list();}
//
//    public EnderecoEntity buscaEndereco(Integer id) throws Exception{return enderecoRepository.buscaEndreco(id);}
//
//    public List<EnderecoEntity> listarEnderecosPessoa(Integer id)
//    {return enderecoRepository.listarEnderecosPessoa(id);}
//
//    public EnderecoEntity criarEnderecoPorIDPessoa(Integer id, EnderecoEntity endereco) throws RegraDeNegocioException
//    {   pessoaRepository.getById(id);
//        endereco.setIdPessoa(id);
//        return enderecoRepository.criarEnderecoPorIDPessoa(endereco);}
//
//    public EnderecoEntity editar(Integer id, EnderecoEntity endereco) throws RegraDeNegocioException{
//        return enderecoRepository.editar(id, endereco);
//    }
//
//    public void excluiEndereco(Integer id) throws RegraDeNegocioException{enderecoRepository.excluiEndereco(id);}
//
//
//
//
//}
