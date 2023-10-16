package advanced_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSortDescending {
    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {
        int listLength = list.size();
        if (listLength <= 1) {
            return;
        }
        int middleOfList = listLength / 2;

        List<T> leftPartArray = new ArrayList<>(list.subList(0, middleOfList));
        List<T> rightPartArray = new ArrayList<>(list.subList(middleOfList, listLength));

        mergeSort(leftPartArray, comparator);
        mergeSort(rightPartArray, comparator);

        merge(list, leftPartArray, rightPartArray, comparator);
    }

    private static <T extends Comparable<T>> void merge(final List<T> list, List<T> leftPartArray, List<T> rightPartArray, Comparator<T> comparator) {
        int leftListLength = leftPartArray.size();
        int rightListLength = rightPartArray.size();

        int leftPointer = 0;
        int rightPointer = 0;
        int mergedPointer = 0;

        while (leftPointer < leftListLength && rightPointer < rightListLength) {
            // Compare elements in descending order
            if (comparator.compare(leftPartArray.get(leftPointer), rightPartArray.get(rightPointer)) >= 0) {
                list.set(mergedPointer, leftPartArray.get(leftPointer));
                leftPointer++;
            } else {
                list.set(mergedPointer, rightPartArray.get(rightPointer));
                rightPointer++;
            }
            mergedPointer++;
        }

        while (leftPointer < leftListLength) {
            list.set(mergedPointer, leftPartArray.get(leftPointer));
            leftPointer++;
            mergedPointer++;
        }

        while (rightPointer < rightListLength) {
            list.set(mergedPointer, rightPartArray.get(rightPointer));
            rightPointer++;
            mergedPointer++;
        }
    }
}