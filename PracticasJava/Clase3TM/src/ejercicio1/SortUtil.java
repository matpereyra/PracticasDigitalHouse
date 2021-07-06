package ejercicio1;
import java.util.Collections;
import java.util.List;

public class SortUtil{

    public static <T> void ordenar(List<IPrecedable<T>> arr) {
        int size = arr.size();
        for (int i = 0; i<size; i++) { //posicion
            int n = i;
            for (int j = i+1; j <size; j++, n++) {
                if (arr.get(j).precedeA( (T) arr.get(n) ) ) {
                    Collections.swap(arr, n, j);
                }
            }
        }
    }


}
