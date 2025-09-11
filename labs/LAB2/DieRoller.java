/**
 * The DieRoller class provides a polymorphic method for rolling a die
 * instance many times.
 * 
 * @author Brad Richards
 */

public class DieRoller {
    /**
     * rollRepeatedly takes a die and the number of times it should be rolled,
     * rolls it the specified number of times, and returns the sum of all of
     * the rolls.
     * 
     * @param die  A die object
     * @param n    The number of times to roll the die
     * @return     The sum of the rolled values
     */
    public int rollRepeatedly(BasicDie die, int n) {
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += die.roll();
        }

        if (die instanceof HistoryDie){
            ((HistoryDie)die).printHistory();
        }
        
        return total;
    }
}