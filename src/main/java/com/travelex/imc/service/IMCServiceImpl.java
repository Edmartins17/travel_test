package com.travelex.imc.service;

import com.travelex.imc.dto.IMCRequest;
import com.travelex.imc.dto.IMCResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Slf4j
public class IMCServiceImpl implements IMCService{
    @Override
    public  Double calculating(Double peso, Double altura) {
        log.info( "Init Method calculating >> from Peso: {} e Altura {}", peso, altura );
        var calculate = peso / Math.pow(altura, 2);
        log.info( "Final Method calculating >> Result: {}", calculate);
        return calculate;
    }

}
