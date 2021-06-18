/**
 * Fraction counter compares and count the fractions
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class named FractionCounter
public class FractionCounter
{
    //declare  class variable to be of type Fraction 
    private Fraction fraction; 
    //the integer value used to count the number of these fractions seen
    private int count;

    /**
     * FractionCounter Constructor
     *
     */
    FractionCounter() {

    }

    /**
     * Constructor for objects of class FractionCounter
     */
    public FractionCounter(Fraction theFraction){
        //sets this.fraction to theFraction input
        this.fraction = theFraction;
        //this.count is initialized to 1
        this.count = 1;
    }

    /**
     * Method compareAndIncrement: used to see if the newFraction passed into this function 
     * is the same as the Fraction we’re storing, and if so increments the counter by one 
     * and returns true (otherwise, returns false).
     *
     * @param newFraction A parameter
     * @return The return value
     */
    public boolean compareAndIncrement( Fraction newFraction ) {
        //checks if the fraction is equal to the newFraction
        if(this.fraction.equals(newFraction)){
            //increment the count
            this.count++;
            //return true
            return true;
        }
        //otherwise
        else{
            //return false
            return false;
        }
    }

    /**
     * Method toString: prints out both the Fraction and its count
     *
     * @return The return value
     */
    public String toString() {
        //returns the fraction has a count of this.count
        return this.fraction + " has a count of " + this.count;
    }
}
