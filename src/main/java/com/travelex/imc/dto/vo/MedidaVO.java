package com.travelex.imc.dto.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class MedidaVO implements Serializable {
    private Double peso;
    private Double altura;
}
