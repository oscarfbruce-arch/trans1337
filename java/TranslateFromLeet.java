package java;
import java.io.*;
//import java.nio.*;
//import java.util.*;
public class TranslateFromLeet {
    
    public String leetToString (String input, String CSV){
        String transString = "";    
        String [][] transArray = csvToArrayList(CSV);
        String errorString = "UNABLE TO FIND STRING";
        String currentLetter = "";
        int leetCharLength;
        int i = 0;

        while (i < input.length()){
        leetCharLength = 1;

            while (leetCharLength <= input.length()){// increase search length untill match is found
                currentLetter = findMatch(input.substring(i, i + leetCharLength), transArray);
                if(!currentLetter.equals(errorString)){ 
                    break;
                }
                leetCharLength++;
            }
            if(currentLetter.equals(errorString)){
                transString+=input.substring(i); //if it's not found in the 2d array, just go forward one and put down the leetcode character
                i++;
            }
            else{
                transString+=currentLetter; //increase search window by leet symbol
                i+=leetCharLength;
            }
        }
    return transString;
    }
    
    
    public String findMatch (String leetInput, String[][] lookupTable){ //compares leet symbol to csv array's position
        int csvSpaceLocation = 26;
        if(leetInput.equals(lookupTable[csvSpaceLocation][0])){ //space
            return " ";
        }

        for(int line = 0; line < lookupTable.length; line++){
            for(int option = 0; option < lookupTable[line].length; option++){
                if(leetInput.equals(lookupTable[line][option])){
                    String outputString = "" + Character.forDigit((line + 10),36); //returns latin script position in csv
                    return outputString;
                }
            }
        }

        return "UNABLE TO FIND STRING";
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
