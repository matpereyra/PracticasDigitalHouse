package geometria.figuras;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circulo extends FiguraGeometrica{

    private double radio;

    public Circulo(double radio) {
        this.nombre = "círculo";
        this.radio = radio;
    }

    @Override
    public double area() {
        return PI*pow(2, radio);
    }

    @Override
    public double perimetro() {
        return 2*PI*radio;
    }
}
