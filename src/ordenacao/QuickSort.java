package src.ordenacao;

/**
 * @author Grácio Macuácua
 */
@SuppressWarnings("unchecked")
public class QuickSort {

    /**
     * @param vetor o (sub)vetor a ser ordenado
     * @param inicio posição onde inicia a ordenação
     * @param fim posição onde termina a ordenação
     */
    public static void quickSort(Object[] vetor, int inicio, int fim) {
        
        Comparable<Object>[] vetorAux = (Comparable<Object>[]) vetor;
        if(inicio < fim) {            
            int pivot = particionar(vetorAux, inicio, fim);            
            //Ordena os elementos do vetor que estão à esquerda da posição pivot
            quickSort(vetorAux, inicio, pivot - 1);
            //Ordena os elementos do vetor que estão à direita da posição pivot
            quickSort(vetorAux, pivot + 1, fim);
        }

    }

    /**
     * 
     * @param vetor o (sub)vetor a ser ordenado
     * @param i posição para a qual o elemento em vetor[j] deve passar
     * @param j posição para a qual o elemento em vetor[i] deve passar
     */
    private static int particionar(Comparable<Object>[] vetor, int inicio, int fim) {

        Comparable<Object> pivot = vetor[inicio];
        int j = inicio;

        for(int i = inicio + 1; i <= fim; i++) {
            if(vetor[i].compareTo(pivot) <= 0) {
                trocar(vetor, i, ++j);
            }
        }
        //Faz a troca do elemento pivot com o elemento na posição actual do j
        trocar(vetor, inicio, j);

        return j;
    }

    /**
     * 
     * @param vetor o (sub)vetor a ser ordenado
     * @param i posição para a qual o elemento em vetor[j] deve passar
     * @param j posição para a qual o elemento em vetor[i] deve passar
     */
    private static void trocar(Comparable<Object>[] vetor, int i, int j) {
        Comparable<Object> aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

}
