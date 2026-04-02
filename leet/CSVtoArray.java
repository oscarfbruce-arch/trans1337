package leet;
import java.io.*;

public class CSVtoArray{

    public String[][] csvTo2DArray(String csv){ //takes a comma separated CSV and turns it into primitive 2d array
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