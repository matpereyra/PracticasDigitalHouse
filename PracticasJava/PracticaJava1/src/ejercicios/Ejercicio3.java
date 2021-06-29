package ejercicios;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int limite = n/2+1;
        int i;
        for (i=2; i<limite; i++)
        {
            if(n%i == 0) {
                System.out.println("No es primo");
                break;
            }
            else {
                continue;
            }
        }

        if (i==limite) {
            System.out.println("Es primo");
        }
    }
}
