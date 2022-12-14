package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class SomaVetor {
    
    public static int somaVetor(int[] vetor, int pos, int somatorio) {

        if(pos < vetor.length){
            somatorio+=vetor[pos];
            return somaVetor(vetor, pos+1, somatorio);
        }

        return somatorio;

    }

}
