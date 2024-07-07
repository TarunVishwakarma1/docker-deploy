package com.tv.docker.interfacepak;

import java.util.List;

/**
 * @author tarunvishwakarma81
 * The Sort interface provides a method for sorting a list of integers in ascending order using the merge sort algorithm.
 */
public interface Sort {

    /**
     * Sorts a list of integers in ascending order using the merge sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    public List<Integer> mergeSort(List<Integer> inputList);

    /**
     * Sorts a list of integers in ascending order using the radix sort algorithm.
     *
     **/
    public List<Integer> radixSort(List<Integer> inputList);

    /**
     * Sorts a list of integers in ascending order using the bubble sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    public List<Integer> bubbleSort(List<Integer> inputList);

    /**
     * Sorts a list of integers in ascending order using the insertion sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    public List<Integer> insertionSort(List<Integer> inputList);

    /**
     * Sorts a list of integers in ascending order using the selection sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    public List<Integer> selectionSort(List<Integer> inputList);

    /**
     * Sorts a list of integers in ascending order using the quick sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    public List<Integer> quickSort(List<Integer> inputList);

    /**
     * Sorts a list of integers in ascending order using the heap sort algorithm.
     *
     * @param inputList the list of integers to be sorted
     * @return a new list containing the sorted integers
     */
    public List<Integer> heapSort(List<Integer> inputList);
}
