package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class Multiplicacao {
    
    /**
     * Exercício que realiza a multiplicação de dois números usando através de somas sucessivas.
     * 
     * @param num1 o primeiro número da expressão.
     * @param num2 o segundo número da expressão.
     * @return o produto dos dois números {@code num1} e {@code num2}.
     */
    public static int multiplicacao(int num1, int num2) {

        if(num2 > 0)
            return num1 + multiplicacao(num1, num2-1);

        return 0;
    }

}
