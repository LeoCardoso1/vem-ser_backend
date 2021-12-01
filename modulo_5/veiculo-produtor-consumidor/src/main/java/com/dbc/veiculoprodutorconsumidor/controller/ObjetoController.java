package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.dto.ObjetoDTO;
import com.dbc.veiculoprodutorconsumidor.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/objeto")
@RequiredArgsConstructor
public class ObjetoController {
    private final ConsumerService consumerService;

    @GetMapping
    public List<ObjetoDTO> list() {
        return consumerService.list();
    }
}
