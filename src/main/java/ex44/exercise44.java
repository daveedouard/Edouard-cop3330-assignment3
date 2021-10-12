/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Edouard
 */

package ex44;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class exercise44 {
    public static class prodSearch {
        Products prod;

        // Parses input
        public void readFile(String fileName) throws FileNotFoundException {
            BufferedReader bRead = new BufferedReader(new FileReader(fileName));

            Gson gson = new Gson();

            prod = gson.fromJson(bRead, Products.class);
            System.out.println(prod);
        }

        private boolean checkProd(String product) {

            // Checking product names
            for (int i = 0; i < prod.data.size(); i++) {
                if (prod.data.get(i).equals(product)) {
                    printProdInfo(prod.data.get(i));
                    return true;
                }
            }

            System.out.println("Sorry, that product was not found in our inventory.");

            return false;
        }

        private void printProdInfo(DataList dataBlock) {
            System.out.println("Name: " + dataBlock.name);
            System.out.println("Price: " + dataBlock.price);
            System.out.println("Quantity: "  + dataBlock.quantity);
        }

        //  Keep asking user to type product till correct
        public void start() {
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.println("What is the product name?");
                String inputStr = input.next();
                if (checkProd(inputStr) == true) {
                    break;
                }
            }
        }
    }

    // Represent products
    public static class Products {
        List<DataList> data;

        public Products(List<DataList> data) {
            this.data = data;
        }
    }

    // Storing data entered into a list
    public static class DataList {
        String name;
        double price;
        int quantity;

        public DataList(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        prodSearch p = new prodSearch();
        p.readFile("src/main/java/ex44/exercise44_input.json");
        p.start();
    }

}
