package com.travelex.imc.service;

import com.travelex.imc.dto.IMCRequest;
import com.travelex.imc.dto.IMCResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface IMCService {

    public  Double calculating(Double peso, Double altura);
}
