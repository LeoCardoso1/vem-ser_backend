package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    public List<Endereco> list() {
        return listaEnderecos;
    }

    public Endereco buscaEndreco(Integer id) throws Exception {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
    }

    public List<Endereco> listarEnderecosPessoa(Integer id) {
        List<Endereco> enderecosPessoa = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
        return enderecosPessoa;

    }

    public Endereco criarEnderecoPorIDPessoa(Integer id, Endereco endereco) {
        endereco.setIdPessoa(id);
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public Endereco editar(Integer id, Endereco endereco) throws Exception {
        Endereco enderecoAlterado = listaEnderecos.stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encotrado"));
        enderecoAlterado.setIdPessoa(endereco.getIdPessoa());
        enderecoAlterado.setTipo(endereco.getTipo());
        enderecoAlterado.setLogradouro(endereco.getLogradouro());
        enderecoAlterado.setNumero(endereco.getNumero());
        enderecoAlterado.setComplemento(endereco.getComplemento());
        enderecoAlterado.setCep(endereco.getCep());
        enderecoAlterado.setCidade(endereco.getCidade());
        enderecoAlterado.setEstado(endereco.getEstado());
        enderecoAlterado.setPais(endereco.getPais());
        return enderecoAlterado;
    }

    public void excluiEndereco(Integer id) throws Exception {
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
        listaEnderecos.remove(enderecoRecuperado);
    }



}