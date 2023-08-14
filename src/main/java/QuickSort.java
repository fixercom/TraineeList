import java.util.Comparator;

public class QuickSort {

    public static <E> void sort(E[] array, int begin, int end, Comparator<E> comparator) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end, comparator);

            sort(array, begin, partitionIndex - 1, comparator);
            sort(array, partitionIndex + 1, end, comparator);
        }
    }

    private static <E> int partition(E[] array, int begin, int end, Comparator<E> comparator) {
        int middle = begin + (end - begin) / 2;
        E pivotPoint = array[middle];
        int i = begin - 1;

        for (int j = begin; j <= end; j++) {
            if (comparator.compare(array[j], pivotPoint) <= 0 && j != middle) {
                i++;
                if (i == middle) {
                    middle = j;
                }
                swap(array, i, j);
            }
        }
        swap(array, i + 1, middle);
        return i + 1;
    }

    private static <E> void swap(E[] arr, int firstIndex, int secondIndex) {
        E temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

}