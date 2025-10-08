import java.util.Random;

/**
 * A class that runs performance experiments.
 * 
 * <<Please do not edit the methods>>
 * 
 * @author David Chiu and America Chambers
 * @version 10/1/2024
 */
public class Expr
{
    private static final int NUM_RUNS = 5000;  // << change this later>>

    public static void testLinearSearch(int N, boolean orderedList) {
        runTest(N, orderedList, OP.LINSEARCH, 1, N, (long) Math.ceil(N/2.0));
    }

    public static void testBinarySearch(int N) {
        runTest(N, true, OP.BINSEARCH, 1, (long) Math.ceil(Math.log(N)/Math.log(2)), -1);
    }

    public static void testMedian(int N, boolean orderedList) {
        runTest(N, orderedList, OP.MEDIAN, -1, -1, -1);
    }

    public static void testStdDev(int N) {
        runTest(N, true, OP.STDDEV, 2*N, 2*N, 2*N);
    }

    private static void runTest(final int N, boolean ordered, OP operation, long expBest, long expWorst, long expAvg) {
        Random rng = new Random();

        //max, min, and average number of comparisons
        long maxComps = Long.MIN_VALUE;
        long minComps = Long.MAX_VALUE;
        long totalComps = 0;

        //create a RuntimeTester and generate ordered data
        RuntimeTester s = new RuntimeTester(N);
        s.generateData(ordered);

        //inner loop to run trials
        for (int trial = 0; trial < NUM_RUNS; trial++) {
            s.resetStatements();               //reset comparison count

            if (operation == OP.BINSEARCH) {
                s.binarySearch(rng.nextInt(N));                
            } else if (operation == OP.LINSEARCH) {
                s.linearSearch(rng.nextInt(N)); 
            } else if (operation == OP.STDDEV) {
                s.stdDev();
            } else if (operation == OP.MEDIAN) {
                s.generateData(ordered);
                s.median();
            } 

            //retrieve number of statements
            long numComps = s.getStatements();

            //update max, min, total
            if (numComps > maxComps) {
                maxComps = numComps;
            }
            if (numComps < minComps) {
                minComps = numComps;
            }
            totalComps += numComps;
        }
        System.out.println(operation);
        System.out.println("n=" + N + ", " 
            + "best=" + minComps + ((expBest != -1) ? " (expected " + expBest + "), " : " ")
            + "worst=" + maxComps + ((expWorst != -1) ? " (expected " + expWorst + "), " : " ")
            + "avg=" + (long) ((double)totalComps/NUM_RUNS) + 
            ((expAvg != -1) ? " (expected " + expAvg + ")" : ""));        
    }

    private static enum OP {
        MEDIAN, LINSEARCH, BINSEARCH, STDDEV
    }
}