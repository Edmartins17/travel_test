package com.travelex.imc.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class IMCServiceImplTest {

    private IMCService service;

    @BeforeEach
    void setUp()
    {
        this.service = new IMCServiceImpl();
    }

    @Test
    public void calculating() {
        Double calculating = service.calculating(83d, 1.79d);
        assertEquals(25.90431010268094, calculating);
    }
}