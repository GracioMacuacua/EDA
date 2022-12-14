package src.ficharecursividade;

public class InverterNumero {
    
    public static String inverterNumero(String numString, int pos) {
        
        if(numString.isBlank())
            return "";
        if(pos >= 0 && pos <= numString.length())
            return numString.charAt(pos) + inverterNumero(numString, pos-1);
        
        return "";
    }

}
