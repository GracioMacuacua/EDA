package src.pesquisa;

/**
 * @author Grácio Macuácua
 */
public class BuscaBinariaRecursiva {

    public static int binariaRecursiva(int[] vetor, int chave, int topo, int baixo, int meio) {

        if(topo < baixo) {
            return -1;
        }

        if(vetor[meio] == chave) {
            return meio;
        } else if(chave > vetor[meio]) {
            return binariaRecursiva(vetor, chave, topo, meio + 1, (topo+meio+1)/2);
        } else if(chave < vetor[meio]) {
            return binariaRecursiva(vetor, chave, meio - 1, baixo, (baixo+meio-1)/2);
        }

        return -1;
    }

}