/**
 * HistoryDie is a subclass of the BasicDie. It works exactly the
 * same way, but stores information about how many times each possible
 * value has been rolled.
 * 
 * @author Brad Richards
 */

public class HistoryDie extends BasicDie {
    protected int[] history; // Keep "history" in this array

    /**
     * Our one-argument constructor explicitly calls the one-argument
     * constructor in the parent class. Once that constructor has
     * run to completion, we create our history array.
     * 
     * @param numSides The desired number of sides on the die.
     */
    public HistoryDie(int numSides) {
        super(numSides); // If i were to comment this out, my history die would be 6 sided no matter what
                         // because BasicDie() will be called
        this.history = new int[numSides]; // Create array once we know # sides
        System.out.println("Inside HistoryDie 1-arg constructor!");
    }

    public HistoryDie() {
        //implicit call to super()
        this.history = new int[getNumSides()]; // Create array once we know # sides
        System.out.println("Inside HistoryDie 0-arg constructor!");
    }

    /**
     * We invoke the BasicDie's roll method to get a random roll value,
     * update our history array, then return the value.
     *
     * @return A random value between 1 and numSides.
     */
    public int roll() {
        int rollValue = super.roll(); // Do a standard roll, save result
        recordHistory(rollValue);
        return rollValue;
    }

    /**
     * Record the history of the 
     * @param rollValue
    */
    protected void recordHistory(int rollValue) {
        // ignore value if it is outside of the appropriate range
        if (rollValue > getNumSides() || rollValue <= 0)
            return;
        this.history[rollValue - 1]++;
    }

    public void printHistory() {
        for (int n = 0; n < getNumSides(); n++) {
            System.out.printf("%d: %d\n", n + 1, history[n]);
        }
    }
}