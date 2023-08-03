package com.travelex.imc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper=false)
public class IMCResponse extends BasicResponseDto{
    private Double result;
}
