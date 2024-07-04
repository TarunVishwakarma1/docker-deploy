package com.tv.docker;
import com.tv.docker.implementation.SortImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DockerDeployApplicationTests {

    @Autowired
    private SortImplementation implementation;

    @Test
    void contextLoads() {
    }

    @Test
    void testAllSortingMethodsInSortInterface() {
        List<List<Integer>> inputLists = Arrays.asList(
                Arrays.asList(3, 1, 6, 2, 4, 5),
                Arrays.asList(6, 1, 3, 2, 4, 5),
                Arrays.asList(3, 1, 2, 6, 5, 4),
                Arrays.asList(5, 1, 2, 3, 4, 6)
        );
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (List<Integer> inputList : inputLists) {
            // Test merge sort
            List<Integer> mergeSortResult = implementation.mergeSort(new ArrayList<>(inputList));
            Assertions.assertEquals(expectedResult, mergeSortResult);

            // Test radix sort
            List<Integer> radixSortResult = implementation.radixSort(new ArrayList<>(inputList));
            Assertions.assertEquals(expectedResult, radixSortResult);

            // Test bubble sort
            List<Integer> bubbleSortResult = implementation.bubbleSort(new ArrayList<>(inputList));
            Assertions.assertEquals(expectedResult, bubbleSortResult);

			List<Integer> insertionSortResult = implementation.insertionSort(new ArrayList<>(inputList));
            Assertions.assertEquals(expectedResult, insertionSortResult);

            List<Integer> selectionSortResult = implementation.selectionSort(new ArrayList<>(inputList));
            Assertions.assertEquals(expectedResult, selectionSortResult);

            List<Integer> quickSortResult = implementation.quickSort(new ArrayList<>(inputList));
            Assertions.assertEquals(expectedResult, quickSortResult);

            List<Integer> heapSortResult = implementation.heapSort(new ArrayList<>(inputList));
            Assertions.assertEquals(expectedResult, heapSortResult);
        }
    }
}