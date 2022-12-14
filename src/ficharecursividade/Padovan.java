package src.ficharecursividade;

public class Padovan {
    
    public static int padovan(int num) {

        if(num == 0 || num == 1 || num == 2)
            return 1;
        if(num > 2)
            return (padovan(num-2) + padovan(num-3));
        
        return 0;
    }

}
