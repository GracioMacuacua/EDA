package src.pesquisa;

/**
 * @author Grácio Macuácua
 */
public class BuscaSequencialRecursiva {


    public static int sequencialRecursiva(int[] vetor, int chave, int pos) {

        if(chave == vetor[pos]) {
            return pos;
        } else if(pos < vetor.length-1) {
            return sequencialRecursiva(vetor, chave, pos + 1);
        }

        return -1;
    }

}