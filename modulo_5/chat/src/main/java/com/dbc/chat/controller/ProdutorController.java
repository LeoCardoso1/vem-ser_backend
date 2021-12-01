package com.dbc.chat.controller;

import com.dbc.chat.dto.MensagemCreateDTO;
import com.dbc.chat.kafka.Produtor;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor

public class ProdutorController {
    private final Produtor produtor;

    @ApiOperation(value = "Enviar mensagem para geral")
    @PostMapping("/send-to-geral")
    public void sendToChatGeral(@RequestBody MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        produtor.sendToGeral(mensagemCreateDTO);
    }

    @ApiOperation(value = "Enviar mensagem para tópico privado")
    @PostMapping("/send-to")
    public void sendTo(@RequestBody MensagemCreateDTO mensagemCreateDTO, @RequestParam String chatPrivado) throws JsonProcessingException {
        produtor.sendTo(mensagemCreateDTO, chatPrivado);
    }
}
