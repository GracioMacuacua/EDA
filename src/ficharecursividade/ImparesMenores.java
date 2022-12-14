package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class ImparesMenores {
    
    public static String imparesMenores(int num) {

        if(num <= 0)
            return "";
        if((--num % 2) != 0)
            return num + " " + imparesMenores(num-1);
        else
            return imparesMenores(num-1);

    }

}
