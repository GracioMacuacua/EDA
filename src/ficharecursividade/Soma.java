package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class Soma {
    
    /**
     * Exercício:
     * Calcule a Soma de: 1 + ½ + 1/3 + ¼ + 1/5 + 1/n
     * 
     * @param num o divisor máximo.
     * @return o quociente dado pela expressão acima.
     */
    public static double soma(int num) {

        if(num > 0)
            return (1.0/num) + soma(num-1);
        
        return 0;
    }

}
