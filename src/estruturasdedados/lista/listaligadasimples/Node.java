package src.estruturasdedados.lista.listaligadasimples;

/**
 * @author Grácio Macuácua
 */
public class Node<T> {
    
    private Node<T> next;
    private T content;
    
     /**
     * Cria um novo nó com o respectivo conteúdo e a referência ao próximo nó da lista.
     * @param node o próximo nó da lista
     * @param value o conteúdo a ser armazenado.
     */
    public Node(T value, Node<T> node) {
        this.next = node;
        this.content = value;
    }

    public Node(T value) {
        this.content = value;
        this.next = null;
    }
    protected Node(){}

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T value) {
        this.content = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Node [content=").append(content).append("]");
        return builder.toString();
    }   
    
}
