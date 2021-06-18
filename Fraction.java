/**
 * This class should be a simple abstraction (i.e., a small class) that represents 
 * the ratio of two numbers.
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called Fraction
public class Fraction{
    //numerator of Fraction
    private int numerator;
    //denominator of the fraction
    private int denominator;

    /**
     * default  “no-arg” constructor
     */
    public Fraction() {

    }

    /**
     * constructor which initializes your data given the numerator and denominator of 
     * the fraction as entered in (which may be different than how the fraction is 
     * stored)
     */
    public Fraction(int num, int denom) {
        //If fraction is negative then put negative number in numerator
        
        this.numerator = (denom < 0 ? -num : num);
        if (denom == 0){
            this.denominator = 1;
        }
        this.denominator = (denom < 0 ? - denom : denom);
        
        //call the reduceFraction method
        reduceFraction();
    }

    /**
     * Method equals
     *
     * @param other A parameter
     * @return The return value
     */
    public boolean equals(Fraction other) {
        //check if input is null
        if(other == null){
            //return false
            return false;
        }
        //check if the inout is not an instance of Fraction class
        if(!(other instanceof Fraction)){
            //return false
            return false;
        }
        
        //casting to Fraction object
        Fraction that = (Fraction) other;
        
        //casting to double
        double thisFraction = (double)this.numerator / this.denominator;
        double thatFraction = (double)that.numerator / that.denominator;
        
        //returns true if the numerators and the denominators are the same
        return thisFraction == thatFraction;
    }

    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString() {
        //return a formated fraction
        return this.numerator + "/" + this.denominator;
    }

    /**
     * Method getNumerator
     *
     * @return The return value
     */
    public int getNumerator(){
        //returns the numerator of the fraction
        return this.numerator;
    }

    /**
     * Method getDenominator
     *
     * @return The return value
     */
    public int getDenominator(){
        //returns the denominator of the fraction
        return this.denominator;
    }

    /**
     * Method setNumerator
     *
     * @param theNumeratorVariable A parameter
     */
    public void setNumerator(int theNumeratorVariable){
        //this.numerator is set to theNumeratorVariable
        this.numerator = theNumeratorVariable;
        //call the reduceFraction method
        reduceFraction();
    }

    /**
     * Method setDenominator- no zeros allowed in the denominator
     *
     * @param theDenominatorVariable A parameter
     */
    public void setDenominator(int theDenominatorVariable){
        // denominator is set to theDenominatorVariable if it is greater than 0
        if (theDenominatorVariable > 0){
            //denominator is set to the input
            this.denominator = theDenominatorVariable;
            //call reduce fraction
            reduceFraction();
        }
        //if denominator is negative change the numerator
        else if(theDenominatorVariable < 0){
            //set the numerator to a negatice number
            this.numerator = -this.numerator;
            //set the denominator to a negative number
            this.denominator = -theDenominatorVariable;
            //call the reduceFraction method
            reduceFraction();
        }
    }

    // public int setFraction(int n,int d){

    // }

    // public double setFraction(double, double){

    // }

    /**
     * Method reduceFraction
     *
     */
    public void reduceFraction(){
        //integer varirables n is set to the numerator
        int n = this.numerator;
        //integer d is set to denominator
        int d = this.denominator;
        //integer largest
        int largest;
        //integer greatestCommonDenominator aet to 0
        int greatestCommonDenominator = 0;

        //if the numerator is less than 0
        if (this.numerator < 0){
            //n is set to negative numerator
            n = -this.numerator;
        }
        
        //if n is greater than d
        if (n > d){
            //largest is set to n
            largest = n;
        }
        //else
        else{
            //largest is set to d
            largest = d;
        }

        //find the largest number that divides the numerator and denominator equally
        for (int i = largest; i >= 2; i--){
            //check if the remainder of the numerator and denominator of the fraction is 0
            if (this.numerator % i == 0 && this.denominator % i == 0){
                //greatest commondenominator is set to i
                greatestCommonDenominator = i;
                //break
                break;
            }
        }
        
        //if the greatestCommonDenominator is not 0
        if (greatestCommonDenominator != 0){
            //divide by the greatestCommonDenominator
            this.numerator /= greatestCommonDenominator;
            this.denominator /= greatestCommonDenominator;
        }
    }
}
