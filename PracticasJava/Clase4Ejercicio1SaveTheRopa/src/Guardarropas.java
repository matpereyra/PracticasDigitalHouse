import java.util.HashMap;
import java.util.List;

public class Guardarropas {

    HashMap<Integer, List<Prenda>> dic = new HashMap<>();
    Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        contador++;
        dic.put(contador, listaDePrendas);
        return contador;
    }

    public void mostrarPrendas() {
        dic.forEach( (k,v) -> {
            System.out.println("Guardarropas " + k.toString());
            System.out.println(v.toString());
        });
    }

    public List<Prenda> devolverPrendas(Integer numeroDePrenda) {
        return dic.get(numeroDePrenda);
    }

}
