package com.travelex.imc.convert;

import com.travelex.imc.dto.IMCRequest;
import com.travelex.imc.dto.vo.MedidaVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
public class ConverterImcRequestDtoTOMedidaVO implements Function<IMCRequest, MedidaVO> {

    public MedidaVO apply(IMCRequest imcRequest) {
        log.info("Init Method apply >> payload: {}", imcRequest.toString());
        MedidaVO medida = MedidaVO
                .builder()
                .peso(imcRequest.getPeso())
                .altura(imcRequest.getAltura())
                .build();
        log.info("Final Method apply >> result: {}", medida.toString());
        return medida;
    }
}
