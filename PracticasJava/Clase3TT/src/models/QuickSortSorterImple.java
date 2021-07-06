package models;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(List<T> arr, Comparator<T> c) {
        quickSort_(arr, 0, arr.size() - 1, c);
    }

    private void quickSort_(List<T> arr, int low, int high, Comparator<T> c) {
        if (low < high) {
            int pi = partition(arr, low, high, c);
            quickSort_(arr, low, pi - 1, c);  // Before pi
            quickSort_(arr, pi + 1, high, c); // After pi
        }
    }

    private int partition(List<T> arr, int low, int high, Comparator<T> c) {
        // pivot (Element to be placed at right position)
        T pivot = arr.get(high);

        int i = (low - 1);  // Index of smaller element and indicates the
        // right position of pivot found so far

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if ( c.compare(arr.get(j),pivot) < 0 ) {
                i++;    // increment index of smaller element
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr,i + 1, high);
        return i + 1;
    }
}
