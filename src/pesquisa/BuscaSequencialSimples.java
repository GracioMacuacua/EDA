package src.pesquisa;

/**
 * @author Grácio Macuácua
 */
public class BuscaSequencialSimples {
    
    public static int sequencialSimples(int[] vetor, int chave) {

        for(int i = 0; i < vetor.length; i ++) {
            if(chave == vetor[i])
                return i;
        }

        return -1;
    }

}
