package com.travelex.imc.dto;

import com.travelex.imc.dto.enums.ErrorCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private Integer code;
    private String description;
    private String message;
    private ErrorCategory typeError;
    private String customCode;
}
