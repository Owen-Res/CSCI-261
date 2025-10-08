import java.util.Random;
import java.util.Arrays;

public class RuntimeTester extends AbstractRuntimeTester {
    /**
     * Creates a runtime tester with a list of the given length.
     */
    public RuntimeTester(int N) {
        super(N);
    }

    /**
     * Runs linear search for the key
     * 
     * @return index of first occurrence of key, or -1 if not found
     */
    @Override
    public int linearSearch(int key) {
        this.numStatements = 0;
        // loop through the list from beginning to end
        for (int idx = 0; idx < list.length; idx++) {
            this.numStatements++;
            if (key == list[idx]) {
                return idx; // found the key! return the index and stop!
            }
        }
        // didn't find the key! return -1
        return -1;
    }

    /**
     * Runs binary search for the key
     * 
     * @return index of first occurrence of key, or -1 if not found
     */
    @Override
    public int binarySearch(int key) {
        this.numStatements = 0;
        int startIdx = 0, endIdx = list.length - 1;
        while (startIdx <= endIdx) {
            this.numStatements++;
            int midIdx = (startIdx + endIdx) / 2; // find mid-point
            if (key == list[midIdx]) {
                return midIdx; // found the key! return the index and stop!
            } else if (key > list[midIdx]) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx - 1;
            }
        }
        return -1; // didn't find the key! return -1
    }

    /**
     * Finds the median value in a list (can be unsorted or sorted)
     * This method assumes there are NO duplicates in the list
     * 
     * @return the median value of the list
     */
    @Override
    public int median() {
        this.numStatements = 0;
        for (int i = 0; i < list.length; i++) {
            int lessThan = 0; // counts how many numbers are less than list[i]
            int grtThan = 0; // counts how many numbers are greater than list[i]

            for (int j = 0; j < list.length; j++) {
                this.numStatements++;
                if (list[j] < list[i]) {
                    lessThan++;
                } else if (list[j] > list[i]) {
                    grtThan++;
                }
            }

            // If the list has odd length...
            if (list.length % 2 == 1 && lessThan == grtThan) {
                return list[i];
            }
            // If the list has even length...
            else if (list.length % 2 == 0 && lessThan == grtThan - 1) {
                return list[i];
            }
        }
        // code should never reach here, because a median always exists
        return -1;
    }

    public double average() {
        double avg = 0.;
        for (int i : list) {
            avg += i;
            this.numStatements++;
        }

        this.numStatements++;
        return avg / list.length;
    }

    /**
     * The standard deviation measures the average distance from the mean
     * 
     * @return the standard deviation for the given list
     */
    @Override
    public double stdDev() {
        double n = list.length;
        double squaredDistanceSum = 0.;
        double avg = average();

        for (int i = 0; i < n; i++) {
            squaredDistanceSum += Math.pow(list[i] - avg, 2);
            this.numStatements++;
        }

        this.numStatements++;
        return Math.sqrt((1.0 / n) * squaredDistanceSum);
    }
}