package src.estruturasdedados.pilha.pilhacomarraylist;

import java.util.ArrayList;

import src.estruturasdedados.pilha.Stack;

/**
 * @author Grácio Macuácua
 */
public class Pilha<T> implements Stack<T>{

    private int posPilha;
    private int tamanho;
    private ArrayList<T> elementos;

    public Pilha(){
        posPilha = -1;
        elementos = new ArrayList<>();
    }

    @Override
    public void push(T obj) {
        elementos.add(++posPilha, obj);
        tamanho = posPilha + 1;
    }

    @Override
    public T pop() {
        if(estaVazia())
            throw new IndexOutOfBoundsException("A pilha está vazia.");
        return elementos.get(posPilha--);
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return posPilha == -1;
    }

    @Override
    public T peek() {
        if(estaVazia())
            throw new IndexOutOfBoundsException("A pilha está vazia!");
        return elementos.get(posPilha);
    }
    
    public void adicionaPilha(Pilha<T> pilha) {
        for(int i = 0; i < pilha.tamanho(); i++)
            push(pilha.pop());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        if(!estaVazia()){
            string.append(elementos.get(posPilha));
            for(int i = posPilha-1; i >= 0; i--) {
                string.append(",");
                string.append(elementos.get(i));
            }
        }
        string.append("]");
            return string.toString();
    }
        
}