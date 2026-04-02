package leet;
//import java.io.*;
//import java.nio.*;
//import java.util.*;
public class TranslateToLeet{
    
public String transToLeet(String input, String CSV){
    //method that calls everything and then runs the for loop to return translated area
    String leetString = "";
    CSVtoArray translateCSV = new CSVtoArray();
    String[][] transArray = translateCSV.csvTo2DArray(CSV);
    
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
    
    char currentChar = input.charAt(i); //turns string input into char
    if (Character.isLetter(currentChar)){
        int csvNumber = Character.getNumericValue(currentChar);
    output = csvNumber - 10;
    return output;
    }
    else{
        try {
            int number = Integer.parseInt(String.valueOf(currentChar));
            if (Math.abs(number) < 10){
                return number + 27;
            }
        } catch (Exception e) {
            return 26;
        }
    }
    return 26;
    }
}
  
