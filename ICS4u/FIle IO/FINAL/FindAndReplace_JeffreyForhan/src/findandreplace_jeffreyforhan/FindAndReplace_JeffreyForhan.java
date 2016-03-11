/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findandreplace_jeffreyforhan;

/**
 *
 * @author jefor2991
 */

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FindAndReplace_JeffreyForhan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner to get user input
        Scanner sc = new Scanner(System.in);
        //The file  that is being accessed
        File file;
        //The path of the file's location
        String path = "";
        //The word being replaced
        String wordToReplace = "";
        //The word to replace with
        String replacingWord = "";
        //The current line of text being accessed
        String currentLn;
        
        //Allows info from file to be converted into a string
        FileReader in;
        //Allows a string to be converted into info for a file
        FileWriter out;
        //Allows text to be read
        BufferedReader read;
        //Allows text to be written
        BufferedWriter write;
        //Arraylist to store modified lines from file.
        ArrayList<String> lines = new ArrayList();
        
        try{//Get user input for file, word to replace, and word to replace with
            System.out.print("Input the path of a text file to access: ");
            //Get file path
            path = sc.nextLine();
            System.out.print("Input a word that you wish to be replaced in the file: ");
            //Store word to replace
            wordToReplace = sc.nextLine();
            System.out.print("Input the word to replace with: ");
            //Store replacing word
            replacingWord = sc.nextLine();
            
            //Skip a line
            System.out.println();
            
            //Close scanner once user input is received
            sc.close();
        }catch(InputMismatchException e){//Tell the user about improper input
            System.out.println("Error with text input");
            System.err.println("InputMismatchException: " + e.getMessage());
        }
        
        //Access file that was specified
        file = new File(path);
        try {//If the file doesn't exist, create it
            if(!file.exists()){
                //Create new file
                file.createNewFile();
                System.out.println("No file with same name found. New empty file created. Populate new file with text, and re-run program");
                //Stop program execution if file has to be created
                return;
            }
        } catch (IOException e) {//Tell the user if the file can't be created
            System.out.println("Error creating file");
            System.err.println("IOException: " + e.getMessage());
        }
        
        try{
            //Instantiate the fileReader       
            in = new FileReader(file);
            //Instantiate the BufferedReader
            read = new BufferedReader(in);
            
            //Loop through all lines of text, replace the specified word, add to an ArrayList
            while((currentLn = read.readLine()) != null){
                //Replace all instances of the word the user specified with the new word
                currentLn = currentLn.replaceAll(wordToReplace, replacingWord);
                //Print resulting line to console
                System.out.println(currentLn);
                //Add the modified String to an arraylist, to save data after filewriter clears file
                lines.add(currentLn);
            }
            
            //Close reader and stream once they are done
            read.close();
            in.close();
            
            //Instantiate the FileWriter
            out = new FileWriter(file);
            //Instantiate the BufferedWriter
            write = new BufferedWriter(out);
            
            //Loop through the ArrayList to print out the new text to a file
            for(int i = 0; i < lines.size(); i++){
                write.write(lines.get(i));
                write.newLine();
            }
            
            //Close writers and output stream once they are done
            write.close();
            out.close();
            
        }catch(FileNotFoundException e){//Check if file exists
            System.out.println("Error accessing file");
            System.err.println("FileNotFoundException: " + e.getMessage());
        }catch(IOException e){//Check if there is a problem reading or writing
            System.out.println("Error reading or writing to file");
            System.err.println("IOException: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Changes saved to file.");
    }
}
