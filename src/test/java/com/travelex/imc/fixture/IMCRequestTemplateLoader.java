package com.travelex.imc.fixture;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.travelex.imc.dto.IMCRequest;

public class IMCRequestTemplateLoader implements TemplateLoader {

    public static String IMC_REQUEST_INVALID = "IMC_REQUEST_INVALID";
    public static String IMC_REQUEST_VALID = "IMC_REQUEST_VALID";

    @Override
    public void load() {
        Fixture.of(IMCRequest.class).addTemplate(IMC_REQUEST_VALID, new Rule(){{
            add("peso", 83d);
            add("altura", 1.79d);
        }});

        Fixture.of(IMCRequest.class).addTemplate(IMC_REQUEST_INVALID, new Rule(){{
            add("peso", null);
            add("altura", null);
        }});

    }
}