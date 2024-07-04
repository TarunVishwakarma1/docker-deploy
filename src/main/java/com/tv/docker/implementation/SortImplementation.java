package com.tv.docker.implementation;

import com.tv.docker.interfacepak.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author tarunvishwakarma81@gmail.com
 * Implementation class that implements the Sort interface.
 */
@Component
public class SortImplementation implements Sort {

    /**
     * @author tarunvishwakarma81@gmail.com
     * Sorts a list of integers in ascending order using the merge sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    @Override
    public List<Integer> mergeSort(List<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList;
        }

        int mid = inputList.size() / 2;
        List<Integer> leftList = mergeSort(new ArrayList<>(inputList.subList(0, mid)));
        List<Integer> rightList = mergeSort(new ArrayList<>(inputList.subList(mid, inputList.size())));
        List<Integer> mergedList = new ArrayList<>();

        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            if (leftList.get(0) <= rightList.get(0)) {
                mergedList.add(leftList.remove(0));
            } else {
                mergedList.add(rightList.remove(0));
            }
        }

        while (!leftList.isEmpty()) {
            mergedList.add(leftList.remove(0));
        }

        while (!rightList.isEmpty()) {
            mergedList.add(rightList.remove(0));
        }

        return mergedList;
    }

    /**
     * Implements the radix sort algorithm to sort a list of integers in ascending order.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    @Override
    public List<Integer> radixSort(List<Integer> inputList) {
        // Find the maximum number to know number of digits
        int maxNumber = findMax(inputList);

        // Perform counting sort for every digit
        for (int exp = 1; maxNumber / exp > 0; exp *= 10)
            countSort(inputList, exp);

        return inputList;
    }

    /**
     * Finds the maximum element in a list of integers.
     *
     * @param inputList the list of integers
     * @return the maximum element in the list
     */
    private int findMax(List<Integer> inputList) {
        int max = inputList.get(0);
        for (int i = 1; i < inputList.size(); i++)
            if (inputList.get(i) > max)
                max = inputList.get(i);
        return max;
    }

    /**
     * Sorts a list of integers using the count sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @param exp the current digit position
     */
    private void countSort(List<Integer> inputList, int exp) {
        int n = inputList.size();
        List<Integer> output = new ArrayList<>(Collections.nCopies(n, 0)); // Initialize ArrayList with size n filled with zeros
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of totals occurrences in count[]
        for (int i = 0; i < n; i++)
            count[(inputList.get(i)/exp) % 10]++;

        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output.set(count[(inputList.get(i)/exp) % 10] - 1, inputList.get(i));
            count[(inputList.get(i)/exp) % 10]--;
        }

        // Copy the output array to inputList[], so that inputList[] now contains sorted numbers according to current digit
        for (int i = 0; i < n; i++)
            inputList.set(i, output.get(i));
    }

    /**
     * Sorts a list of integers in ascending order using the bubble sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    @Override
    public List<Integer> bubbleSort(List<Integer> inputList) {
        int size = inputList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (inputList.get(j) > inputList.get(j + 1)) {
                    int temp = inputList.get(j);
                    inputList.set(j, inputList.get(j + 1));
                    inputList.set(j + 1, temp);
                }
            }
        }
        return inputList;
    }

    /**
     * Sorts a list of integers in ascending order using the insertion sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    @Override
    public List<Integer> insertionSort(List<Integer> inputList) {
        for (int i = 1; i < inputList.size(); i++) {
            int key = inputList.get(i);
            int j = i - 1;

            // Move elements of inputList[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && inputList.get(j) > key) {
                inputList.set(j + 1, inputList.get(j));
                j = j - 1;
            }
            inputList.set(j + 1, key);
        }
        return inputList;
    }

    /**
     * Sorts a list of integers in ascending order using the selection sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    @Override
    public List<Integer> selectionSort(List<Integer> inputList) {
        int size = inputList.size();

        for (int i = 0; i < size - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < size; j++) {
                if (inputList.get(j) < inputList.get(min_idx)) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element
            if (min_idx != i) {
                int temp = inputList.get(min_idx);
                inputList.set(min_idx, inputList.get(i));
                inputList.set(i, temp);
            }
        }
        return inputList;
    }

    /**
     * Sorts a list of integers in ascending order using the quick sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    @Override
    public List<Integer> quickSort(List<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return List.of();
        }
        quickSortHelper(inputList, 0, inputList.size() - 1);
        return inputList;
    }

    /**
     * Sorts a portion of a list of integers in ascending order using the quick sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @param low the starting index of the portion to be sorted
     * @param high the ending index of the portion to be sorted
     */
    private void quickSortHelper(List<Integer> inputList, int low, int high) {
        int i = low, j = high;
        int pivot = inputList.get(low + (high - low) / 2);

        while (i <= j) {
            while (inputList.get(i) < pivot) {
                i++;
            }
            while (inputList.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                Collections.swap(inputList, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSortHelper(inputList, low, j);
        }
        if (i < high) {
            quickSortHelper(inputList, i, high);
        }
    }

    /**
     * Sorts a list of integers in ascending order using the heap sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    @Override
    public List<Integer> heapSort(List<Integer> inputList) {
        int size = inputList.size();

        // Build max heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(inputList, size, i);
        }

        // Heap sort
        for (int i = size - 1; i >= 0; i--) {
            int temp = inputList.get(0);
            inputList.set(0, inputList.get(i));
            inputList.set(i, temp);

            // Heapify root element
            heapify(inputList, i, 0);
        }
        return inputList;
    }

    /**
     * Heapify is a method used in the heap sort algorithm to build a maximum heap.
     *
     * @param array the list of integers to be heapified
     * @param size the size of the heap/tree
     * @param i the index of the node to be heapified
     */
    private void heapify(List<Integer> array, int size, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && array.get(left) > array.get(max))
            max = left;

        if (right < size && array.get(right) > array.get(max))
            max = right;

        if (max != i) {
            Collections.swap(array, i, max);
            heapify(array, size, max);
        }
    }

}

