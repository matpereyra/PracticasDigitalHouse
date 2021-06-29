package ejercicios;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); //numero
        int n = in.nextInt(); //cantidad de multiplos
        for (int i = 0,j=0; j < n; j++)
        {
            i += m;
            System.out.println(i);
        }
    }
}
