package com.tv.docker.service;

import com.tv.docker.implementation.SortImplementation;
import com.tv.docker.implementation.StringSearchImplementation;
import com.tv.docker.interfacepak.Sort;
import com.tv.docker.interfacepak.StringSearch;
import com.tv.docker.model.Response;
import com.tv.docker.model.SortResponse;
import com.tv.docker.model.StringSearchResponse;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author tarunvishwakarma81
 * The ServiceClass class provides methods for sorting a list of integers and searching for strings using various algorithms.
 */
public class ServiceClass {

    /**
     * The sort variable is an instance of the SortImplementation class, which implements the Sort interface.
     * It is used for sorting a list of integers using various sorting algorithms.
     */
    private final Sort sort = new SortImplementation();
    /**
     * The stringSearch variable is an instance of the `StringSearch` interface which provides various string searching algorithms.
     * It is set to an instance of `StringSearchImplementation` class, which is an implementation of the `StringSearch` interface.
     * The `StringSearch` interface declares several methods for performing different string search algorithms.
     * <p>
     * Example usage:
     * ```
     * JSONObject result = stringSearch.nativeSearch(searchList);
     * ```
     */
    private final StringSearch stringSearch = new StringSearchImplementation();

    /**
     * The list of sort algorithm names.
     * Available sort algorithms: radixSort, mergeSort, bubbleSort, insertionSort, selectionSort, quickSort, heapSort.
     * <p>
     * This list is used to store the available sorting algorithm names that can be used for sorting a list of integers.
     * The order of the sort algorithm names in this list determines the order in which they will be displayed or used.
     * <p>
     * Example usage:
     * List<String> sortTypes = sortTypeList;
     * for (String sortType : sortTypes) {
     *   System.out.println("Sort algorithm: " + sortType);
     * }
     * <p>
     * This variable is private, final, and cannot be modified after initialization.
     */
    private final List<String> sortTypeList = List.of("radixSort", "mergeSort","bubbleSort","insertionSort","selectionSort","quickSort","heapSort");
    /**
     * The sortStrategies variable is a private final Map that holds various sorting strategies
     * mapped to their corresponding functions.
     * <p>
     * The keys of the map represent the names of the sorting strategies, and the values are
     * functional interfaces that accept a list of integers and return a sorted list of integers.
     * <p>
     * The available sort strategies include:
     * <p>
     * 1. "mergeSort" - Uses the merge sort algorithm to sort the input list. The function to perform
     *                  merge sort is provided by the sort class.
     * <p>
     * 2. "radixSort" - Uses the radix sort algorithm to sort the input list. The function to perform
     *                  radix sort is provided by the sort class.
     * <p>
     * 3. "bubbleSort" - Uses the bubble sort algorithm to sort the input list. The function to perform
     *                   bubble sort is provided by the sort class.
     * <p>
     * 4. "insertionSort" - Uses the insertion sort algorithm to sort the input list. The function to perform
     *                      insertion sort is provided by the sort class.
     * <p>
     * 5. "selectionSort" - Uses the selection sort algorithm to sort the input list. The function to perform
     *                      selection sort is provided by the sort class.
     * <p>
     * 6. "quickSort" - Uses the quick sort algorithm to sort the input list. The function to perform
     *                  quick sort is provided by the sort class.
     * <p>
     * 7. "heapSort" - Uses the heap sort algorithm to sort the input list. The function to perform
     *                 heap sort is provided by the sort class.
     */
    private final Map<String, Function<List<Integer>, List<Integer>>> sortStrategies = Map.of(
            "mergeSort", sort::mergeSort,
            "radixSort", sort::radixSort,
            "bubbleSort", sort::bubbleSort,
            "insertionSort", sort::insertionSort,
            "selectionSort", sort::selectionSort,
            "quickSort", sort::quickSort,
            "heapSort", sort::heapSort
    );

