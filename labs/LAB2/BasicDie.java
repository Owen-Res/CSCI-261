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
    // if this is commented out along with the History die call to super(...) the
    // code will fail to compile, because this class will not be constructed though
    // it needs to be
    public BasicDie() {
        this.numSides = 6;
        this.numRolls = 0;

        System.out.println("Inside BasicDie 0-arg constructor!");
    }

    /**
     * This constructor takes the number of sides as a parameter.
     *
     * @param numSides The desired number of sides on the die.
     */
    public BasicDie(int numSides) {
        this.numSides = numSides; // Copy parameter value to instance var
        this.numRolls = 0; // No rolls yet
        System.out.println("Inside BasicDie 1-arg constructor!");
    }

    /**
     * The roll() method increments the number of rolls, then returns a
     * random value in the proper range.
     *
     * @return A random value between 1 and numSides.
     */
    public int roll() {
        this.numRolls++;
        return this.gen.nextInt(this.numSides) + 1; // numSides possible values, 1..N
    }

    /**
     * Returns the number of sides on this die.
     *
     * @return The number of sides on this die.
     */
    public int getNumSides() {
        return this.numSides;
    }

    public int getNumRolls() {
        return numRolls;
    }

    /**
     * Overrides the toString() method in class Object to do something
     * Die-specific.
     *
     * @return A string describing how many sides the die has, and how
     *         many times it has rolled.
     */
    public String toString() {
        return "Die has " + this.numSides + " sides and " +
                "has rolled " + this.numRolls + " times";
    }
}
