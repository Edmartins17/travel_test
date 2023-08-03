package com.travelex.imc.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class IMCRequest  extends BasicRequestDto {
    @NotNull(message = "{imc.peso.notEmpty}")
    @DecimalMin(value = "0.1", inclusive = false, message = "{imc.peso.decimal-valid}")
    @Digits(integer=2, fraction=1, message = "{imc.peso.minimalValue}")
    private Double peso;

    @NotNull(message = "{imc.altura.notEmpty}")
    @DecimalMin(value = "0.1", inclusive = false, message = "{imc.altura.decimal-valid}")
    @Digits(integer=1, fraction=2, message = "{imc.altura.minimalValue}")
    private Double altura;
    public IMCRequest(){
        super();
        this.UUIDTracer = "IMC-REQUEST" + this.UUIDTracer;
    }


}
