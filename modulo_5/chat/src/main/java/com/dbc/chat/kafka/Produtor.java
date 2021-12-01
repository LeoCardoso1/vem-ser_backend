package com.dbc.chat.kafka;

import com.dbc.chat.dto.MensagemCreateDTO;
import com.dbc.chat.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class Produtor {
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic.geral-chat}")
    private String chatGeral;


    public void send(MensagemDTO mensagemDTO, String topico) throws JsonProcessingException{
        String payload = objectMapper.writeValueAsString(mensagemDTO);
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();
    }

    public void sendTo(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException{
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        mensagemDTO.setUsuario("Leonardo");
        send(mensagemDTO, chatGeral);
    }

    public void sendToGeral(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException{
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        mensagemDTO.setUsuario("Leonardo");
        send(mensagemDTO)
    }
}
