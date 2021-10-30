
package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<ContatoEntity> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository(){
        listaContatos.add(new ContatoEntity(COUNTER.incrementAndGet(), 1, TipoContato.RESIDENCIAL,"34341256", "Residencial"));

    }

    public ContatoEntity create (Integer idPessoa, ContatoEntity contato){
        contato.setIdPessoa(idPessoa);
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public void delete(Integer id) throws RegraDeNegocioException{
        ContatoEntity contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() ->new RegraDeNegocioException("Contato não encontrado"));
        listaContatos.remove(contatoRecuperado);
    }

    public List<ContatoEntity> list() {return listaContatos;}

    public List<ContatoEntity> listByContact(Integer id){
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());

    }

    public ContatoEntity editar(Integer id, ContatoEntity contato) throws RegraDeNegocioException{
        ContatoEntity contatoAlterado = listaContatos.stream()
                .filter(c -> c.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException("Contato não encontrado"));
        contatoAlterado.setTipoContato(contato.getTipoContato());
        contatoAlterado.setNumero(contato.getNumero());
        contatoAlterado.setDescricao(contato.getDescricao());
        return contatoAlterado;
    }
}
