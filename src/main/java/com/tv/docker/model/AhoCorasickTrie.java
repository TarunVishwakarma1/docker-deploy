package com.tv.docker.model;

import java.util.*;

/**
 * @author tarunvishwakarma81
 * AhoCorasickTrie is a class that represents a trie data structure used for the Aho-Corasick string search algorithm.
 * The algorithm allows efficient searching for multiple keywords in a given text.
 */
public class AhoCorasickTrie {
    /**
     * Represents a node in the Aho-Corasick Trie data structure.
     */
    private Node root;

    /**
     * Represents a node in the Aho-Corasick Trie data structure.
     */
    private class Node {
        Map<Character, Node> children = new HashMap<>();
        Node failure;
        String word;
    }

    /**
     * Adds a keyword to the Aho-Corasick Trie.
     *
     */
    public AhoCorasickTrie() {
        root = new Node();
    }

    /**
     * Adds a keyword to the Aho-Corasick Trie.
     *
     * @param keyword the keyword to be added to the Trie
     */
    public void addKeyword(String keyword) {
        Node node = root;

        for (char ch : keyword.toCharArray()) {
            Node next = node.children.get(ch);

            if (next == null) {
                next = new Node();
                node.children.put(ch, next);
            }

            node = next;
        }

        node.word = keyword;
    }

    /**
     * Creates failure edges for each node in the Aho-Corasick Trie data structure.
     * Failure edges are used to*/
    public void createFailureEdges() {
        Queue<Node> queue = new LinkedList<>();

        for (Node node : root.children.values()) {
            queue.offer(node);
            node.failure = root;
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
                char ch = entry.getKey();
                Node child = entry.getValue();
                queue.offer(child);

                Node fail = node.failure;
                while (fail != null && !fail.children.containsKey(ch)) {
                    fail = fail.failure;
                }

                child.failure = (fail == null || fail.children.get(ch) == null)
                        ? root
                        : fail.children.get(ch);
            }
        }
    }

    /**
     * Searches for occurrences of a given content in the Aho-Corasick Trie data structure.
     *
     * @param content the content to search for
     * @return a list of integers representing the starting indices of each occurrence of the content
     */
    public List<Integer> search(String content) {
        List<Integer> result = new ArrayList<>();
        Node node = root;

        for (int index = 0; index < content.length(); index++) {
            char ch = content.charAt(index);

            while (node != null && !node.children.containsKey(ch)) {
                node = node.failure;
            }

            node = (node == null)
                    ? root
                    : node.children.get(ch);

            Node temp = node;

            while (temp != null) {
                if (temp.word != null) {
                    result.add(index - temp.word.length() + 1);
                }

                temp = temp.failure;
            }
        }

        return result;
    }
}