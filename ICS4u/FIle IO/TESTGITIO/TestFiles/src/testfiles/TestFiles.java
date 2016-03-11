
/*
 * TestFiles.java from Chapter 12
 * A program that demonstrates file creation.
 *
 */
package testfiles;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
 
 /**
  * A program for demonstrating file objects.
  */
 public class TestFiles {

	public static void main(String[] args) {
            // \\ is an escape sequence for \
            
                //Make a file in the directory specified
		File dataFile = new File("Y:\\ICS4u\\TestFiles\\src\\filesForTestFiles\\grades.dat");
                
                //Variables for reading text from a file
                
                //Requires a file to read
                FileReader in;
                BufferedReader readFile;
                String lineOfText;
                
                //Variables to write to files
                FileWriter out;
                BufferedWriter writeFile;
                Scanner sc = new Scanner(System.in);
                
                //Variables for calculations
                int numberOfGrades;
                int[] setOfGrades = null;
                double totalOfGrades = 0;
                double averageGrades = 0;
                
                //Code for making a file
		if (!dataFile.exists()) {
			try {
				dataFile.createNewFile();
				System.out.println("New file created.");
			} catch (IOException e) {
				System.out.println("File could not be created.");
                                System.err.println("IOException: " + e.getMessage());
                        }
                }     
                
                //Get user input
                try{
                    System.out.print("Enter a number of values: ");
                    numberOfGrades = sc.nextInt();
                    setOfGrades = new int[numberOfGrades];
                    
                    for(int i = 0; i < setOfGrades.length; i++){
                        System.out.print("Enter value " + (i+1) + ": ");
                        setOfGrades[i] = sc.nextInt();
                    }
                }catch(InputMismatchException e){
                    System.err.println("InputMismatchException: " + e.getMessage());
                }
                
                //Write to an external file
                try{
                    out = new FileWriter(dataFile, true);
                    writeFile = new BufferedWriter(out);
                    
                    for(int i = 0; i < setOfGrades.length; i++){
                        writeFile.write(setOfGrades[i]);
                    }
  
                    writeFile.close(); 
                    out.close();
                }
                catch(FileNotFoundException e){
                    System.out.println("File does not exist or cannot be found.");
                    System.err.println("FileNotFoundException: " + e.getMessage());
                }catch(IOException e){
                    System.out.println("Problem writing file.");
                    System.err.println("IOException: " + e.getMessage());
                }
                
                //Code for reading a text file
                try{
                    //Makes a fileReader for the specified file
                    in = new FileReader(dataFile);
                    
                    //Uses the fileReader
                    readFile = new BufferedReader(in);
                    
                    //String is assigned line of text being read
                    //read as there are lines to read
                    //If thyere is no next line, you are done reading
                    while((lineOfText = readFile.readLine()) != null){
                        System.out.println(lineOfText);
                    }
                    //Close fileReader and bufferedReader once they are finished being used
                    readFile.close();
                    in.close();
                }catch(FileNotFoundException e){
                    System.out.println("File does not exist or cannot be found.");
                    System.err.println("FileNotFoundException: " + e.getMessage());
                }catch(IOException e){
                    System.out.println("Problem reading file.");
                    System.err.println("IOException " + e.getMessage());
                }
	}
}
