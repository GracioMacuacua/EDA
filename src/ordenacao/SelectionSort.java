package src.ordenacao;

/**
 * @author Grácio Macuácua
 */
public class SelectionSort {
    
    /**
     * Método que realiza a ordenação de um vetor usando o conceito de ordenação por selecão.
     * @param vetor
     */
    @SuppressWarnings("unchecked")
    public static void selectionSort(Object[] vetor) {

        Comparable<Object>[] vetorAux = (Comparable<Object>[]) vetor;

        for(int i = 0; i < vetor.length-1; i++) {
            for(int j = i+1; j < vetor.length; j++) {
                if(vetorAux[i].compareTo(vetorAux[j]) > 0){
                    Comparable<Object> aux = vetorAux[j];
                    vetorAux[j] = vetorAux[i];
                    vetorAux[i] = aux;
                }
            }
        }
    }

}
