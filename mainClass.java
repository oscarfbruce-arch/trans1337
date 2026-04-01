import java.io.*;
//import java.nio.*;
//import java.util.*;
public class mainClass{
    public void main(String [] args){
        String inputString = "this is a test";
        System.out.println("Input String: " + inputString);
        String output = transToLeet(inputString);
        System.out.println("output: " + output);
    }


    public String transToLeet(String input){
    //method that calls everything and then runs the for loop to return translated area
    String leetString = "";

    String[][] transArray = csvToArrayList("leetSimple.csv");
    
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
    output = csvNumber;
    return output;
    }
    else{
    return 0;
    }
    }

    private String[][] csvToArrayList(String csv){
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
