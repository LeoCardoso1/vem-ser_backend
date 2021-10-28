package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.awt.*;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato create(Contato contato){return contatoRepository.create(contato);}

    public List<Contato> list() {return contatoRepository.list();}

    public void delete(Integer id) throws Exception{
        contatoRepository.delete(id);
    }

    public List<Contato> listByContact(Integer id){return contatoRepository.listByContact(id);}

    public Contato editar(Integer id, Contato contato) throws Exception {
        return contatoRepository.editar(id, contato);
    }
}