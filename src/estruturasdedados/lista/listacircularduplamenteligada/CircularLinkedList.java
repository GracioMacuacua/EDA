package src.estruturasdedados.lista.listacircularduplamenteligada;

import src.estruturasdedados.lista.listaduplamenteligada.DoubleNode;
import src.estruturasdedados.lista.listaduplamenteligada.DoublyLinkedList;

public class CircularLinkedList<T> extends DoublyLinkedList<T> {

    public CircularLinkedList() {
        super();
    }

    @Override
    public int get(T content) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        int i = 0;
        DoubleNode<T> curent = first;
        while(i <= size) {
            if (curent.getContent().equals(content))
                return i;            
            curent = curent.getNext();
            i++;
        }

        return -1;
    }

    @Override
    public T get(int position) {
        if (size < position || position < 0)
            throw new IndexOutOfBoundsException("Posição inválida!");
        DoubleNode<T> curent = first;
        for(int i = 0; i < position; i++)
            curent = curent.getNext();

        return curent.getContent();
    }

    @Override
    public void addFirst(T content) {
        DoubleNode<T> newNode = new DoubleNode<>(null, first, content);
        if (isEmpty()) {
            first = newNode; 
            last = newNode;
            last.setPrevious(first);
            first.setPrevious(last);
            first.setNext(last);
        } else {            
            last.setNext(newNode);          
            newNode.setPrevious(last);
            first.setPrevious(newNode);
            first = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T content) {
        DoubleNode<T> newNode = new DoubleNode<>(last, first, content);
        if (isEmpty()) {
            addFirst(content);
            return;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        first = first.getNext();
        first.setPrevious(last);
        last.setNext(first);
        size--;
    }

    @Override
    public void removeLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        last.getPrevious().setNext(first);
        last = last.getPrevious();
        first.setPrevious(last);
        size--;
    }

    @Override
    public void remove(int position) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        if (position == 0) {
            removeFirst();
            return;
        }
        if (position == size) {
            removeLast();
            return;
        }
        if (position > 0 && position < size) {
            DoubleNode<T> node = first;
            for (int i = 0; i < position - 1; i++)
                node = node.getNext();
            node.setPrevious(node.getPrevious());
            node.setNext(node.getNext().getNext());
            size--;
        } else {
            throw new IndexOutOfBoundsException("Posição inválida!");
        }
    }
    
}
