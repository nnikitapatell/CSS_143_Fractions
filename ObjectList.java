/**
 * Write a description of class ObjectList here.
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called ObjectList
public class ObjectList
{
    //numElements is a variable that counts and it starts at 0
    private int numElements = 0;
    //FractionCounter array nemed fractionList can hold 100 elements
    private FractionCounter[] fractionList = new FractionCounter[100];

    /**
     * Constructor for objects of class ObjectList that is the default "no-arg" constructor
     */
    public ObjectList(){

    }

    /**
     * Method addFraction: increments the numElements counter variable by one 
     *
     * @param theFractionCounter A parameter
     */
    public void addFraction (FractionCounter theFractionCounter){
        //set the elements of the array equal to the FractionCounter 
        //parameter theFractionCounter  and increment the numElements variable by one 
        fractionList[numElements++] = theFractionCounter;
    }

    /**
     * Method getValue: returns the value
     *
     * @param i A parameter
     * @return The return value
     */
    public FractionCounter getValue(int i){
        //returns the value and casts the value to FractionCounter Object
        return fractionList[i];
    }

    /**
     * Method length: return the value of how many elements are saved in the array
     *
     * @return The return value
     */
    public int length() {
        //returns the numElements
        return numElements; 
    }

    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString (){
        //retVal is a String variable
        String retVal = "";

        //itterate through the array
        for (int i =0; i < numElements; i++){ 
            //add the vale of the elements in the array to the string 
            retVal += fractionList[i] + "\n"; 
        }
        
        //return retVal
        return retVal; 
    }
}
