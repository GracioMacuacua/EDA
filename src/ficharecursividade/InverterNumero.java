package src.ficharecursividade;

public class InverterNumero {

    /**
     * Exercício que determina o inverso de um número inteiro qualquer.
     * @param numero o número a ser invertido.
     * @return o inverso do número dado.
     */
    public static String inverterNumero(int numero) {

        String numString = String.valueOf(numero);
        return inverter(numString, numString.length()-1);
    }

    private static String inverter(String numString, int pos) {

        if(numString.isBlank())
            return "";
        if(pos >= 0 && pos <= numString.length())
            return numString.charAt(pos) + inverter(numString, pos-1);
        
        return "";
    }

}
