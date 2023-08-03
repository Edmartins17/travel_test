package com.travelex.imc;

import com.travelex.imc.controller.IMCRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ImcCalculatorApplicationTests {

	@Autowired
	private IMCRestController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
