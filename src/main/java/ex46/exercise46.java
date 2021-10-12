/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Edouard
 */

package ex46;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class exercise46 {
    public static class wordCount {

        private HashMap<String, Integer> frequencyMap = new HashMap<>();

        public void readInput(String inputString) throws FileNotFoundException {
            Scanner input = new Scanner(new File(inputString));
            // go through file
            while (input.hasNext()) {
                String word = input.next();
                Integer count = frequencyMap.get(word);

                if (count == null) {
                    frequencyMap.put(word, 1);
                } else {
                    frequencyMap.put(word, count + 1);
                }
            }
        }

        // print frequency based on expected output
        public void printCount() {
            PriorityQueue<Map.Entry<String, Integer>> heapSort = sortFrequency();

            while (!heapSort.isEmpty()) {
                Map.Entry<String, Integer> entry = heapSort.poll();
                System.out.printf("%-10s ", entry.getKey() + ":");
                for (int i = 0; i < entry.getValue(); i++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        // Sorting the counts
        private PriorityQueue<Map.Entry<String, Integer>> sortFrequency() {

            PriorityQueue<Map.Entry<String, Integer>> p = new PriorityQueue<>(
                    (a,b) -> (a.getValue() == b.getValue()) ? -b.getKey().compareTo(a.getKey()) : -(a.getValue()-b.getValue())
            );
            for(Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
                p.add(entry);
            }
            return p;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        wordCount wc = new wordCount();
        wc.readInput("src/main/java/ex46/exercise46_input.txt");
        wc.printCount();
    }
}
