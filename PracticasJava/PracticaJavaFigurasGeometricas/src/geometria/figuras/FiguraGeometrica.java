package geometria.figuras;

public class FiguraGeometrica implements Nombrable, Medidas{

    String nombre;
    @Override
    public String nombre(){
        return this.nombre;
    }

    @Override
    public double area() {
        return 0;
    }
    @Override
    public double perimetro() {
        return 0;
    }
}
