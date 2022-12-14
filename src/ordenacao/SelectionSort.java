package src.ordenacao;

/**
 * @author Grácio Macuácua
 */
public class SelectionSort {
    
    public static void selectionSort(int[] vetor) {

        for(int i = 0; i < vetor.length-1; i++) {
            for(int j = i+1; j < vetor.length; j++) {
                if(vetor[i] > vetor[j]){
                    int aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                }
            }
        }
    }

}
