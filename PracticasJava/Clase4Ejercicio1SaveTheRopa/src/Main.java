import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Guardarropas guardarropas = new Guardarropas();
        List<Prenda> lista = new ArrayList<Prenda>();

        lista.add(new Prenda("Nike", "Urban"));
        Collections.addAll(lista,
                new Prenda("Converse", "Classic"),
                new Prenda("Reebok", "o son Nike"));
        // Muestro las prendas guardadas; guardo el identificador de la lista de prendas.
        Integer identificador = guardarropas.guardarPrendas(lista);

        // Veo las prendas que fueron guardadas.
        guardarropas.mostrarPrendas();

        // Veo las prendas del identificador.
        List<Prenda> prendasDevueltas = new ArrayList<Prenda>();
        prendasDevueltas = guardarropas.devolverPrendas(identificador);
        System.out.println(prendasDevueltas);

    }




}
