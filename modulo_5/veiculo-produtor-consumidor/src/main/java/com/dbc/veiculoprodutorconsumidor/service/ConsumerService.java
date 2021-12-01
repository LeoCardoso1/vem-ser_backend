package com.dbc.veiculoprodutorconsumidor.service;
import com.dbc.veiculoprodutorconsumidor.dto.ObjetoDTO;
import com.dbc.veiculoprodutorconsumidor.entity.ObjetoEntity;
import com.dbc.veiculoprodutorconsumidor.repository.ObjetoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;
    private final ObjetoRepository objetoRepository;

    @KafkaListener(
            topics = "${kafka.topic.dto}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryLatest"
    )
    public void consumeDTO(@Payload String mensagem,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        ObjetoDTO objetoDTO = objectMapper.readValue(mensagem, ObjetoDTO.class);
        ObjetoEntity objetoEntity = objectMapper.convertValue(objetoDTO, ObjetoEntity.class);
        objetoRepository.save(objetoEntity);
        log.info("MENSAGEM LIDA: '{}', CHAVE: '{}', OFFSET: '{}'", mensagem, key, offset);
    }

    public List<ObjetoDTO> list() {
        return objetoRepository.findAll()
                .stream()
                .map(objeto-> objectMapper.convertValue(objeto, ObjetoDTO.class))
                .collect(Collectors.toList());
    }


}
