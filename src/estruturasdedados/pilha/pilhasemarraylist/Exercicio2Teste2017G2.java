package src.estruturasdedados.pilha.pilhasemarraylist;

public class Exercicio2Teste2017G2 {

    public static double mediaPilha(Pilha<Integer> pilha, int numVezes, double somatorio) {
        
        if(!pilha.estaVazia()) {
            somatorio += pilha.pop();
            return mediaPilha(pilha, numVezes+1, somatorio);
        }
        if(numVezes > 0)
            return somatorio/numVezes;
        
        return 0;
    }

}
