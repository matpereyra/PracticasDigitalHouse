package ejercicios;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        /*Primeros n numeros que tengan m digitos d*/
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //cantidad de corte
        int m = in.nextInt(); //cantidad de digitos d
        int d = in.nextInt(); //digito d

        String d_str = Integer.toString(d);

        int i = 0;
        int count = 0;
        while(count<n){
            if(countMatches(Integer.toString(i), d_str)>=m) {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }

    private static int countMatches(String n_str, String d_str) {
        int count = 0;
        for (String c: n_str.split("")) {
            if( c.equals(d_str) ){
                count++;
            }
        }
        return count;
    }
}
