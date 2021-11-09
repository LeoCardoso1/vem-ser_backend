package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        pessoaService.findById(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoEntity.setIdPessoa(idPessoa);
        ContatoEntity contatoCriado = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoRepository> list() {return contatoRepository.findAll();}

    public void delete(Integer id) throws RegraDeNegocioException{
        contatoRepository.delete(id);
    }

    public ContatoEntity findById(Integer idContato) throws RegraDeNegocioException {
        ContatoEntity entity = contatoRepository.findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("contato não encontrado"));
        return entity;
    }

//    public List<ContatoEntity> listByContact(Integer id){return contatoRepository.listByContact(id);}

    public ContatoEntity editar(Integer id, ContatoEntity contato) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = findById(idContato);
        ContatoEntity entity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        entity.setIdPessoa(contatoEntity.getIdPessoa());
        entity.setIdContato(idContato);
        ContatoEntity update = contatoRepository.save(entity);
        ContatoDTO contatoDTO = objectMapper.convertValue(update, ContatoDTO.class);
        return contatoDTO;
    }
}