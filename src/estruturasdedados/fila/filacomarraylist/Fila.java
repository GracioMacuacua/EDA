package src.estruturasdedados.fila.filacomarraylist;

import java.util.ArrayList;

public class Fila<T> implements Queue<T> {
    
    private ArrayList<T> dados;
    private int quantidade;
    private int inicio;
    private int fim;

    public Fila() {
        dados = new ArrayList<>();
        inicio = -1;
        fim = -1;
        quantidade = 0;
    }

    /**
     * Faz a inserção de elementos na fila
     * @param value elemento a ser adicionado na fila
     */
    @Override
    public void enqueue(T value) {        
        if(isEmpty()){
            inicio++;
            fim++;
            dados.add(value);
            quantidade++;
        }else {
            fim++;
            dados.add(value);
            quantidade++;
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
            retorno = dados.get(inicio);
            quantidade--;
            if (inicio == fim) {
                inicio = -1;
                fim = -1;
            }else {
                inicio++;
            }
        }
        return retorno;   
    }

    /**
     * Devolve o elemento no iício da fila
     * @return o emelento no início da fila
     * @throws ArrayIndexOutOfBoundsException Lança uma excepção se a fila estiver vazia
     */
    @Override
    public T front() {
        if(isEmpty())
        throw new ArrayIndexOutOfBoundsException("A fila está vazia!");  

        return dados.get(inicio);
    }

     /**
     * Avalia se a fila está vazia
     * @return true se a fila estiver vazia, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return inicio == -1;
    }

    @Override
    public int size() {
        return quantidade;
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
            string.append(dados.get(inicio));
            for(int i = inicio+1; i <= fim; i++) {
                string.append(",");
                string.append(dados.get(i));                
            }            
        }
        string.append("]");
            return string.toString();    
    }

    /**
     * Adiciona uma fila ao final da fila
     * @param fila a fila a ser adicionada
     */
    public void adicionaFila(Fila<T> fila) { 
        int fim = fila.size();                                        
        for(int i = fila.inicio; i < fim; i++) {
            enqueue(fila.dequeue());
        }                   
    }

}
