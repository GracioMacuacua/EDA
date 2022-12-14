package src.estruturasdedados.lista.listaduplamenteligada;

public class DoubleNode<T> {
    
    private T content;
    private DoubleNode<T> next;
    private DoubleNode<T> previous; 
    
    public DoubleNode(DoubleNode<T> previous, DoubleNode<T> next, T content) {
        this.previous = previous;
        this.next = next;
        this.content = content;
    }

    public DoubleNode(T content) {
        previous = null;
        next = null;
        this.content = content;
    }

    public T getContent() {
        return content;
    }
    public void setContent(T content) {
        this.content = content;
    }
    public DoubleNode<T> getNext() {
        return next;
    }
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
    public DoubleNode<T> getPrevious() {
        return previous;
    }
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DoubleNode [content=").append(content).append("]");
        return builder.toString();
    }
     
}
