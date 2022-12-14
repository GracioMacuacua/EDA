package src.estruturasdedados.lista.listaduplamenteligada;

public interface DLinkedList<T> {
    
    public int get(T content);
    public T get(int position);
    public void addFirst(T content);
    public void addLast(T content);
    public void add(T content, int position);
    public void removeFirst();
    public void removeLast();
    public void remove(int position);
    public String toString();
    public T getNFromLast(int position);

}
