package src.pesquisa;

/**
 * @author Grácio Macuácua
 */
public class BuscaSequencialRecursiva {

    /**
     * Método que realiza a busca sequencial usando o conceito de recursividade.
     * @param vetor o vetor alvo da busca.
     * @param chave o valor que se deseja procurar no vetor.
     * @return a posição do elemento que se procura caso ele exista no vetor.
     */
    public static int sequencialRecursiva(int[] vetor, int chave) {

        return pesquisar(vetor, chave, 0);
    }

    /**
     * Método que realiza as buscas recursivas no vetor.
     * @param vetor o vetor alvo da busca.
     * @param chave o valor que se procura no vetor.
     * @param pos contador para indicar o número da iteração.
     * @return a posição do elemento que se procura caso ele exista no vetor.
     */
    private static int pesquisar(int[] vetor, int chave, int pos) {

        if(chave == vetor[pos]) {
            return pos;
        } else if(pos < vetor.length-1) {
            return pesquisar(vetor, chave, pos + 1);
        }

        return -1;
    }

}