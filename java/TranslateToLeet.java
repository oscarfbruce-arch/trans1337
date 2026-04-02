package java;
import java.io.*;
//import java.nio.*;
//import java.util.*;
public class TranslateToLeet{
    
public String transToLeet(String input, String CSV){
    //method that calls everything and then runs the for loop to return translated area
    String leetString = "";

    String[][] transArray = csvToArrayList(CSV);
    
    for (int i = 0; i < input.length(); i++){

        int charIndex = stringToInt(input, i);
        int arrayOptions = transArray[charIndex].length;
        String transChar = transArray[charIndex][(int)(Math.random() * arrayOptions)];
        leetString += transChar;
    }
    
        return leetString;
    }
    public int stringToInt(String input, int i){
    //translates a character into it's numerical value
    int output = 0;
    
    char currentChar = input.charAt(i);
    if (Character.isLetter(currentChar)){
        int csvNumber = Character.getNumericValue(currentChar);
    output = csvNumber - 10;
    //System.out.println(output);
    return output;
    }
    else{
    return 26;
    }
    }

    private String[][] csvToArrayList(String csv){ //takes a comma separated CSV and turns it into primitive 2d array
    int lineCount = 0; 
    
    //first pass, count lines of csv
    try (BufferedReader reader = new BufferedReader(new FileReader("csv/" + csv))) {
    String line;

    while ((line = reader.readLine()) != null) {
        lineCount++;
    }
    }catch (Exception e){
        System.out.println("Error: CSV file not found");
        return new String[0][0];
    }
    String[][] CSVarray = new String [lineCount][];
    //second pass, use 1D array to populate 2d Array
    try (BufferedReader reader = new BufferedReader(new FileReader("csv/" + csv))) {
    String line;
    int row = 0;

    while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            CSVarray[row] = new String[values.length];
        for (int col = 0; col < values.length; col++) {
                CSVarray[row][col] = (values[col].trim());
            }
        row++;
    }

    }catch (Exception e){
        System.out.println("Error: CSV file not found");
        return new String[0][0];
    }

    return CSVarray;
}
}
  
