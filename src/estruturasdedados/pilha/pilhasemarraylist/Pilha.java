package src.estruturasdedados.pilha.pilhasemarraylist;

import src.estruturasdedados.pilha.Stack;

/**
 * @author Grácio Macuácua
 */
public class Pilha<T> implements Stack<T> {
    
    private int posPilha;
    private T[] elementos;
 
    @SuppressWarnings("unchecked")
    public Pilha(int capacidade) {
        elementos = (T[]) new Comparable[capacidade];
        posPilha = -1;
    }

    @Override
    public void push(T obj) {
        if(!estaCheia())
            elementos[++posPilha] = obj;
        else{
            duplicarCapacidade();
            elementos[++posPilha] = obj;
            System.out.println("Capacidade duplicada: " + elementos.length);
        }
    }

    @SuppressWarnings("unchecked")
    private void duplicarCapacidade() {
       T[] array = (T[]) new Comparable[2*tamanho()];
       for(int i = 0; i < tamanho(); i++){
          array[i] = elementos[i];
       }
       elementos = array;       
    }

    @Override
    public T pop() {
        if(estaVazia())
            throw new  IndexOutOfBoundsException("A pilha está vazia!");
        return elementos[posPilha--];
    }

    @Override
    public int tamanho() {
        return posPilha+1;
    }

    @Override
    public boolean estaVazia() {
        return posPilha == -1;
    }

    @Override
    public T peek() {
        if(estaVazia())
           throw new IndexOutOfBoundsException("A pilha está vazia!");
        return elementos[posPilha];
    }
    
    public boolean estaCheia() {
        return posPilha == elementos.length-1;        
    }

    @SuppressWarnings("unchecked")
    public void adicionaPilha(Pilha<T> pilha) {
        int tamanho = pilha.tamanho();
        if(tamanho == 0)
            return;
        else if(tamanho() + pilha.tamanho() <= elementos.length) {
            for(int i = 0; i < tamanho; i++)
                push(pilha.pop());
        } else {
            T[] aux = (T[]) new Comparable[tamanho() + pilha.tamanho()];
            for(int i = 0; i < elementos.length; i++)
                aux[i] = elementos[i];
            elementos = aux;
            adicionaPilha(pilha);
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        if(!estaVazia()){
            string.append(elementos[posPilha]);
            for(int i = posPilha-1; i >= 0; i--) {
                string.append(",");
                string.append(elementos[i]);
            }
        }
        string.append("]");
            return string.toString();
    }

}
