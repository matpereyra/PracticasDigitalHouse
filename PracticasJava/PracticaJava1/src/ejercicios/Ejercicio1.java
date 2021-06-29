package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

    /*
    Desarrollar un programa para mostrar los primeros n números pares, siendo n un valor que el
    usuario ingresará por consola.
    Recordá que un número es par cuando es divisible por 2.
     */

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int z = 0;
        for (int i = 2; z < n; i+=2)
        {
            z++;
            System.out.println(i);
        }
    }
}
