package geometria.figuras;


import static java.lang.Math.*;

public class Trapecio extends FiguraGeometrica {

    private double base1;
    private double base2;
    private double altura;

    public Trapecio(double base1, double base2, double altura) {
        this.nombre = "trapecio";
        if (base1==base2) {
            /*Devolver un cuadrado?*/
            this.base1 = base1;
            this.base2 = base2;
            this.altura = altura;
        }
        else if (base1<base2) {
            this.base1 = base2;
            this.base2 = base1;
        }
        else {
            this.base1 = base1;
            this.base2 = base2;
            this.altura = altura;
        }


    }

    /*Como defino un constructor con misma firma pero que espera distinto argumento?*/
    /*public Trapecio(double base1, double base2, double anguloEnGrados) {
        this.base1 = base1;
        this.base2 = base2;
        this.altura = (base2-base1)/2*tan(anguloEnGrados/180*PI);
    }
     */

    @Override
    public double area() {
        return (base1+base2)*altura/2;
    }

    @Override
    public double perimetro() {
        return base1+base2+2*pow(pow((base1-base2)/2,2)+pow(altura,2),0.5);
    }
}
