/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Edouard
 */

package ex43;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class exercise43 {
    // Website builder
    public static class website {
        Scanner input = new Scanner(System.in);
        String currentPath, author, name;
        char javaScript = 'N';
        char css = 'N';

        public void userInput() {
            // prompt for the user inputs
            System.out.print("Site name: ");
            name = input.nextLine();
            System.out.print("Author: ");
            author = input.nextLine();
            System.out.print("Do you want a folder for JavaScript? ");
            javaScript = input.next().charAt(0);
            System.out.print("Do you want a folder for CSS? ");
            css = input.next().charAt(0);
        }

        public void createFiles() {
            // Find path
            currentPath = System.getProperty("user.dir");
            currentPath += "\\"+ name;
            File website = new File(currentPath);
            // Creates directory
            boolean websiteCreated = website.mkdir();
            if(websiteCreated)
            {
                System.out.println("Created " + currentPath);
                try
                {
                    // Creates html
                    FileWriter output = new FileWriter(new File(currentPath+"\\index.html"));
                    output.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                    output.write("\t<meta author=\""+author+"\">\n");
                    output.write("\t<title>"+ name +"</title>\n");
                    output.write("</head>\n<body>\n\n</body>\n</html>");
                    output.close();

                    System.out.println("Created " + currentPath+"\\index.html");
                    // Create javascript
                    if(javaScript == 'y' || javaScript == 'Y')
                    {
                        File javaScriptFolder = new File(currentPath+"\\javascript");
                        boolean javaScriptCreated = javaScriptFolder.mkdir();
                        if(javaScriptCreated)
                        {
                            System.out.println("Created " + javaScriptFolder+"\\");
                        }
                        else
                        {
                            System.out.println("javascript creation unsuccessful");
                        }
                    }
                    // Create css
                    if(css == 'y' || css == 'Y')
                    {
                        File cssFolder = new File(currentPath+"\\css");
                        boolean cssCreated = cssFolder.mkdir();
                        if(cssCreated)
                        {
                            System.out.println("Created " + cssFolder+"\\");
                        }
                        else
                        {
                            System.out.println("css creation unsuccessful.");
                        }
                    }
                }
                catch(IOException e)
                {
                    System.out.println("index.html creation unsuccessful.");
                }
            }
            else
            {
                System.out.println("Folder creation unsuccessful.");
            }
            input.close();
        }
    }

    public static void main(String[] args)
    {
        website w = new website();
        w.userInput();
        w.createFiles();
    }
}

