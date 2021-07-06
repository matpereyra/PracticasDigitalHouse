package ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Julia", 200);
        Persona persona2 = new Persona("Jesus", 0);
        Persona persona3 = new Persona("Mirtha", -4);
        Persona persona4 = new Persona("Juana", 5);
        List<IPrecedable<Persona>> arr = new ArrayList<>();
        arr.add(persona1);
        arr.add(persona2);
        arr.add(persona3);
        arr.add(persona4);

        SortUtil.ordenar(arr);

        for (IPrecedable p: arr) {
            System.out.println( p.toString());
        }


    }
}
