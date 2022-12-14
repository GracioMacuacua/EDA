package src.ordenacao;

/**
 * @author Grácio Macuácua
 */
public class InsertionSort {
    
    public static void insertionSort(int[] vetor) {

        for(int i = 1; i < vetor.length; i++) {
            for(int j = i; j > 0; j--) {
                if(vetor[j] < vetor[j-1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j-1];
                    vetor[j-1] = aux;
                } else {
                    break;
                }
            }            
        }
    }

}
