/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Edouard
 */

package ex45;

import java.util.*;
import java.io.*;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class exercise45 {
    public static class utilizeFinder {
        String fileString = null;

        // Reads input
        public void readInput(String fileName) throws IOException {
            Scanner in = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            fileString = in.useDelimiter("\\A").next();
        }

        // swap words
        public void swap() {
            if (fileString == null) return;
            fileString = fileString.replace("utilize", "use");
        }

        // print expected output
        public void output() {
            if (fileString == null) return;

            System.out.printf(fileString);
        }
    }

    public static void main(String[] args) throws IOException {
        utilizeFinder wf = new utilizeFinder();
        wf.readInput("src/main/java/ex45/exercise45_input.txt");
        wf.swap();
        wf.output();
    }
}
