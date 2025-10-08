import java.util.Random;
import java.util.Arrays;

/**
 * <<Do not edit>>
 */

public abstract class AbstractRuntimeTester
{
    protected int[] list;
    protected long numStatements;

    /**
     * Constructs an array of the given size of random integers
     * @param size Length of the list
     */
    public AbstractRuntimeTester(int size) {
        if (size <= 0) { //illegal size entered; default to a size-10 list
            size = 10;
        }
        list = new int[size];
    }

    /** 
     * Gets the number of statements
     * @return number of statements made
     */
    public long getStatements() {
        return this.numStatements;
    }

    /**
     * Resets the number of statements to 0
     */
    public void resetStatements() {
        this.numStatements = 0;
    }

    /**
     * Gets the size of the list
     * @return size of the list
     */
    public int getListSize() {
        return list.length;
    }

    /**
     * Fills list with numbers from 0 to size-1 (ordered)
     */
    public void generateData(boolean ordered) {
        //fill the array with numbers from 1 to size
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        if (!ordered) {
            shuffle();
        }
    }

    /**
     * This "shuffles" the elements around in the list
     * Like shuffling a deck of cards
     */
    public void shuffle() {
        Random randGen = new Random();

        //for each element, list[i] in the loop,
        for (int i = 0; i < list.length; i++) {
            //  generate a random index j with a range from i to list.length (not inclusive)
            int j = randGen.nextInt(list.length - i) + i;

            //  swap list[i] with list[j]
            int tmp = list[i];
            list[i] = list[j];
            list[j] = tmp;
        }
    }
    
    /** @return The string representing the stored list */
    @Override
    public String toString() {
        return Arrays.toString(this.list);
    }    
    
    /**
     * Abstract methods below need to be implemented by your extending class.
     */
    
    public abstract double stdDev();
    public abstract int median();
    public abstract int linearSearch(int key);
    public abstract int binarySearch(int key);
}