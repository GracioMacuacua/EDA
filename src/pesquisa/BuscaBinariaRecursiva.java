package src.pesquisa;

/**
 * @author Grácio Macuácua
 */
public class BuscaBinariaRecursiva {

    /**
     * Método que realiza a busca binária usando o conceito de recursivadade.
     * @param vetor o vetor alvo da busca.
     * @param chave o valor que se procura no vetor.
     * @return  a posição do elemento que se procura caso ele exista na estrutura.
     */
    public static int binariaRecursiva(int[] vetor, int chave) {

        return pesquisar(vetor, chave, vetor.length-1, 0, (vetor.length-1)/2);
    }

    /**
     * Método que realiza as buscas recursivas no vetor.
     * 
     * @param vetor o vetor alvo da busca
     * @param chave o valor que se procura no vetor.
     * @param topo representa o limite superior da busca em cada iteração.
     * @param baixo representa o limite inferior da busca em cada iteração.
     * @param meio representa a posição central em cada iteração.
     * @return a posição do elemento que se procura caso ele exista no vetor.
     */
    private static int pesquisar(int[] vetor, int chave, int topo, int baixo, int meio) {
        
        if(topo < baixo) {
            return -1;
        }

        if(vetor[meio] == chave) {
            return meio;
        } else if(chave > vetor[meio]) {
            return pesquisar(vetor, chave, topo, meio + 1, (topo+meio+1)/2);
        } else if(chave < vetor[meio]) {
            return pesquisar(vetor, chave, meio - 1, baixo, (baixo+meio-1)/2);
        }

        return -1;
    }

}