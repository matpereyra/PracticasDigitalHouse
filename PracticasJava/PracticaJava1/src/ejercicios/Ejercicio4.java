package ejercicios;

import java.util.Scanner;

public class Ejercicio4 {


    private static boolean esPrimo(int n){
        if (n==1 || n==2) return true;
        int i;
        int limite = n/2+1;

        for (i=2; i<limite; i++)
        {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 0, j = 1;
        while (i<n){
            if(esPrimo(j)){
                System.out.println(j);
                i++;
            }
            j++;
        }

    }
}
