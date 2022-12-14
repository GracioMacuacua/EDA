package src.ordenacao;

/**
 * @author Grácio Macuácua
 */
public class QuickSort {

    /**
     * @param vetor o (sub)vetor a ser ordenado
     * @param inicio posição onde inicia a ordenação
     * @param fim posição onde termina a ordenação
     */
    public static void quickSort(int[] vetor, int inicio, int fim) {
        
        if(inicio < fim) {            
            int pivot = particionar(vetor, inicio, fim);            
            //Ordena os elementos do vetor que estão abaixo da posição pivot
            quickSort(vetor, inicio, pivot - 1);
            //Ordena os elementos do vetor que estão acima da posição pivot
            quickSort(vetor, pivot + 1, fim);
        }

    }

    /**
     * 
     * @param vetor o (sub)vetor a ser ordenado
     * @param i posição para a qual o elemento em vetor[j] deve passar
     * @param j posição para a qual o elemento em vetor[i] deve passar
     */
    private static int particionar(int[] vetor, int inicio, int fim) {

        int pivot = vetor[inicio];
        int j = inicio;

        for(int i = inicio + 1; i <= fim; i++) {
            if(vetor[i] <= pivot) {
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
    private static void trocar(int[] vetor, int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

}
