package src.estruturasdedados.fila.filasemarraylist;

import src.estruturasdedados.fila.filacomarraylist.Queue;

/**
 * @author Grácio Macuácua
 */
public class Fila<T> implements Queue<T> {
    private T[] array;
    private int quantidade;
    private int inicio;
    private int fim;

    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        array = (T[]) new Comparable[capacidade];
        quantidade = 0;
        inicio = -1;
        fim = -1;
    }

    /**
     * Faz a inserção de elementos na fila
     * @param value elemento a ser adicionado na fila
     * @throws ArrayIndexOutOfBoundsException Lança uma excepção se a fila estiver cheia
     */
    @Override
    public void enqueue(T value) {        
        if (isEmpty()) {
            inicio++;
            fim++;
            array[inicio] = value;
            quantidade++;
        }else {
            if (!isFull()) {
                fim++;
                array[fim] = value;
                quantidade++;
            }else
                throw new ArrayIndexOutOfBoundsException("A fila está cheia!");
        }
    }

    /**
     * Retorna e remove o elemento no início da fila
     * @throws ArrayIndexOutOfBoundsException Lança uma excepção se a fila estiver vazia
     * @return o elemento no início da fila
     */
    @Override
    public T dequeue() { 
        T retorno = null;
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException("A fila está vazia!");
        else{
            retorno = array[inicio];
            quantidade--;
            if (inicio == fim) {
                inicio = -1;
                fim = -1;
            }else {
                inicio++;
                reorganizar();
            }
        }
        return retorno;        
    }

    /**
     * Devolve o elemento no início da fila
     * @return o elemento no início da fila
     * @throws ArrayIndexOutOfBoundsException Lança uma excepção se a fila estiver vazia
     */
    @Override
    public T front() { 
        if(isEmpty())
            throw new ArrayIndexOutOfBoundsException("A fila está vazia!");  

        return array[inicio];
    }

    /**
     * Avalia se a fila está vazia
     * @return true se a fila estiver vazia, false caso contrário
     */
    @Override
    public boolean isEmpty() {        
        return inicio == -1;
    }

    /**
     * Avalia se a fila está cheia
     * @return true se a fila estiver cheia, false caso contrário
     */
    public boolean isFull() {
        return fim == array.length-1;
    }

    /**
     * Devolve a quantidade de elementos da na fila
     * @return 0 se a fila estiver vazia, caso contrário, o número de elementos na fila
     */
    @Override
    public int size() {        
        return quantidade;
    }
    
    private void reorganizar() {
        for (int i = inicio; i <= fim; i++) {
            array[i-1] = array[i];
        }       
        inicio--;
        fim--;
    }

    /**
     * Faz a representação da fila na forma de string
     * @return a representação textual da fila
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        if(!isEmpty()) {            
            string.append(array[inicio]);
            for(int i = inicio+1; i <= fim; i++) {
                string.append(",");
                string.append(array[i]);                
            }            
        }
        string.append("]");
            return string.toString();    
    }

    /**
     * Adiciona uma fila no final da fila que chama o método
     * @param fila a fila a ser adicionada
     */
    @SuppressWarnings("unchecked")
    public void adicionaFila(Fila<T> fila) {  
        if(fila.size() == 0)                               
            System.out.print("");
        else if(size() + fila.size() <= array.length) {
            for(int i = fila.inicio; i < fim; i++) {
                enqueue(fila.dequeue());
            }                        
        }else {
            T[] aux = (T[]) new Comparable[size()+fila.size()];
            int inicioAux = inicio;
            int qtdAux = 0;
            int fimAux1 = size();
            int fimAux2 = fila.size();        
            for(int i = inicio; i < fimAux1; i++) {
                aux[i] = dequeue();  
                qtdAux++;              
            }            
            for(int j = fila.inicio; j < fimAux2; j++) {
                aux[fimAux1] = fila.dequeue();
                fimAux1++;
                qtdAux++; 
            }
            inicio = inicioAux;
            fim = qtdAux-1;
            quantidade = qtdAux;
            array = aux;
        }        
    }
}