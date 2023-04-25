package com.example.demo.logic;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExemploTest {

    private Exemplo ex = new Exemplo();

    // Teste para o método ehPar()
    @Test
    public void testEhPar() {
        assertTrue(ex.ehPar(2));
        assertFalse(ex.ehPar(3));
        assertTrue(ex.ehPar(0));
    }

    // Teste para o método media()
    @Test
    public void testMedia() {
        double[] numeros = {2.0, 2.0, 3.0, 4.0, 5.0};
        assertEquals(ex.media(numeros), 3.2, 0.001);
    }

    // Teste para o método ehPalindromo()
    @Test
    public void testEhPalindromo() {
        assertTrue(ex.ehPalindromo("ovo"));
        assertFalse(ex.ehPalindromo("banana"));
        assertTrue(ex.ehPalindromo("ame a ema"));
    }

}