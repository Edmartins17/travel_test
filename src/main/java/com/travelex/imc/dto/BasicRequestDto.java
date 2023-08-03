package com.travelex.imc.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BasicRequestDto{
    protected String UUIDTracer;
    protected Date requested;

    public BasicRequestDto(){
        this.UUIDTracer =  UUID.randomUUID().toString();
        this.requested = new Date();
    }
}


