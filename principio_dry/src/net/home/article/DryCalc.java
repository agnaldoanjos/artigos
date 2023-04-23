package net.home.article;

// Exemplo aplicando o princípio dry
public class DryCalc {
    public static int operations(final int a, final int b, final int tipoOperacao) {
        int resultado;
        switch (tipoOperacao) {
            case 1:
                resultado = a + b;
                break;
            case 2:
                resultado = a - b;
                break;
            case 3:
                resultado = a * b;
                break;
            case 4:
                if (b == 0) {
                    throw new IllegalArgumentException("Não é possível dividir por zero.");
                }
                resultado = a / b;
                break;
            default:
                throw  new UnsupportedOperationException("Tipo de operação não implementada");
        }
        return resultado;
    }

    public static void main(String[] args) {
        int resultado = operations(2, 3, 1);
        System.out.println(resultado);
    }

}
