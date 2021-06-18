import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Driver class for Fractions V2 that reads file fractions.txt
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called Driver
public class Driver{
    /**
     * Method main
     *
     * @param args A parameter
     */
    public static void main(String[] args) {
        //create an ArrayList called fractionsArrayList
        ArrayList<Fraction> fractionArrayList;
        //initialization
        fractionArrayList = new ArrayList<>();
        //create an ArrayList called fractionCounterArrayList
        ArrayList<FractionCounter> fractionCounterArrayList;
        //initialization
        fractionCounterArrayList = new ArrayList<>();
        //fractionFile is null
        FileReader fractionFile = null;
        
        //If a statement in try block raises an exception
        //then the rest of the try block doesn’t execute and control passes to the corresponding catch block
        //try-catch block
        try {
            //reads reads data from file
            fractionFile = new FileReader("fractions.txt");
            //will buffer the input from the file to be able to read the file
            BufferedReader fractionReader;
            fractionReader = new BufferedReader(fractionFile);
            //initializies string variable readLine
            String readLine = "";
            
            //while loop
            while ((readLine = fractionReader.readLine()) != null) {
                // string array that splits the fraction 
                String[] str = readLine.split("/");
                
                //if the length is not 2
                if (str.length != 2) {
                    //print error message
                    System.err.println("Fraction Format incorrect");
                }    
                
                //integer numerator is set to index 0 
                int numerator = Integer.parseInt(str[0]);
                //integer denominator is set to index 1
                int denominator = Integer.parseInt(str[1]);
                //storing numerator and denominator in the fraction object
                Fraction fraction = new Fraction(numerator, denominator);
                //boolean seenThisFaraction is intitialized to false
                boolean seenThisFraction = false;
                
                //fractionArrayList size is equal to 0
                if (fractionArrayList.size() == 0) {
                    //storing fraction in the fraction counter
                    FractionCounter fractionCounter = new FractionCounter(fraction);
                    //add fraction to fractionArrayList
                    fractionArrayList.add(fraction);
                    //add fractionCounter to fractionCounterArrayList
                    fractionCounterArrayList.add(fractionCounter);
                } 
                //otherwise
                else {
                    //check if fraction is already seen before 
                    for (FractionCounter f : fractionCounterArrayList) {
                        //if so increment the count
                        if (f.compareAndIncrement(fraction)) {
                            //seenThisFraction is set to true
                            seenThisFraction = true;
                            //break
                            break;
                        }
                    }
                   
                    //if we havent seen this fraction 
                    if(!seenThisFraction) {
                        //add fraction to fractionArrayList
                        fractionArrayList.add(fraction);
                        //store fraction to object fractionCounter
                        FractionCounter fractionCounter = new FractionCounter(fraction);
                        //add it to fractionCounterArrayList
                        fractionCounterArrayList.add(fractionCounter);
                    }
                }
            }
            
            //checks all the fractions and prints the counts
            for (FractionCounter f : fractionCounterArrayList) {
                //uses the toString to print fractions
                System.out.println(f.toString());
            }
        }         
        //catch exceptions in try statement
        catch (IOException ioe) {
            //method used to print class name and line number where the exception occurred
            ioe.printStackTrace();
        }         
        //catch
        catch (Exception e){
            //method used to print class name and line number where the exception occurred
            e.printStackTrace();
        }        
        //closes the file
        //finally block 
        finally {
            //try catch statement
            try {
                //method used to close the stream
                fractionFile.close();
            } 
            catch (IOException e) {
                //method used to print class name and line number where the exception occurred
                e.printStackTrace(); 
            }
        }
    }
}
