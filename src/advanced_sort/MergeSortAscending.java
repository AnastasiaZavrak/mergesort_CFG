package advanced_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// I couldn't add the improvement here, as it wouldn't work, however, mergeSort will still do pretty good on sorting
public class MergeSortAscending {
    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {
        int listLength = list.size();
        if (listLength <= 1) {
            return;
        }
        int middleOfList = listLength / 2;
        // if e.g. length = 9, then middle of the array would be 4, and (array length - middle) = 5
        List<T> leftPartArray = new ArrayList<>(list.subList(0, listLength - middleOfList));
        List<T> rightPartArray = new ArrayList<>(list.subList(listLength - middleOfList, listLength));

        //recursive calls to merge left and right parts of the array
        mergeSort(leftPartArray, comparator);
        mergeSort(rightPartArray, comparator);

        //merge left and right parts of the array
        merge(list, leftPartArray, rightPartArray, comparator);
    }

    private static <T extends Comparable<T>> void merge(final List<T> list, List<T> leftPartArray, List<T> rightPartArray, Comparator<T> comparator) {
        int leftListLength = leftPartArray.size();
        int rightListLength = rightPartArray.size();

        // we need 3 pointers: 1 for left part, 1 for right part, and 1 for the merged array
        int leftPointer = 0;
        int rightPointer = 0;
        int mergedPointer = 0;

        while (leftPointer < leftListLength && rightPointer < rightListLength) {
            //comparing elements of the both parts so that the smallest one goes to the merged array
            if (leftPartArray.get(leftPointer).compareTo(rightPartArray.get(rightPointer)) <= 0) {
                list.set(mergedPointer, leftPartArray.get(leftPointer));
                leftPointer++;
            } else {
                list.set(mergedPointer, rightPartArray.get(rightPointer));
                rightPointer++;
            }
            mergedPointer++;
        }

        //add any leftover elements from either or the arrays
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
