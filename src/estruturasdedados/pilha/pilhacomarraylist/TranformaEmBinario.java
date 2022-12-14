package src.estruturasdedados.pilha.pilhacomarraylist;

/**
 * @author Grácio Macuácua
 */
public class TranformaEmBinario {
    
    public static Pilha<Integer> p = new Pilha<>();
    
    public static String transformar(int numero) {
        if(numero == 1){
            p.push(1);   
            return p.toString();
        } else if(numero == 0) {
            p.push(0);
            return p.toString();
        }
        p.push(numero%2);
        numero /= 2;
        
        return transformar(numero);
    }

}