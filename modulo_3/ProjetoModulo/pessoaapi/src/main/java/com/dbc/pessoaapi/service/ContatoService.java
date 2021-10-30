package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public ContatoEntity create(Integer idPessoa, ContatoEntity contato) throws RegraDeNegocioException{
        pessoaRepository.getById(idPessoa);
        return contatoRepository.create(idPessoa, contato);
    }

    public List<ContatoEntity> list() {return contatoRepository.list();}

    public void delete(Integer id) throws RegraDeNegocioException{
        contatoRepository.delete(id);
    }

    public List<ContatoEntity> listByContact(Integer id){return contatoRepository.listByContact(id);}

    public ContatoEntity editar(Integer id, ContatoEntity contato) throws RegraDeNegocioException {
        return contatoRepository.editar(id, contato);
    }
}