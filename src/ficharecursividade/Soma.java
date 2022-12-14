package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class Soma {
    
    public static double soma(int num) {

        if(num > 0)
            return (1.0/num) + soma(num-1);
        
        return 0;
    }

}
