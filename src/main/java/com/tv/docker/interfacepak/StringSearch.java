package com.tv.docker.interfacepak;

import org.json.simple.JSONObject;

import java.util.List;

/**
 * @author tarunvishwakarma81
 * The StringSearch interface defines the methods for performing various string search algorithms on a given list of strings using a match pattern.
 */
public interface StringSearch {
    /**
     * Performs a native search on a given list of strings using a match pattern.
     *
     * @param searchList   a {@code List<String>} representing the list of strings to search
     * @param matchPattern a {@code String} representing the pattern to match
     * @return a {@code JSONObject} containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    JSONObject nativeSearch (List<String> searchList,String matchPattern);

    /**
     * The rabinKarp method performs a string search on a given list of strings using the Rabin-Karp algorithm.
     *
     * @param searchList   a {@code List<String>} representing the list of strings to search
     * @param matchPattern a {@code String} representing the pattern to match
     * @return a {@code JSONObject} containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    JSONObject rabinKarp (List<String> searchList,String matchPattern);

    /**
     * The knuthMorrisPratt method performs a string search on a given list of strings using the Knuth-Morris-Pratt algorithm.
     *
     * @param searchList   a {@code List<String>} representing the list of strings to search
     * @param matchPattern a {@code String} representing the pattern to match
     * @return a {@code JSONObject} containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    JSONObject knuthMorrisPratt (List<String> searchList,String matchPattern);

    /**
     * Performs a string search on a given list of strings using the Boyer-Moore algorithm.
     *
     * @param searchList   a {@code List<String>} representing the list of strings to search
     * @param matchPattern a {@code String} representing the pattern to match
     * @return a {@code JSONObject} containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    JSONObject boyerMoore (List<String> searchList,String matchPattern);

    /**
     * Performs a string search on a given list of strings using the Aho-Corasick algorithm.
     *
     * @param searchList   a {@code List<String>} representing the list of strings to search
     * @param matchPattern a {@code String} representing the pattern to match
     * @return a {@code JSONObject} containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    JSONObject ahoCorasick (List<String> searchList,String matchPattern);

    /**
     * Performs a string search on a given list of strings using a finite automata algorithm.
     *
     * @param searchList   a {@code List<String>} representing the list of strings to search
     * @param matchPattern a {@code String} representing the pattern to match
     * @return a {@code JSONObject} containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    JSONObject finiteAutomata (List<String> searchList,String matchPattern);

}
