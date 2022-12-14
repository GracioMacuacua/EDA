package src.estruturasdedados.lista.listaduplamenteligada;

public class DoublyLinkedList<T> implements DLinkedList<T> {

    protected DoubleNode<T> first;
    protected DoubleNode<T> last;
    protected int size;

    public DoublyLinkedList() {
        first = new DoubleNode<T>(null, null, null);
        last = new DoubleNode<T>(first, null, null);
        first.setNext(last);
        size = -1;
    }

    /**
     * Recupera o primeiro elemento da lista.
     * 
     * @return o primeiro elemento da lista
     */
    public DoubleNode<T> getFirst() {
        return first;
    }

    /**
     * Altera o primeiro elemento da lista.
     * 
     * @param first o novo primeiro elemento
     */
    public void setFirst(DoubleNode<T> first) {
        this.first = first;
    }

    /**
     * Recupera o último elemento da lista.
     * 
     * @return o último elemento da lista
     */
    public DoubleNode<T> getLast() {
        return last;
    }

    /**
     * Altera o último elemento da lista.
     * 
     * @param first o novo último elemento
     */
    public void setLast(DoubleNode<T> last) {
        this.last = last;
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
    @Override
    public int get(T content) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        int i = 0;
        DoubleNode<T> curent = first;
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
    @Override
    public T get(int position) {
        if (size < position || position < 0)
            throw new IndexOutOfBoundsException("Posição inválida!");
        DoubleNode<T> curent = first;
        for (int i = 0; i < position; i++)
            curent = curent.getNext();

        return curent.getContent();

    }

    /**
     * Adiciona um elemento ao início da lista.
     * 
     * @param content o elemento a ser adicionado
     */
    @Override
    public void addFirst(T content) {
        DoubleNode<T> node = new DoubleNode<>(null, first, content);
        if (isEmpty()) {
            first = node;
            last = node;
            last.setPrevious(first);
        } else {
            first.setPrevious(node);
            first = node;
        }
        size++;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * 
     * @param content o elemento a ser adicionado
     */
    @Override
    public void addLast(T content) {
        DoubleNode<T> newNode = new DoubleNode<>(last, null, content);
        if (isEmpty()) {
            addFirst(content);
            return;
        } else {
            last.setNext(newNode);
            last = newNode;
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
    @Override
    public void add(T content, int position) {
        if (size < position || position < 0)
            throw new IndexOutOfBoundsException("Posição inválida!");
        if (position == 0) {
            addFirst(content);
            return;
        } else if (position == size) {
            addLast(content);
            return;
        }
        DoubleNode<T> curent = first;
        for (int i = 0; i < position - 1; i++) {
            curent = curent.getNext();
        }
        DoubleNode<T> newNode = new DoubleNode<T>(curent, curent.getNext(), content);
        curent.setNext(newNode);
        newNode.getNext().setPrevious(newNode);
        size++;
    }

    /**
     * Remove o primeiro elemento da lista.
     * 
     * @throws IndexOutOfBoundsException Lança uma excepção se a lista estiver vazia
     */
    @Override
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
    @Override
    public void removeLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        DoubleNode<T> node = new DoubleNode<T>(last.getPrevious(), null, last.getPrevious().getContent());
        last.setPrevious(node);
        last = node;
        size--;
    }

    /**
     * Remove da lista o elemento na posição indicada.
     * 
     * @param position a posição do elemento a ser removido
     * @throws IndexOutOfBoundsException Lança uma excepção se a lista estiver vazia
     */
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
            DoubleNode<T> curent = first;
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

    /**
     * Recupera o elemento numa determinada posição partindo do final da lista.
     * 
     * @return o elemento na posição indicada, ou null caso a posição não exista
     * @throws IndexOutOfBoundsException Lança uma excepção se a posição indicada
     *                                   estiver fora dos parâmetros
     */
    @Override
    public T getNFromLast(int position) {

        if (position > size || position < 0)
            throw new IndexOutOfBoundsException("Posição inválida!");

        DoubleNode<T> tempNode = last;

        for (int i = size; i >= position; i--) {
            if (i == position)
                return tempNode.getContent();
            tempNode = tempNode.getPrevious();
        }
        return null;
    }

}
