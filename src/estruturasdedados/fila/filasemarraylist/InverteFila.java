package src.estruturasdedados.fila.filasemarraylist;

import src.estruturasdedados.pilha.pilhacomarraylist.Pilha;

public class InverteFila<T> {
    
    public void inverterFila(Fila<T> fila) {
        int end = fila.size();
        Pilha<T> pilha = new Pilha<>();
        for(int i = 0; i < end; i++)
            pilha.push(fila.dequeue());
        
        for(int i = 0; i < end; i++)
            fila.enqueue(pilha.pop());        
    }
}
