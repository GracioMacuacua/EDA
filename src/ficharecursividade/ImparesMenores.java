package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class ImparesMenores {
    
    /**
     * Exercício que retorna os números primos menores que o número informado por parâmetro.
     * @param num número base sobre o qual serão determinados os números primos menores que ele.
     * @return uma string com todos os números primos menores que o número informado.
     */
    public static String imparesMenores(int num) {

        if(num <= 0)
            return "";
        if((--num % 2) != 0)
            return num + " " + imparesMenores(num-1);
        else
            return imparesMenores(num-1);

    }

}
