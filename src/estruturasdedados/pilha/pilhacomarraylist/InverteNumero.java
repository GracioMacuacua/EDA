package src.estruturasdedados.pilha.pilhacomarraylist;

/**
 * @author Grácio Macuácua
 */
public class InverteNumero {
    
    static Pilha<Character> p = new Pilha<>();

    public static void inverterNumero(String numString) {
        
        for(int i = 0; i < numString.length(); i++)
            p.push(numString.charAt(i));
    }

}
