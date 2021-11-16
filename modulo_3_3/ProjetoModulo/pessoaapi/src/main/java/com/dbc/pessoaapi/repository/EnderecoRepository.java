package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("select e " +
            "from ENDERECO_PESSOA e " +
            "where e.pais =:pais ")
    List<EnderecoEntity> enderecoPais(String pais);


    @Query("select e "+
        "from ENDERECO_PESSOA e " +
        "join e.pessoas p " +
        "where p.idPessoa = :idPessoa ")
    List<EnderecoEntity> enderecoPorPessoa(Integer idPessoa);


    @Query(value = "SELECT * " +
            "FROM ENDERECO_PESSOA E " +
            "WHERE UPPER(E.PAIS) LIKE UPPER(:pais) OR UPPER(E.CIDADE) LIKE UPPER(:cidade)", nativeQuery = true)
    List<EnderecoEntity> enderecosPorCidadeOuPais(String cidade, String pais);


    @Query(value = "SELECT * " +
                    "FROM ENDERECO_PESSOA E " +
                    "WHERE E.complemento is null", nativeQuery = true)
    List<EnderecoEntity> enderecosSemComplemento();

    @Query("select e " +
            "from ENDERECO_PESSOA e " +
            "where e.pais =:pais ")
    Page<EnderecoEntity> findByPais(String pais, Pageable pageable);
}
