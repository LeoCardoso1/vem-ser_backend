package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Slf4j
@Validated
@RestController
@RequestMapping("/query")
public class QueryController {

    private final EnderecoRepository enderecoRepository;
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;

    @GetMapping("/enderecos-por-pais")
    public List<EnderecoEntity> listarEnderecosPorPais(@RequestParam String pais) {
        return enderecoRepository.enderecoPais(pais);
    }

    @GetMapping("/endereco-por_pessoa")
    public List<EnderecoEntity> listarEnderecosPorPessoa(@RequestParam Integer idPessoa) {
        return enderecoRepository.enderecoPorPessoa(idPessoa);
    }

    @GetMapping("/listar-contatos-por-tipo")
    public List<ContatoEntity> listarContatosPorTipo(@RequestParam TipoContato tipo) {
        return contatoRepository.listarPorTipoDeContato(tipo);
    }

    @GetMapping("/listar-pessoas-por-intervalo")
    public List<PessoaEntity> listarPessoasPorIntervalo(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return pessoaRepository.pessoasPorIntervaloDeTempo(start, end);
    }

    @GetMapping("/pessoas-que-possuem-endereco")
    public List<PessoaEntity> listarPessoasComEndereco(){
        return pessoaRepository.pessoasComEnderecos();
    }

    @GetMapping("/enderecos-por-cidade-ou-pais")
    public List<EnderecoEntity> listarEnderecosPorCidadeOuPais(@RequestParam String cidade, @RequestParam String pais) {
        return enderecoRepository.enderecosPorCidadeOuPais(cidade.toUpperCase(), pais.toUpperCase());
    }

    @GetMapping("/enderecos-sem-complemento")
    public List<EnderecoEntity> listarEnderecosSemComplemento() {
        return enderecoRepository.enderecosSemComplemento();
    }

    @GetMapping("/listar-contatos-pela-pessoa")
    public List<ContatoEntity> listarContatosPorPessoa(@RequestParam Integer id){
        return contatoRepository.listarContatosPorIdDaPessoa(id);
    }

    @GetMapping("/pessoas-que-nao-possuem-endereco")
    public List<PessoaEntity> listarPessoasSemEndereco() {
        return pessoaRepository.pessoasSemEndereco();
    }


}
