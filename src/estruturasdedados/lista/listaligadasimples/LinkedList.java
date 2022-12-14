package src.estruturasdedados.lista.listaligadasimples;

/**
 * @author Grácio Macuácua
 */
public class LinkedList<T> {

    private Node<T> first;
    private int size;

    public LinkedList() {
        size = -1;
    }

    /**
     * Recupera o primeiro elemento da lista.
     * 
     * @return o primeiro elemento da lista
     */
    public Node<T> getFirst() {
        return first;
    }

    /**
     * Altera o primeiro elemento da lista.
     * 
     * @param first o novo primeiro elemento
     */
    public void setFirst(Node<T> first) {
        this.first = first;
    }

    /**
     * Recupera o número de elementos na lista.
     * 
     * @return o número de elementos da lista
     */
    public int getSize() {
        return size + 1;
    }

    /**
     * Altera a contagem de elementos, isto é, o tamanho da lista.
     * 
     * @param size o novo tamanho da lista
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica se a lista possui elementos.
     * 
     * @return {@code true} se a lista tiver elementos, {@code false} caso contrário
     */
    public boolean isEmpty() {
        return size == -1;
    }

    /**
     * Recupera a posição em que se encontra um determinado conteúdo na lista.
     * 
     * @param content o elemento a ser procurado na lista
     * @return a posição em que se encontra o conteúdo desejado caso exista,
     *         ou {@code -1} se o elemento não for encontrado
     * @throws IndexOutOfBoundsException Lança uma excepção se a lista estiver vazia
     */
    public int get(T content) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        int i = 0;
        Node<T> curent = first;
        while (true) {
            if (curent.getContent().equals(content))
                return i;
            else if (curent.getNext() != null) {
                curent = curent.getNext();
                i++;
            } else
                break;
        }

        return -1;
    }

    /**
     * Recupera o conteúdo do elemento que se encontra em uma determinada posição na
     * lista.
     * 
     * @param position a posição a ser buscada da lista
     * @return o conteúdo do elemento que se encontra na posição indicada,
     *         ou {@code null} se a posição não for existir
     * @throws IndexOutOfBoundsException Lança uma excepção se a posição indicada
     *                                   estiver fora dos parâmetros
     */
    public T get(int position) {
        if (size < position || position < 0)
            throw new IndexOutOfBoundsException("Posição inválida!");
        Node<T> curent = first;
        for (int i = 0; i < position; i++)
            curent = curent.getNext();

        return curent.getContent();

    }

    /**
     * Adiciona um elemento ao início da lista.
     * 
     * @param content o elemento a ser adicionado
     */
    public void addFirst(T content) {
        Node<T> newNode = new Node<T>(content, this.first);
        first = newNode;
        size++;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * 
     * @param content o elemento a ser adicionado
     */
    public void addLast(T content) {
        Node<T> newNode = new Node<T>(content);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> curent = first;
            while (curent.getNext() != null)
                curent = curent.getNext();
            curent.setNext(newNode);
        }
        size++;
    }

    /**
     * Adiciona na lista um elemento na posição indicada.
     * 
     * @param content  o elemento a ser adicionado na lista
     * @param position a posição de destino na lista
     * @throws IndexOutOfBoundsException Lança uma excepção se a posição indicada
     *                                   estiver fora dos parâmetros
     */
    public void add(T content, int position) {
        if (size < position || position < 0)
            throw new IndexOutOfBoundsException("Posição inválida!");
        if (position == 0) {
            addFirst(content);
            return;
        }
        if (position == size) {
            addLast(content);
            return;
        }
        Node<T> curent = first;
        for (int i = 0; i < position - 1; i++) {
            curent = curent.getNext();
        }
        curent.setNext(new Node<T>(content, curent.getNext()));
        size++;
    }

    /**
     * Remove o primeiro elemento da lista.
     * 
     * @throws IndexOutOfBoundsException Lança uma excepção se a lista estiver vazia
     */
    public void removeFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        first = first.getNext();
        size--;
    }

    /**
     * Remove o último elemento da lista.
     * 
     * @throws IndexOutOfBoundsException Lança uma excepção se a lista estiver vazia
     */
    public void removeLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        Node<T> curent = first;
        for (int i = 0; i < size - 1; i++)
            curent = curent.getNext();
        curent.setNext(curent.getNext().getNext());
        size--;
    }

    /**
     * Remove da lista o elemento na posição indicada.
     * 
     * @param position a posição do elemento a ser removido
     * @throws IndexOutOfBoundsException Lança uma excepção se a lista estiver vazia
     */
    public void remove(int position) {
        if (size < position || position < 0)
            throw new IndexOutOfBoundsException("Posição inválida!");
        if (position == 0) {
            removeFirst();
            return;
        }
        if (position == size) {
            removeLast();
            return;
        }
        Node<T> node = first;
        for (int i = 0; i <= position - 2; i++)
            node = node.getNext();
        node.setNext(node.getNext().getNext());
        size--;
    }

    /**
     * Gera uma string com todo o conteúdo da da lista
     * 
     * @return uma string com o conteúdo da lista
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (!isEmpty()) {
            Node<T> curent = first;
            builder.append(curent.getContent());
            for (int i = 1; i <= size; i++) {
                builder.append(", ");
                curent = curent.getNext();
                builder.append(curent.getContent());
            }
        }
        builder.append("]");

        return builder.toString();
    }
}
