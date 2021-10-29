package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Endereco> list(){return enderecoRepository.list();}

    public Endereco buscaEndereco(Integer id) throws Exception{return enderecoRepository.buscaEndreco(id);}

    public List<Endereco> listarEnderecosPessoa(Integer id)
    {return enderecoRepository.listarEnderecosPessoa(id);}

    public Endereco criarEnderecoPorIDPessoa(Integer id, Endereco endereco) throws RegraDeNegocioException
    {   pessoaRepository.getById(id);
        endereco.setIdPessoa(id);
        return enderecoRepository.criarEnderecoPorIDPessoa(endereco);}

    public Endereco editar(Integer id, Endereco endereco) throws RegraDeNegocioException{
        return enderecoRepository.editar(id, endereco);
    }

    public void excluiEndereco(Integer id) throws RegraDeNegocioException{enderecoRepository.excluiEndereco(id);}




}
