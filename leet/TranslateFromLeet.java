package leet;
//import java.io.*;
//import java.nio.*;
//import java.util.*;
public class TranslateFromLeet {
    
    public String leetToString (String input, String CSV){
        String transString = "";    
        CSVtoArray translateCSV = new CSVtoArray();
        String [][] transArray = translateCSV.csvTo2DArray(CSV);
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

}
