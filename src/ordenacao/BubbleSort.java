package src.ordenacao;

/**
 * @author Grácio Macuácua
 */
public class BubbleSort {
    
    /**
     * Método que realiza a ordenação de vetores usando o conceito de ordenação em bolha.
     * @param vetor o vetor a ser ordenado.
     */
    @SuppressWarnings("unchecked")
    public static void bubleSort(Object[] vetor) {

        Comparable<Object>[] vetorAux = (Comparable<Object>[]) vetor;

        for(int i = 0; i < vetor.length; i++) {
            for(int j = 0; j < vetor.length-1; j++) {
                if(vetorAux[j].compareTo(vetorAux[j+1]) > 0) {
                    Comparable<Object> aux = vetorAux[j+1];
                    vetor[j+1] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }

        //Após alguns testes concluí que esta atribuição é opcional, 
        //pode ser feita assim como não. A estrutura auxiliar (dataAux) aponta 
        //para o mesmo endereço de memória que a estrutura original (data).
        vetor = (Object[]) vetorAux;
    }

}