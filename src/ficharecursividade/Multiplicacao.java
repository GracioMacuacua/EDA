package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class Multiplicacao {
    
    public static int multiplicacao(int num1, int num2) {

        if(num2 > 0)
            return num1 + multiplicacao(num1, num2-1);

        return 0;
    }

}
