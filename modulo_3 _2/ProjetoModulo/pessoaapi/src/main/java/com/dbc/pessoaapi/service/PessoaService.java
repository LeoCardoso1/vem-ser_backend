package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO)
            throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoaEntity);
        return objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        //        emailService.enviarEmailSimples(pessoaDTO);
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().
                stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        findById(id);
        PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        entity.setIdPessoa(id);
        PessoaEntity update = pessoaRepository.save(entity);
        return objectMapper.convertValue(update, PessoaDTO.class);
    }

    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não encontrada"));
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        return objectMapper.convertValue(entity, PessoaDTO.class);
    }
    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = findById(id);
        pessoaRepository.delete(pessoaEntity);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll()
                .stream()
                .filter(pessoa -> pessoa.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList()).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaComContatoDTO> listByPessoaComContato(Integer id){
        if(id == null) {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoa -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        PessoaComContatoDTO pessoaComContatoDTO = new PessoaComContatoDTO();
                        pessoaComContatoDTO.setPessoa(pessoaDTO);
                        pessoaComContatoDTO.setContatos(
                                pessoa.getContatos()
                                        .stream()
                                        .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                        .collect(Collectors.toList())
                        );
                        return pessoaComContatoDTO;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findById(id).stream()
                    .map(pessoa -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        PessoaComContatoDTO pessoaComContatoDTO = new PessoaComContatoDTO();
                        pessoaComContatoDTO.setPessoa(pessoaDTO);
                        pessoaComContatoDTO.setContatos(
                              pessoa.getContatos()
                                     .stream()
                                     .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                     .collect(Collectors.toList())
                    );
                        return pessoaComContatoDTO;
                })
                     .collect(Collectors.toList());
    }

    public List <PessoaComEnderecoDTO> listByPessoaComEndereco(Integer id) {
        if (id == null) {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoa -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        PessoaComEnderecoDTO pessoaComEnderecoDTO = new PessoaComEnderecoDTO();
                        pessoaComEnderecoDTO.setPessoa(pessoaDTO);
                        pessoaComEnderecoDTO.setEnderecos(
                                pessoa.getEnderecos()
                                        .stream()
                                        .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                        .collect(Collectors.toList())
                        );
                        return pessoaComEnderecoDTO;
                    })
                    .collect(Collectors.toList());
        }return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    PessoaComEnderecoDTO pessoaComEnderecoDTO = new PessoaComEnderecoDTO();
                    pessoaComEnderecoDTO.setPessoa(pessoaDTO);
                    pessoaComEnderecoDTO.setEnderecos(
                            pessoa.getEnderecos()
                                    .stream()
                                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                    .collect(Collectors.toList())
                    );
                    return pessoaComEnderecoDTO;
                })
                .collect(Collectors.toList());
    }
}
