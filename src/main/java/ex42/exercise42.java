/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Edouard
 */

package ex42;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;


public class exercise42 {

    public static class functions {

        public List<dataSplit> data = null;

        public static class dataSplit {
            String lastName;
            String firstName;
            int salary;

            public dataSplit(String lastName, String firstName, int salary) {
                this.lastName = lastName;
                this.firstName = firstName;
                this.salary = salary;
            }
        }

        public void addList(String str) {
            String[] parsedData = str.split(",");
            data.add(new dataSplit(parsedData[0], parsedData[1], Integer.parseInt(parsedData[2])));
        }

        public void parseData(String inputFile) throws FileNotFoundException {
            data = new ArrayList<>();
            Scanner input = new Scanner(new File(inputFile));

            while (input.hasNextLine()) {
                String line = input.nextLine();
                addList(line);
            }
        }

        public void printOutput(){
            if (data == null) return;

            System.out.printf("Last\tFirst\tSalary\t\n-------------------------\n");
            for (int i = 0; i < data.size(); i++) {
                dataSplit lines = data.get(i);
                System.out.printf("%-10s%-10s%-10d\n", lines.lastName, lines.firstName, lines.salary);
            }
        }

    }

    public static void main(String[] args)throws FileNotFoundException{
        Scanner input = new Scanner(new File("src/main/java/ex42/exercise42_input.txt"));
        functions f = new functions();
        f.parseData("src/main/java/ex42/exercise42_input.txt");
        f.printOutput();
    }
}
