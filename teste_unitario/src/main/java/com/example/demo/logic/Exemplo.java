package com.example.demo.logic;

public class Exemplo {
    // Método que soma dois números inteiros e retorna o resultado
    public int somar(int a, int b) {
        return a + b;
    }

    // Método que verifica se um número é par e retorna true se for, caso contrário retorna false
    public boolean ehPar(int num) {
        return num % 2 == 0;
    }

    // Método que retorna a média de um array de números double
    public double media(double[] numeros) {
        double soma = 0.0;
        for (double num : numeros) {
            soma += num;
        }
        return soma / numeros.length;
    }

    // Método que verifica se uma string é um palíndromo (ou seja, se pode ser lida da mesma forma tanto da esquerda para a direita quanto da direita para a esquerda)
    public boolean ehPalindromo(String palavra) {
        String palavraInvertida = new StringBuilder(palavra).reverse().toString();
        return palavra.equals(palavraInvertida);
    }

}
