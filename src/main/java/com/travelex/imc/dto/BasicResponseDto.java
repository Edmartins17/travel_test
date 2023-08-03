package com.travelex.imc.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasicResponseDto implements Serializable {
    protected String UUIDTracer;
    protected Date created =  new Date();
    protected ErrorDto error;
}
