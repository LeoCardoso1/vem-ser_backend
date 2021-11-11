package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        pessoaService.findById(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
//        contatoEntity.setIdPessoa(idPessoa);
        ContatoEntity contatoCriado = contatoRepository.save(contatoEntity);
        return objectMapper.convertValue(contatoCriado, ContatoDTO.class);
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void delete(Integer id) throws RegraDeNegocioException{
        ContatoEntity contatoEntity = findById(id);
        contatoRepository.delete(contatoEntity);
    }

    public ContatoEntity findById(Integer idContato) throws RegraDeNegocioException {
        return contatoRepository.findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("contato não encontrado"));
    }

//    public List<ContatoEntity> listByContact(Integer id){return contatoRepository.listByContact(id);}

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        findById(id);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
//        contatoEntity.setIdPessoa(contatoEntity.getIdPessoa());
        contatoEntity.setIdContato(id);
        ContatoEntity update = contatoRepository.save(contatoEntity);
        return objectMapper.convertValue(update, ContatoDTO.class);
    }

    public List<ContatoDTO> listByPessoa(Integer idPessoa) {
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList()).stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}