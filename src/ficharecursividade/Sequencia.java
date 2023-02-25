package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class Sequencia {

    /**
     * Exercício:
     * Gerador da Sequência dada por:
     * F(1) = 1
     * F(2) = 2
     * F (n) = 2*F(n-1) + 3*F(n-2)
     * 
     * @param num
     * @return
     */
    public static int sequencia(int num) {

        if (num == 1)
            return 1;

        if (num == 2)
            return 2;

        if (num > 2)
            return (2 * sequencia(num - 1) + 3 * sequencia(num - 2));

        return 0;
    }

}
