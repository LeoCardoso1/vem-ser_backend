
package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query("select C " +
            "from CONTATO C " +
            "where C.tipoContato= :tipo")
    List<ContatoEntity> listarPorTipoDeContato(TipoContato tipo);



    @Query(value = "select C " +
            "from CONTATO C " +
            "join C.pessoaEntity p " +
            "where p.idPessoa =:id")
    List<ContatoEntity> listarContatosPorIdDaPessoa(Integer id);
}
