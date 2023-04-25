package com.example.demo.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CalculadoraTest {

    private Calculadora calc = new Calculadora();
    @Test
    public void testSomar() {
        assertEquals(5, calc.somar(2, 3));
        assertEquals(-5, calc.somar(-2, -3));
        assertEquals(0, calc.somar(0, 0));
    }

    @Test
    public void testSubtrair() {
        assertEquals(-1, calc.subtrair(2, 3));
        assertEquals(1, calc.subtrair(-2, -3));
        assertEquals(0, calc.subtrair(0, 0));
    }

    @Test
    public void testMultiplicar() {
        assertEquals(6, calc.multiplicar(2, 3));
        assertEquals(6, calc.multiplicar(-2, -3));
        assertEquals(0, calc.multiplicar(0, 0));
    }

    @Test
    public void testDividir() {
        assertEquals(2, calc.dividir(6, 3));
        assertEquals(-2, calc.dividir(6, -3));
        assertEquals(0, calc.dividir(0, 1));

        ArithmeticException aThrows = assertThrows(ArithmeticException.class, () -> {
            calc.dividir(6, 0);
        });

        assertEquals("Não é possível dividir por zero.", aThrows.getMessage());

    }
}