package com.dbc.veiculoprodutorconsumidor.repository;

import com.dbc.veiculoprodutorconsumidor.entity.ObjetoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjetoRepository extends MongoRepository<ObjetoEntity, String> {
}
