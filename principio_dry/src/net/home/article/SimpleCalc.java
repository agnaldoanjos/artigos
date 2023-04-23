package net.home.article;

// Exemplo direto sem uso do dry
public class SimpleCalc {
    public static int somar(int a, int b) {
        return a + b;
    }
    public static int subtrair(int a, int b) {
        return a - b;
    }
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return a / b;
    }
    public static void main(String[] args) {
        int resultado = somar(2, 3);
        System.out.println(resultado);
    }
}
