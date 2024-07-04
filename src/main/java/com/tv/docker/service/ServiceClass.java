package com.tv.docker.service;

import com.tv.docker.implementation.SortImplementation;
import com.tv.docker.interfacepak.Sort;
import com.tv.docker.model.Response;
import com.tv.docker.model.SortResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tarunvishwakarma81
 * The ServiceClass class provides methods to sort a list of integers using different sorting algorithms.
 */
public class ServiceClass {

    /**
     * The Sort interface provides a method for sorting a list of integers in ascending order using different sorting algorithms.
     */
    Sort sort = new SortImplementation();

    /**
     * Represents a list of sorting algorithms.
     *
     * <p>
     * The sortTypeList variable is a list of strings that contains the names of different sorting algorithms.
     * It is used to provide the available sort types to the users.
     * </p>
     *
     * <p>
     * Example usage:
     * </p>
     *
     * <pre>{@code
     * List<String> sortTypeList = new ArrayList<>(List.of("radixSort", "mergeSort",
     *                                                      "bubbleSort",
     *                                                      "insertionSort",
     *                                                      "selectionSort",
     *                                                      "quickSort",
     *                                                      "heapSort"));
     * }</pre>
     */
    List<String> sortTypeList = new ArrayList<>(List.of("radixSort", "mergeSort","bubbleSort","insertionSort","selectionSort","quickSort","heapSort"));

    /**
     * Sorts the input list of integers based on the specified sort type.
     *
     * @param sortPayload a list of integers to be sorted
     * @param sortType    the type of sort algorithm to be used
     * @return a SortResponse object containing the sorted list and the response status
     * @throws Exception if an error occurs during the sorting process
     */
    public SortResponse sortResponse(List<Integer> sortPayload, String sortType) throws Exception{
        List<Integer> sortRes;

        switch (sortType){
            case "mergeSort" :
                sortRes = sort.mergeSort(sortPayload);
                break;
            case "radixSort":
                sortRes = sort.radixSort(sortPayload);
                break;
            case "bubbleSort":
                sortRes = sort.bubbleSort(sortPayload);
                break;
            case "insertionSort":
                sortRes = sort.insertionSort(sortPayload);
                break;
            case "selectionSort":
                sortRes = sort.selectionSort(sortPayload);
                break;
            case "quickSort":
                sortRes = sort.quickSort(sortPayload);
                break;
            case "heapSort":
                sortRes = sort.heapSort(sortPayload);
                break;
            default:
                return new SortResponse(null, new Response("Bad Format", 400, "invalid or wrong sort type provided. Please use /docker/sortTypes to know all the available sort types."));
        }
        return new SortResponse(sortRes, new Response("OK", 0,"Sorted" ));
    }

    /**
     * Returns a list of available sort types.
     *
     * @return a List of Strings representing the available sort types.
     */
    public List<String> sortType(){
        return sortTypeList;
    }
}
