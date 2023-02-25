package src.ficharecursividade;

/**
 * @author Grácio Macuácua
 */
public class SomaVetor {
    
    /**
     * Exercício:
     * Faça uma função recursiva que permita somar os elementos de um vetor de inteiros
     * 
     * @param vetor o vetor a ser somado.
     * @param pos contador para controle das iterações.
     * @param somatorio variável que armazena as somas em cada iteração.
     * @return a soma de todos os valores do vetor.
     */
    public static int somaVetor(int[] vetor, int pos, int somatorio) {

        if(pos < vetor.length){
            somatorio+=vetor[pos];
            return somaVetor(vetor, pos+1, somatorio);
        }

        return somatorio;

    }

}
