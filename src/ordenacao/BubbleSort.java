package src.ordenacao;

/**
 * @author Grácio Macuácua
 */
public class BubbleSort {
    
    public static void bubleSort(int[] vetor) {

        for(int i = 0; i < vetor.length; i++) {
            for(int j = 0; j < vetor.length-1; j++) {
                if(vetor[j] > vetor[j+1]) {
                    int aux = vetor[j+1];
                    vetor[j+1] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
    }

}