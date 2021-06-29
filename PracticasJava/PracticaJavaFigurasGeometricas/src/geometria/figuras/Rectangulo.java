package geometria.figuras;

public class Rectangulo extends FiguraGeometrica{
    /*
    extends Trapecio ???
     */
    private double lado1;
    private double lado2;

    public Rectangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.nombre = "rectángulo";
    }

    @Override
    public double area() {
        return lado1*lado2;
    }

    @Override
    public double perimetro() {
        return 2*(lado1+lado2);
    }
}
