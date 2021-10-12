/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Edouard
 */

package ex41;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.io.IOException;
import java.io.FileNotFoundException;

public class exercise41 {

    public static void readNames(Scanner input, ArrayList<String> name){
        // Reads and adds name to array for each line
        while(input.hasNextLine()){
            name.add(input.nextLine());
        }
    }

    public static void printNames(ArrayList<String> name) throws IOException{
        // File writer will write the output file
        FileWriter output = new FileWriter("src/main/java/ex41/exercise41_output.txt");
        // Header of output file
        output.write("Total of " +name.size()+" names\n-------------------------\n");
        // Names being written
        for(int i = 0; i<name.size(); i++) {
            output.write(name.get(i) + "\n");
        }
        output.close();
    }

    public static void main(String[] args)throws FileNotFoundException,IOException{
        // Create variable that will read input file
        Scanner input = new Scanner(new File("src/main/java/ex41/exercise41_input.txt"));
        // Create array to read in names
        ArrayList<String> name = new ArrayList<String>();
        // Reads names then sorts them in alphabetical order
        readNames(input, name);
        Collections.sort(name, String.CASE_INSENSITIVE_ORDER);

        // Print output
        try{
            printNames(name);
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
}
