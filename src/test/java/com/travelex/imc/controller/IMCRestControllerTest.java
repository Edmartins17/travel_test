package com.travelex.imc.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.travelex.imc.convert.ConverterImcRequestDtoTOMedidaVO;
import com.travelex.imc.convert.ConverterResultToIMCResponse;
import com.travelex.imc.dto.IMCRequest;
import com.travelex.imc.dto.IMCResponse;
import com.travelex.imc.fixture.IMCRequestTemplateLoader;
import com.travelex.imc.service.IMCService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IMCRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    public static final String BASE_PACKAGE = "com.travelex.imc.fixture";
    public static final String URL = "/api/v1/imc";
    public static final String CONTENT_TYPE = "application/json";

    private IMCRequest request;

    @BeforeEach
    public void setup(){
        FixtureFactoryLoader.loadTemplates(BASE_PACKAGE);
    }

    @Test
    void shouldReturnResult() throws Exception {
        request = Fixture.from(IMCRequest.class).gimme(IMCRequestTemplateLoader.IMC_REQUEST_VALID);

        String expectedJson = new ObjectMapper()
                .writeValueAsString(request);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post(URL).content(expectedJson).contentType(CONTENT_TYPE))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        BigDecimal result = JsonPath.read(response.getResponse().getContentAsString(), "$.result");
        Assert.assertNotNull(result);
    }

    @Test
    void shouldReturnError() throws Exception {
        request = Fixture.from(IMCRequest.class).gimme(IMCRequestTemplateLoader.IMC_REQUEST_INVALID);

        String expectedJson = new ObjectMapper()
                .writeValueAsString(request);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post(URL).content(expectedJson).contentType(CONTENT_TYPE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        Assert.assertNotNull(response.getResponse().getContentAsString().indexOf("error"));
    }

}
