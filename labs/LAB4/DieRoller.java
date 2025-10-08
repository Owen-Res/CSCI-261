import java.util.List;

/**
 * The DieRoller class provides several polymorphic methods for working with Die
 * objects or collections of them. The methods are all static now.
 * 
 * @author Brad Richards
 */

public class DieRoller {
    /**
     * rollRepeatedly takes a die and the number of times it should be rolled,
     * rolls it the specified number of times, and returns the sum of all of
     * the rolls.
     * 
     * @param die A die object
     * @param n   The number of times to roll the die
     * @return The sum of the rolled values
     */
    public static int rollRepeatedly(BasicDie die, int n) {
        int total = 0;
        int totalExceptions = 0;
        for (int i = 0; i < n; i++) {
            try {
                total = total + die.roll();
            } catch (IndexOutOfBoundsException e) {
                return total;
            }
        }

        System.out.println(totalExceptions);
        return total;
    }

    /**
     * rollUntil is similar to rollRepeatedly, but it only rolls the die until
     * the total value rolled exceeds limit.
     * 
     * @param die   A die object
     * @param limit Roll die until the total exceeds this value
     * @return The number of rolls required to reach limit
     */
    public static int rollUntil(BasicDie die, int limit) {
        /*
         * Computational steps:
         * Check Condition (total < limit) -> Calculate die.roll -> Increment Total by
         * die.roll -> Increment numRolls -> Jump to step 1
         * 
         * For different subclasses of BasicDie there are more steps internally in
         * die.roll, however they should take a constant number of steps for all of the
         * kinds of die (None of the die exhibit any looping behavior that is dependant on input)
         */
        int total = 0;
        int numRolls = 0;

        while (total < limit) {
            total = total + die.roll();
            numRolls++;
        }
        return numRolls;
    }

    /**
     * rollAll takes a list of die instances and rolls each of them once.
     * 
     * @param dice A list of die instances
     * @return The sum of each die's rolls
     */
    public static int rollAll(List<BasicDie> dice) {
        int total = 0;
        for (BasicDie d : dice) {
            total = total + d.roll();
        }
        return total;
    }

}