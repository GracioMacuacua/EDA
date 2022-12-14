package src.estruturasdedados.pilha;

/**
 * @author Grácio Macuácua
 */
public interface Stack<T> {
    void push(T obj);
    T pop();
    int tamanho();
    boolean estaVazia();
    T peek();
    String toString();
}