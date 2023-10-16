package simple_sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {40, 3, 20, 1, 5, 6, 7, 8};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        mergesort(a, 0, 7);
        mergesort(b, 0, 7);
        for (int i = 0; i < 8; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(b[i] + " ");
        }
    }

    public static void mergesort(int[] arr, int lowIdx, int highIdx) {
        if (lowIdx < highIdx) {
            int midIdx = (lowIdx + highIdx) / 2;
            mergesort(arr, lowIdx, midIdx);
            mergesort(arr, midIdx + 1, highIdx);
            if (arr[midIdx] > arr[midIdx + 1]) { //this is the improvement so that mergesort in best case can be O(n)
                merge(arr, lowIdx, midIdx, highIdx);
            }
        }
    }

    public static void merge(int[] arr, int lowIdx, int midIdx, int highIdx) {
        int i = lowIdx, j = midIdx + 1, k = 0;
        int[] temp = new int[highIdx - lowIdx + 1];
        while (i <= midIdx && j <= highIdx) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= midIdx) {
            temp[k++] = arr[i++];
        }

        while (j <= highIdx) {
            temp[k++] = arr[j++];
        }

        for (i = lowIdx, k = 0; i <= highIdx; i++, k++) {
            arr[i] = temp[k];
        }
    }
}
