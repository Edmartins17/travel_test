package com.travelex.imc.convert;

import com.travelex.imc.dto.IMCRequest;
import com.travelex.imc.dto.IMCResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
@Slf4j
public class ConverterResultToIMCResponse implements BiFunction< Double, IMCRequest, IMCResponse> {
    @Override
    public IMCResponse apply(Double result, IMCRequest imcRequest) {
        log.info("Init Method apply >> result:{} request:{}", result, imcRequest);
        IMCResponse response = IMCResponse.builder()
                .result(result).build();
        response.setUUIDTracer(imcRequest.getUUIDTracer());
        log.info("Final Method apply >> Response:{} ", response);

        return response;
    }
}
