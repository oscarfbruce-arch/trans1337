package java;
//import java.io.*;
//import java.nio.*;
import java.util.*;
public class MainClass{
    public void main(String [] args){
        System.out.println("True for translate to leet, False for translate from leet");
        Scanner selectionScanner = new Scanner(System.in); 
        boolean selectionInput = selectionScanner.nextBoolean();
        
        System.out.println("Input csv file, text string");
        Scanner csvScanner = new Scanner(System.in);
        String csvString = csvScanner.nextLine();
        
        if (selectionInput){ //takes input so it can translate either to or from leet
            System.out.println("translating to leet");
            TranslateToLeet transLeet = new TranslateToLeet(); //takes input, calls "TranslateToLeet" class and returns outcome
            Scanner inputScan = new Scanner(System.in); 
            String inputString = inputScan.nextLine();
            System.out.println("Input String: " + inputString);
            String output = transLeet.transToLeet(inputString, csvString);
            System.out.println("output: " + output);
        }
        else{
            System.out.println("translating from leet");
            TranslateFromLeet transLeet = new TranslateFromLeet();
            Scanner inputScan = new Scanner(System.in);
            String inputString = inputScan.nextLine();
            System.out.println("Input String: " + inputString);
            String output = transLeet.leetToString(inputString, csvString);
            System.out.println("output: " + output);
        }
    }
}