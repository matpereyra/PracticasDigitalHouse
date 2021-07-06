package geometria.figuras;

public abstract class FiguraGeometrica implements Nombrable{

    String nombre;
    public abstract double area();
    public abstract double perimetro();

    @Override
    public String nombre(){
        return this.nombre;
    }


}
