/**
 * The Term class which encapsulates a Term's frequency and String
 * representation.
 * 
 * @version 10/6/2025
 * @author Owen Resnikoff
 */
public class Term implements Comparable<Term> {
    private long frequency;
    private String termText;

    /**
     * Initialize Term object with a given frequence a term String.
     * 
     * @param frequency The term's frequency
     * @param term      The term as a String
     */
    public Term(long frequency, String term) {
        this.frequency = frequency;
        this.termText = term;
    }

    /**
     * Getter for the frequency.
     * 
     * @return The Term's Frequency.
     */
    public long getFrequency() {
        return frequency;
    }

    /**
     * Getter for the Term's text.
     * 
     * @return The Term's text.
     */
    public String getTerm() {
        return termText;
    }

    @Override
    /**
     * Compare this term to another term object, equivalent to:
     * this.getTerm().compareTo(other.getTerm()).
     * 
     * @param other The Term to compare this to
     * @return The comparison between the text of this term and the text of the
     *         other term
     */
    public int compareTo(Term other) {
        return termText.compareTo(other.termText);
    }

    @Override
    /**
     * Return the string representation of this object in the form: frequency term
     * "%d \t %s"
     * 
     * @return The string representation of this object.
     */
    public String toString() {
        return String.format("%d \t %s", frequency, termText);
    }
}
