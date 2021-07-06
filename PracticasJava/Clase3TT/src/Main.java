import models.MiFactory;
import models.QuickSortSorterImple;
import models.Sorter;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        QuickSortSorterImple<Integer> integerSorter = new QuickSortSorterImple<>();
        List<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, 8, 6, 0, 7,-9, 9, 2, 3, 1, 4, 5);
        integerSorter.sort(arr, Integer::compareTo);
        System.out.println(arr);

        QuickSortSorterImple<String> stringSorter = new QuickSortSorterImple<>();
        List<String> arrString = new ArrayList<String>();
        Collections.addAll(arrString, "Zorro", "Arnes", "Dragon");
        stringSorter.sort(arrString, String::compareTo);
        System.out.println(arrString);

        //QuickSortSorterImple<Integer> integerSorter2 = new QuickSortSorterImple<>();
        System.out.println(MiFactory.getInstance("MiFactory.properties").getClass());

        Sorter<Integer> integerSorter2 = MiFactory.getInstance("MiFactory.properties");

        List<Integer> arr2 = new ArrayList<>();
        Collections.addAll(arr2, 8, 6,-17, 0, 7,-9, 9, 2, 3, 1, 4, 5);
        integerSorter2.sort(arr2, Integer::compareTo);
        System.out.println(arr2);

    }

}
