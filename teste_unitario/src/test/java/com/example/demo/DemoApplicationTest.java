package com.example.demo;

import com.example.demo.logic.Calculadora;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class DemoApplicationTest {

    private static Calculadora calculadora;
    private static DemoApplication application;

    @BeforeAll
    public static void before() {
        calculadora = Mockito.mock(Calculadora.class);

        application = new DemoApplication(calculadora);
    }

    @Test
    void somar() {
        Mockito.when(calculadora.somar(1,3)).thenReturn(4);

        assertEquals(4, application.somar(1, 3));

        Mockito.verify(calculadora, Mockito.times(1)).somar(1,3);
    }
}