public class QuickSort {

    public static void sort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int middle = begin + (end - begin) / 2;
        int pivotPoint = array[middle];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivotPoint) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, middle);
        return i + 1;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

}