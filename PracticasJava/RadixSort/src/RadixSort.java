import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.max;

public class RadixSort {

    public static void main(String[] args) {

        // Forma de inicializar un ArrayList con valores.
        // Se recomiendo tambien usar List<Tipo> var = new arrayList<Tipo>();
        //Ver https://es.stackoverflow.com/questions/171467/list-o-arraylist-en-java/171472
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(4, 28, 132, 3, 61, 5));
        for (int x : arr) {
            System.out.println(x);
        }
        arr = radixSort(arr);
    }

    private static List<Integer> radixSort(List<Integer> arr_ints) {
        List<String> arr = new ArrayList<String>(ints2strings(arr_ints));
        arr = makeLengthEqualTo(arr, Integer.toString(max(arr_ints)).length() );
        List<List<String>> containers = initListOfLists(arr); //Posicionar segun ultimo digito
        containers = classifyAll(containers);
        arr = concatenate(containers);
        return strings2ints(arr);
        /*
        int index = 0;
        String[] arr = new String[arr_.length];
        for (int x : arr_) {
            arr[index] = Integer.toString(x);
            index += 1;
        }
        for (String x : arr) {
            System.out.print(x + " ");
        }
        //arr_.clone();
        return arr_;
        */

    }

    private static List<String> makeLengthEqualTo(List<String> arr, int maximum) {
        int index = 0;
        for (int x: arr ) {
            arr.set(index, NZeros(maximum - arr.get(index).length()) + arr.get(index));
            index++;
        }
    }

    private static String NZeros() {

    }

    private static List<String> ints2strings(List<Integer> arr_ints) {
        List<String> arr = new ArrayList<String>();
        for (int x: arr_ints ) {
            arr.add(Integer.toString(x));
        }
        return arr;
    }

}
