import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The AutoComplete class which provide the ability to read a list of terms in
 * the form "Frequency Term" from a file and said terms may be used to query the
 * most freuent terms starting with a prefix.
 * 
 * @version 10/6/2025
 * @author Owen Resnikoff
 */
public class AutoComplete {
    private ArrayList<Term> terms;

    // The comparator by which we may sort terms by frequency, this is defined as an
    // anonymous class such that is may be static and final
    private static final Comparator<Term> frequencyComparator = new Comparator<Term>() {
        @Override
        /**
         * Compare the Terms t1 and t2 by their frequency
         * 
         * @param t1 The first term
         * @param t2 The second term
         * @return >1 if t2.frequency() > t1.frequency()
         *         <1 if t1.frequency() > t2.frequency()
         *         =0 if t2.frequency() == t1.frequency()
         */
        public int compare(Term t1, Term t2) {
            // Because we return an integer here we need to be sure to clamp this value to
            // the int32 bounds
            return Math.clamp(t2.getFrequency() - t1.getFrequency(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    };

    /**
     * Consume a single line from the frequency file, expecting the format Frequency
     * Term (%l, %s)
     * 
     * @param tokens The given line split into "tokens", which is to say split by
     *               whitespace
     * @throws IndexOutOfBoundsException This will be thrown if only 1 token is
     *                                   given, this function expects 2
     * @throws NumberFormatException     This will be thrown if the Frequency can't
     *                                   be parsed into a long, i.e it is non
     *                                   numeric
     */
    private void consumeLine(String[] tokens) throws IndexOutOfBoundsException, NumberFormatException {

        long frequency = Long.parseLong(tokens[0]);
        String termText = tokens[1]; // no bounds checks, we are ok with the fact that we may throw and exception

        terms.add(new Term(frequency, termText));
    }

    /**
     * Constructor initializing the internal structures
     */
    public AutoComplete() {
        terms = new ArrayList<Term>();
    }

    /**
     * Take a query and try to find the most frequent term that is prefixed with the
     * query, for multiword queries only the last word is used in the search.
     * 
     * @param query The term to be searched for as a prefix
     * @return A list containing the 10 most frequent terms beggining with query,
     *         sorted in descending order
     */
    public List<Term> getMatches(String query) {
        ArrayList<Term> out = new ArrayList<Term>();

        // Clean up the query by converting it to lowercase and stripping the
        // leading/trailing whitespace
        query = query.toLowerCase();
        query = query.strip();

        // Split the query so we can pick the last word
        String[] words = query.split(" ");
        try {
            // This is done in a try block to avoid an uncaught exception
            query = words[words.length - 1];
        } catch (IndexOutOfBoundsException e) {
            return out;
        }

        // Find the index where either query appears or where query would appear if it
        // existed in the list
        int searchIndex = Collections.binarySearch(terms, new Term(0, query));
        if (searchIndex < 0)
            searchIndex = -searchIndex - 1; // (-(insertion point) - 1) if query doesn't exist in the list (according to
                                            // spec)

        // Loop through all terms prefixed with query and add them to the output list
        Term t = terms.get(searchIndex);
        while (t.getTerm().startsWith(query) && searchIndex < terms.size() - 1) {
            out.add(t);

            searchIndex++;
            t = terms.get(searchIndex);
        }

        // sort the output by frequency, descending order
        Collections.sort(out, frequencyComparator);
        return out.subList(0, Math.min(out.size(), 10)); // return at most first 10 items
    }

    /**
     * Read the terms from the file specified by path, any lines that break the
     * expected syntax will be reported but will not halt exexcution.
     * 
     * @param path The path of the file to read terms from
     * @throws FileNotFoundException Thrown if the file specified by path can not be
     *                               found
     */
    public void readTermsFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file); // May throw exception

        int linesRead = 1; // We report every 1000 lines so we need to keep track
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            try { // try to read line otherwise report errors
                consumeLine(tokens);
            } catch (NumberFormatException e2) {
                System.out.printf("Bad input on line %d - first token is not an integer: %s\n", linesRead, tokens[0]);
            } catch (IndexOutOfBoundsException e1) {
                System.out.printf("Bad input on line %d - expected two tokens: %s\n", linesRead, line);
            } finally { // line counting code is always run
                linesRead++;
                if (linesRead % 1000 == 0)
                    System.out.printf("Terms Processed: %d\n", linesRead);
            }
        }

        Collections.sort(terms); // Sort the list into alphabetic order such that we may access elements via binary search O(Log n)
        sc.close();
    }
}
