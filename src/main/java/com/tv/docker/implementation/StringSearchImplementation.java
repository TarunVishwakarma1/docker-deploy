package com.tv.docker.implementation;

import com.tv.docker.interfacepak.StringSearch;
import com.tv.docker.model.AhoCorasickTrie;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tarunvishwakarma81
 * The `StringSearchImplementation` class implements the `StringSearch` interface to provide different string search algorithms.
 * It provides six different algorithms: native search, Rabin-Karp, Knuth-Morris-Pratt, Boyer-Moore, Aho-Corasick, and Finite Automata.
 * Each algorithm takes a list of strings and a match pattern as input and returns a JSONObject containing the results of the search.
 */
public class StringSearchImplementation implements StringSearch {

    /**
     * Performs a native search on a given list of strings using a match pattern.
     *
     * @param searchList   the list of strings to search
     * @param matchPattern the pattern to match
     * @return a JSONObject containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    @Override
    public JSONObject nativeSearch(List<String> searchList, String matchPattern) {
        JSONObject result = new JSONObject();
        List<Integer> matchPositions = new ArrayList<>();
        List<String> matchedStrings = new ArrayList<>();
        int countMatch = 0;

        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).contains(matchPattern)) {
                countMatch++;
                matchPositions.add(i);
                matchedStrings.add(searchList.get(i));
            }
        }

        result.put("countMatch", countMatch);
        result.put("matchPositions", matchPositions);
        result.put("matchedStrings", matchedStrings);
        result.put("matchPattern", matchPattern);

        return result;
    }

    /**
     * Performs the Rabin-Karp string search algorithm on a given list of strings using a match pattern.
     *
     * @param searchList   the list of strings to search
     * @param matchPattern the pattern to match
     * @return a JSONObject containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    @Override
    public JSONObject rabinKarp(List<String> searchList, String matchPattern) {
        JSONObject result = new JSONObject();
        List<Integer> matchPositions = new ArrayList<>();
        List<String> matchedStrings = new ArrayList<>();
        int countMatch = 0;
        int patternLength = matchPattern.length();

        for (int i = 0; i < searchList.size(); i++) {
            String currentString = searchList.get(i);
            int currentStringLength = currentString.length();
            int patternHash = matchPattern.hashCode();
            int currentHash = currentString.substring(0, patternLength).hashCode();

            for (int j = 0; j <= currentStringLength - patternLength; j++) {
                if (j != 0) {
                    currentHash = (currentHash - currentString.charAt(j - 1)) * 31 + currentString.charAt(j + patternLength - 1);
                }

                if (currentHash == patternHash && matchPattern.equals(currentString.substring(j, j + patternLength))) {
                    countMatch++;
                    matchPositions.add(i);
                    matchedStrings.add(currentString);
                    break;
                }
            }
        }

        result.put("countMatch", countMatch);
        result.put("matchPositions", matchPositions);
        result.put("matchedStrings", matchedStrings);
        result.put("matchPattern", matchPattern);

        return result;
    }

    /**
     * Performs the Knuth-Morris-Pratt string search algorithm on a given list of strings using a match pattern.
     *
     * @param searchList   the list of strings to search
     * @param matchPattern the pattern to match
     * @return a JSONObject containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    @Override
    public JSONObject knuthMorrisPratt(List<String> searchList, String matchPattern) {
        JSONObject result = new JSONObject();
        List<Integer> matchPositions = new ArrayList<>();
        List<String> matchedStrings = new ArrayList<>();
        int countMatch = 0;
        int M = matchPattern.length();
        int[] lps = new int[M];

        // Preprocess the pattern
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (matchPattern.charAt(i) == matchPattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }

        // search the pattern
        for (int j = 0; j < searchList.size(); j++) {
            String txt = searchList.get(j);
            i = 0;
            int j1 = 0;
            int N = txt.length();
            while (i < N) {
                if (matchPattern.charAt(j1) == txt.charAt(i)) {
                    j1++;
                    i++;
                }
                if (j1 == M) {
                    countMatch++;
                    matchPositions.add(j);
                    matchedStrings.add(txt);
                    j1 = lps[j1 - 1];
                } else if (i < N && matchPattern.charAt(j1) != txt.charAt(i)) {
                    if (j1 != 0)
                        j1 = lps[j1 - 1];
                    else
                        i = i + 1;
                }
            }
        }

        result.put("countMatch", countMatch);
        result.put("matchPositions", matchPositions);
        result.put("matchedStrings", matchedStrings);
        result.put("matchPattern", matchPattern);

        return result;
    }

    /**
     * Performs the Boyer-Moore string search algorithm on a given list of strings using a match pattern.
     *
     * @param searchList   the list of strings to search
     * @param matchPattern the pattern to match
     * @return a JSONObject containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    @Override
    public JSONObject boyerMoore(List<String> searchList, String matchPattern) {
        int NO_OF_CHARS = 256;
        JSONObject result = new JSONObject();
        List<Integer> matchPositions = new ArrayList<>();
        List<String> matchedStrings = new ArrayList<>();
        int countMatch = 0;

        for (String txt : searchList) {
            int m = matchPattern.length();
            int n = txt.length();

            int badchar[] = new int[NO_OF_CHARS];

            // Initialize all occurrences as -1
            for (int i = 0; i < NO_OF_CHARS; i++)
                badchar[i] = -1;

            // Fill the actual value of last occurrence of a character
            for (int i = 0; i < m; i++)
                badchar[(int) matchPattern.charAt(i)] = i;

            int s = 0; // s is shift of the pattern with respect to text
            while (s <= (n - m)) {
                int j = m - 1;

                // Keep reducing index j of pattern while characters of pattern and text are matching at this shift s
                while (j >= 0 && matchPattern.charAt(j) == txt.charAt(s + j))
                    j--;

                // If the pattern is present at current shift, then index j will become -1 after the above loop
                if (j < 0) {
                    countMatch++;
                    matchPositions.add(searchList.indexOf(txt));
                    matchedStrings.add(txt);

                    // Shift the pattern so that the next character in text aligns with the last occurrence of it in pattern.
                    // Condition s+m < n is necessary for the case when pattern occurs at the end of text
                    s += (s + m < n) ? m - badchar[txt.charAt(s + m)] : 1;

                } else {
                    // Shift the pattern so that the bad character in text aligns with the last occurrence of it in pattern.
                    s += Math.max(1, j - badchar[txt.charAt(s + j)]);
                }
            }
        }

        result.put("countMatch", countMatch);
        result.put("matchPositions", matchPositions);
        result.put("matchedStrings", matchedStrings);
        result.put("matchPattern", matchPattern);

        return result;
    }

    /**
     * Performs the Aho-Corasick string search algorithm on a given list of strings using a match pattern.
     *
     * @param searchList   the list of strings to search
     * @param matchPattern the pattern to match
     * @return a JSONObject containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    @Override
    public JSONObject ahoCorasick(List<String> searchList, String matchPattern) {
        JSONObject result = new JSONObject();
        List<Integer> matchPositions = new ArrayList<>();
        List<String> matchedStrings = new ArrayList<>();
        int countMatch = 0;

        AhoCorasickTrie trie = new AhoCorasickTrie();
        trie.addKeyword(matchPattern);
        trie.createFailureEdges();

        for (int i = 0; i < searchList.size(); i++) {
            String currentString = searchList.get(i);
            List<Integer> matchIndices = trie.search(currentString);
            if (!matchIndices.isEmpty()) {
                countMatch++;
                matchPositions.add(i);
                matchedStrings.add(currentString);
            }
        }

        result.put("countMatch", countMatch);
        result.put("matchPositions", matchPositions);
        result.put("matchedStrings", matchedStrings);
        result.put("matchPattern", matchPattern);

        return result;
    }


    /**
     * Performs the finite automata string search algorithm on a given list of strings using a match pattern.
     *
     * @param searchList   the list of strings to search
     * @param matchPattern the pattern to match
     * @return a JSONObject containing the results of the search:
     *         - "countMatch": the number of matches found
     *         - "matchPositions": a list of positions in the search list where matches were found
     *         - "matchedStrings": a list of strings that matched the pattern
     *         - "matchPattern": the match pattern used
     */
    @Override
    public JSONObject finiteAutomata(List<String> searchList, String matchPattern) {
        JSONObject result = new JSONObject();
        List<Integer> matchPositions = new ArrayList<>();
        List<String> matchedStrings = new ArrayList<>();
        int patternLength = matchPattern.length();
        int countMatch = 0;

        int[][] transitionTable = new int[patternLength + 1][256];

        // Building transition table
        for (int state = 0; state <= patternLength; state++) {
            for (int ch = 0; ch < 256; ch++) {
                int nextState = Math.min(patternLength, state + 1);
                while (nextState > 0 && matchPattern.charAt(nextState - 1) != ch) {
                    nextState = nextState - 1;
                }
                transitionTable[state][ch] = nextState;
            }
        }

        for (int i = 0; i < searchList.size(); i++) {
            String txt = searchList.get(i);
            int state = 0;
            for (int j = 0; j < txt.length(); j++) {
                state = transitionTable[state][txt.charAt(j)];
                if (state == patternLength) {
                    countMatch++;
                    matchPositions.add(i);
                    matchedStrings.add(txt);
                    break;
                }
            }
        }

        result.put("countMatch", countMatch);
        result.put("matchPositions", matchPositions);
        result.put("matchedStrings", matchedStrings);
        result.put("matchPattern", matchPattern);
        return result;
    }
}
