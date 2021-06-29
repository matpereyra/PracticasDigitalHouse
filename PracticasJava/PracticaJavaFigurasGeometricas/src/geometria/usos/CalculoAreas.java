package geometria.usos;

import geometria.figuras.FiguraGeometrica;
import geometria.figuras.Medidas;
import geometria.figuras.*;

import java.util.HashMap;
import java.util.Scanner;

public class CalculoAreas {

    public static void main(String[] args) {


        //String nombreFigura = leerFiguraGeometrica();
        Scanner in = new Scanner(System.in);
        String nombreFigura = in.nextLine();
        System.out.println(nombreFigura);
        in.nextLine();
        FiguraGeometrica figura = clasificarFiguraGeometrica(nombreFigura); //CAMBIAR MODELO, POR EJ extends FiguraConNombre
        //FiguraGeometrica figura = new Circulo(1);
        System.out.println("El área del " + figura.nombre() +
                " es " + Double.toString(figura.area()));


    }

    private static String leerFiguraGeometrica() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private static FiguraGeometrica clasificarFiguraGeometrica(String nombreFigura) {
        HashMap<String, FiguraGeometrica> diccionarioFigurasGeometricas = new HashMap<>();
        diccionarioFigurasGeometricas.put("C", new Circulo(1));
        diccionarioFigurasGeometricas.put("c", diccionarioFigurasGeometricas.get("C"));
        diccionarioFigurasGeometricas.put("R", new Rectangulo(1,1));
        diccionarioFigurasGeometricas.put("r", diccionarioFigurasGeometricas.get("R"));
        diccionarioFigurasGeometricas.put("T", new Trapecio(1,1,45));
        diccionarioFigurasGeometricas.put("t", diccionarioFigurasGeometricas.get("T"));
        return diccionarioFigurasGeometricas.get(nombreFigura);
    }
}
