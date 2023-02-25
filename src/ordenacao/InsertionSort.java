package src.ordenacao;

/**
 * @author Grácio Macuácua
 */
public class InsertionSort {
    
    /**
     * Método que realiza a ordenação de vetores usando o conceito de ordenação por inserção.
     * @param vetor o vetor a ser ordenado.
     */
    @SuppressWarnings("unchecked")
    public static void insertionSort(Object[] vetor) {

        Comparable<Object>[] dataAux = (Comparable<Object>[]) vetor;

        for(int i = 1; i < dataAux.length; i++) {
            for(int j = i; j > 0; j--) {
                if(dataAux[j].compareTo(dataAux[j-1]) < 0) {
                    Comparable<Object> aux = dataAux[j];
                    dataAux[j] = dataAux[j-1];
                    dataAux[j-1] = aux;
                } else {
                    break;
                }
            }            
        }

        //Após alguns testes concluí que esta atribuição é opcional, 
        //pode ser feita assim como não. A estrutura auxiliar (dataAux) aponta 
        //para o mesmo endereço de memória que a estrutura original (data).
        vetor = (Object[]) dataAux;
    }

}
