/**
 * HistoryDie is a subclass of the BasicDie.  It works exactly the
 * same way, but stores information about how many times each possible
 * value has been rolled.
 * 
 * @author Brad Richards
 */

public class HistoryDie extends BasicDie {
    protected int[] history;             // Keep "history" in this array
    
    /**
     * Our one-argument constructor explicitly calls the one-argument
     * constructor in the parent class.  Once that constructor has
     * run to completion, we create our history array.
     * 
     * @param numSides  The desired number of sides on the die.
     */
    public HistoryDie(int numSides) throws InvalidDiceException{
        super(numSides);
        history = new int[numSides-1];     // Create array once we know # sides
    }
    
    /**
     * We invoke the BasicDie's roll method to get a random roll value,
     * update our history array, then return the value.
     *
     * @return  A random value between 1 and numSides.
     */ 
    public int roll() {
        int rollValue = super.roll();    // Do a standard roll, save result
        history[rollValue-1]++;          // Update the history
        return rollValue;
    }   
}