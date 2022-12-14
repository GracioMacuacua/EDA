package src.pesquisa;

/**
 * @author Grácio Macuácua
 */
public class BuscaBinariaSimples {
    
    public static int binariaSimples(int[] vetor, int chave) {
        
        int topo = vetor.length-1;
        int baixo = 0;
        int meio = (topo + baixo)/2;

        do {
            if(topo < baixo)
                return -1;

            if(chave == vetor[meio]) {
                return meio;
            } else if(chave > vetor[meio]) {
                baixo = meio + 1;
                meio = (topo + baixo)/2;
            } else if(chave < vetor[meio]) {
                topo = meio - 1;
                meio = (topo + baixo)/2;
            }

        } while (true);

    }

}
