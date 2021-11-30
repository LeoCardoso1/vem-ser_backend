package com.dbc.veiculoprodutorconsumidor.dto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObjetoDTO {
    private LocalDateTime dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private Boolean sensorFrenagem;
}
