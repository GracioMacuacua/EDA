package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class Sequencia {
    
    public static int sequencia(int num) {

        if(num == 1)
            return 1;

        if(num == 2)
            return 2;

        if(num > 2)
            return (2*sequencia(num-1) + 3*sequencia(num-2));

        return 0;
    }

}
