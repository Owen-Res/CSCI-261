/**
 * CrookedDie is a subclass of the HistoryDie that lies periodically
 * and returns the die's max value instead of a random roll.
 * 
 * @author Brad Richards
 */
public class CrookedDie extends HistoryDie {
    // We lie every N rolls.  Best to make it a constant
    private static final int LIE_FREQUENCY = 3;
    
    /**
     * The constructor doesn't do anything, other than call the
     * one-argument constructor in our parent class.
     */
    public CrookedDie(int numSides) {
        super(numSides);
        System.out.println("Inside CrookedDie 1-arg constructor!");
    }
    
    public CrookedDie(){
        //implicit call to super()
        System.out.println("Inside CrookedDie 0-arg constructor!");
    }

    /** 
     * A crooked version of roll().  It calls the roll() method in
     * the parent class to get a random value (and update the history),
     * but sometimes ignores that value and returns numSides instead.
     *
     * @return  A value between 1 and numSides.
     */
    public int roll() {
        if (numRolls % CrookedDie.LIE_FREQUENCY == 0) { // Time to lie?
            int nefariousRoll = this.getNumSides();
            numRolls++;
            recordHistory(nefariousRoll);
            return nefariousRoll;
        }
        else {
            return super.roll();
        }
    }
}