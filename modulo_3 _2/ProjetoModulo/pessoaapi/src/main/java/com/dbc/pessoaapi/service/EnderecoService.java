package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;


    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException{
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.save(enderecoEntity);
        return objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
    }

    public List<EnderecoDTO> list(){return enderecoRepository.findAll()
            .stream()
            .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
            .collect(Collectors.toList());
    }

//    public EnderecoDTO listByEndereco(Integer idEndereco) throws RegraDeNegocioException {
//        EnderecoEntity enderecoRecuperado = enderecoRepository.listByEndereco(idEndereco);
//        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
//        return enderecoDTO;
//    }
//
//    public List<EnderecoDTO> listByPessoa(Integer idPessoa) {
//        return enderecoRepository.listByPessoa(idPessoa).stream()
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
//                .collect(Collectors.toList());
//    }

    public EnderecoEntity findById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity entity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return entity;
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException{
        findById(id);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        enderecoEntity.setIdEndereco(id);
        EnderecoEntity update = enderecoRepository.save(enderecoEntity);
        return objectMapper.convertValue(update, EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity entity = findById(id);
        enderecoRepository.delete(entity);
    }



}
