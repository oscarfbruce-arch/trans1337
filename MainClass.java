//import java.io.*;
//import java.nio.*;
import java.util.*;
public class MainClass{
    public void main(String [] args){
        Scanner selectionScanner = new Scanner(System.in); 
        boolean selectionInput = selectionScanner.nextBoolean();

        if (selectionInput){ //takes input so it can translate either to or from leet
            System.out.println("translating to leet");
            TranslateToLeet transLeet = new TranslateToLeet(); //takes input, calls "TranslateToLeet" class and returns outcome
            Scanner inputScan = new Scanner(System.in); 
            String inputString = inputScan.nextLine();
            System.out.println("Input String: " + inputString);
            String output = transLeet.transToLeet(inputString, "leetSimple.csv");
            System.out.println("output: " + output);
        }
        else{
            System.out.println("translating from leet");
            TranslateFromLeet transLeet = new TranslateFromLeet();
            Scanner inputScan = new Scanner(System.in);
            String inputString = inputScan.nextLine();
            System.out.println("Input String: " + inputString);
            String output = transLeet.leetToString(inputString, "leetSimple.csv");
            System.out.println("output: " + output);
        }
    }
}