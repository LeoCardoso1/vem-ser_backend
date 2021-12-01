package com.dbc.veiculoprodutorconsumidor.repository;

import com.dbc.veiculoprodutorconsumidor.entity.ObjetoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ObjetoRepository extends MongoRepository<ObjetoEntity, String> {

    @Query(value = "{status: ?0}", count = true)
    long count(boolean status);

}
