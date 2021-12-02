package com.dbc.pessoaapi.kafka;

import com.dbc.pessoaapi.dto.EmailDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class Produtor {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "envio-email")
    private String topico;

    private void send(String mensagem, String topico) {
        Message<String> message = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> send = stringKafkaTemplate.send(message);
    }

    public void sendToSendBox (EmailDTO emailDTO) throws JsonProcessingException {
        String playload = objectMapper.writeValueAsString(emailDTO);
        send(playload, topico);
    }
}
