import java.util.Random;

/**
 * The Die class models a die (the kind you roll). An instance
 * of the class can be constructed to represent a die with any
 * number of sides. A single, static random-number generator is
 * created to service all Die instances.
 * 
 * @author Brad Richards
 */

public class BasicDie {

    private int numSides; // How many sides?
    private static Random gen = new Random(); // The static Random generator
    protected int numRolls; // Rolled how many times?

    /**
     * No-argument constructor builds a six-sided die.
     */
    public BasicDie() {
        numSides = 6;
    }

    /**
     * This constructor takes the number of sides as a parameter.
     * 
     * @param numSides The desired number of sides on the die.
     * @throws InvalidDiceException if numsides is < 1
     */
    public BasicDie(int numSides) throws InvalidDiceException {
        if (numSides < 1) {
            throw new InvalidDiceException("Invalid # of sides (" + numSides + ")");
        }
        this.numSides = numSides; // Copy parameter value to instance var
        numRolls = 0; // No rolls yet
    }

    /**
     * The roll() method increments the number of rolls, then returns a
     * random value in the proper range.
     *
     * @return A random value between 1 and numSides.
     */
    public int roll() {
        numRolls++;
        return gen.nextInt(numSides) + 1; // numSides possible values, 1..N
    }

    /**
     * Returns the number of sides on this die.
     *
     * @return The number of sides on this die.
     */
    public int getNumSides() {
        return numSides;
    }

    /**
     * Overrides the toString() method in class Object to do something
     * Die-specific.
     *
     * @return A string describing how many sides the die has, and how
     *         many times it has rolled.
     */
    public String toString() {
        return "Die has " + numSides + " sides and " +
                "has rolled " + numRolls + " times";
    }
}