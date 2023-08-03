package com.travelex.imc.controller;

import com.travelex.imc.convert.ConverterImcRequestDtoTOMedidaVO;
import com.travelex.imc.convert.ConverterResultToIMCResponse;
import com.travelex.imc.dto.IMCRequest;
import com.travelex.imc.dto.IMCResponse;
import com.travelex.imc.dto.vo.MedidaVO;
import com.travelex.imc.service.IMCService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
@RequestMapping("/api/")
public class IMCRestController {
    @Autowired
    private IMCService service;
    @Autowired
    private ConverterImcRequestDtoTOMedidaVO converterImcRequestDtoTOMedidaVO;
    @Autowired
    private ConverterResultToIMCResponse converterResultToIMCResponse;
    @PostMapping(path="v1/imc", consumes = "application/json", produces = "application/json")
    public ResponseEntity<IMCResponse> calculanting(@Valid @RequestBody IMCRequest request){
        log.info("Init Method calculanting >> Request: {}", request );
        
        MedidaVO medida = converterImcRequestDtoTOMedidaVO.apply(request);
        Double calculating = service.calculating(medida.getPeso(), medida.getPeso());
        IMCResponse response = getResponse(calculating, request);
        
        log.info("Final Method calculanting >> Response: {}", response );

        return ResponseEntity.ok().body(response);
    }
    private IMCResponse getResponse(Double calculated, IMCRequest request) {
        return converterResultToIMCResponse.apply(calculated, request);
    }
}
