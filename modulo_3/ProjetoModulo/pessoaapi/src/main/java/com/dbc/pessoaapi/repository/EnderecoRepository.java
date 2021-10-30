package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<EnderecoEntity> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    public List<EnderecoEntity> list() {
        return listaEnderecos;
    }

    public EnderecoEntity buscaEndreco(Integer id) throws Exception {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
    }

    public List<EnderecoEntity> listarEnderecosPessoa(Integer id) {
        List<EnderecoEntity> enderecosPessoa = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
        return enderecosPessoa;

    }

    public EnderecoEntity criarEnderecoPorIDPessoa(EnderecoEntity endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public EnderecoEntity editar(Integer id, EnderecoEntity endereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoAlterado = listaEnderecos.stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encotrado"));
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

    public void excluiEndereco(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        listaEnderecos.remove(enderecoRecuperado);
    }



}