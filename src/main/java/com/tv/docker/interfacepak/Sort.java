package com.tv.docker.interfacepak;

import java.util.List;

/**
 * @author tarunvishwakarma81@gmail.com
 * The Sort interface provides a method for sorting a list of integers in ascending order using the merge sort algorithm.
 */
public interface Sort {

    public List<Integer> mergeSort(List<Integer> inputList);

    public List<Integer> radixSort(List<Integer> inputList);

    public List<Integer> bubbleSort(List<Integer> inputList);

    public List<Integer> insertionSort(List<Integer> inputList);

    public List<Integer> selectionSort(List<Integer> inputList);

    public List<Integer> quickSort(List<Integer> inputList);

    public List<Integer> heapSort(List<Integer> inputList);
}
