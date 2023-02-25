package src.pesquisa;

/**
 * @author Grácio Macuácua
 */
public class BuscaSequencialSimples {
    
    /**
     * Método para realizar a busca sequencial no vetor.
     * @param vetor o vetor alvo da busca.
     * @param chave o valor que se procura no vetor.
     * @return a posição do elemento que se procura caso ele exista no vetor.
     */
    public static int sequencialSimples(int[] vetor, int chave) {

        for(int i = 0; i < vetor.length; i ++) {
            if(chave == vetor[i])
                return i;
        }

        return -1;
    }

}