    /**
     * The searchTypeList variable is a private final List of String objects.
     * It contains the available search types for searching operations.
     * <p>
     * The list includes the following search types:
     * 1. nativeSearch
     * 2. rabinKarp
     * 3. knuthMorrisPratt
     * 4. boyerMoore
     * 5. ahoCorasick
     * 6. suffixTree
     * 7. finiteAutomata
     * <p>
     * The searchTypeList variable is defined in the ServiceClass class.
     * <p>
     * Example usage:
     * List<String> searchTypes = ServiceClass.searchTypeList;
     *
     */
    private final List<String> searchTypeList = List.of("nativeSearch", "rabinKarp", "knuthMorrisPratt", "boyerMoore", "ahoCorasick", "finiteAutomata");
    /**
     * The searchStrategies variable is a private final Map that maps
     * search strategy names to functions that perform the search.
     * The keys in the map represent the names of the search strategies,
     * while the values are functions that accept a List of Strings and
     * return a JSONObject.
     * <p>
     * The available search strategies and their corresponding functions are:
     * <p>
     * - "nativeSearch": stringSearch::nativeSearch
     *   - Function declaration: JSONObject nativeSearch(List<String> searchList)
     *   - Description: Uses a native search algorithm to find matches in the searchList.
     * <p>
     * - "rabinKarp": stringSearch::rabinKarp
     *   - Function declaration: JSONObject rabinKarp(List<String> searchList)
     *   - Description: Uses the Rabin-Karp algorithm to find matches in the searchList.
     * <p>
     * - "knuthMorrisPratt": stringSearch::knuthMorrisPratt
     *   - Function declaration: JSONObject knuthMorrisPratt(List<String> searchList)
     *   - Description: Uses the Knuth-Morris-Pratt algorithm to find matches in the searchList.
     * <p>
     * - "boyerMoore": stringSearch::boyerMoore
     *   - Function declaration: JSONObject boyerMoore(List<String> searchList)
     *   - Description: Uses the Boyer-Moore algorithm to find matches in the searchList.
     * <p>
     * - "ahoCorasick": stringSearch::ahoCorasick
     *   - Function declaration: JSONObject ahoCorasick(List<String> searchList)
     *   - Description: Uses the Aho-Corasick algorithm to find matches in the searchList.
     * <p>
     * - "suffixTree": stringSearch::suffixTree
     *   - Function declaration: JSONObject suffixTree(List<String> searchList)
     *   - Description: Uses a suffix tree algorithm to find matches in the searchList.
     * <p>
     * - "finiteAutomata": stringSearch::finiteAutomata
     *   - Function declaration: JSONObject finiteAutomata(List<String> searchList)
     *   - Description: Uses a finite automata algorithm to find matches in the searchList.
     */
    private final Map<String, BiFunction<List<String>,String, JSONObject>> searchStrategies = Map.of(
            "nativeSearch", stringSearch::nativeSearch,
            "rabinKarp", stringSearch::rabinKarp,
            "knuthMorrisPratt", stringSearch::knuthMorrisPratt,
            "boyerMoore", stringSearch::boyerMoore,
            "ahoCorasick", stringSearch::ahoCorasick,
            "finiteAutomata", stringSearch::finiteAutomata
    );

    /**
     * Sorts the input list of integers based on the specified sort type.
     *
     * @param sortPayload a {@link List} of {@link Integer} representing the list of integers to be sorted
     * @param sortType a {@link String} representing the sort type to be used
     * @return a {@link SortResponse} object containing the sorted list and response status
     */
    public SortResponse sortResponse(List<Integer> sortPayload, String sortType) {
        if (!sortStrategies.containsKey(sortType)) {
            return new SortResponse(null, new Response("Bad Format", 400, "Invalid or wrong sort type provided. Please use /docker/sortTypes to know all the available sort types."));
        }
        List<Integer> sortRes = sortStrategies.get(sortType).apply(sortPayload);
        return new SortResponse(sortRes, new Response("OK", 0,"Sorted" ));
    }

    /**
     * Retrieves a list of available sort types.
     *
     * @return a List of Strings representing the available sort types
     */
    public List<String> sortType() {
        return sortTypeList;
    }

    /**
     * Retrieves a list of available search types.
     *
     * @return a List of Strings representing the available search types
     */
    public List<String> searchTypes() {
        return searchTypeList;
    }

    /**
     * Searches for a list of strings based on the specified search type.
     *
     * @param searchStrList a {@link List} of {@link String} representing the list of strings to search
     * @param searchType a {@link String} representing the search type
     * @return a {@link StringSearchResponse} object containing the search results and response status
     */
    public StringSearchResponse searchString(List<String> searchStrList,String matchPattern, String searchType) {
        if (!searchStrategies.containsKey(searchType)) {
            return new StringSearchResponse(0, null,null,null,new Response("Bad Format",400,"Invalid or wrong search type provided. Please use /docker/searchTypes to know all the available search types"));
        }
        JSONObject jObj = searchStrategies.get(searchType).apply(searchStrList,matchPattern);
        return new StringSearchResponse((int)jObj.get("countMatch"),
                (List<Integer>)jObj.get("matchPositions"),
                (List<String>) jObj.get("matchedStrings"),
                jObj.get("matchPattern").toString(),
                new Response("OK",200,"Search completed successfully"));
    }
}