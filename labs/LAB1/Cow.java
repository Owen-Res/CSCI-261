import java.text.DecimalFormat;

/**
 * The Cow class which contains the Cow's name, its quote and the gallons of
 * milk it has produced
 * 
 * @author Owen Resnikoff
 * @version 9/4/2025
 */
public class Cow {
    private static final String DEFAULT_COW_NAME = "Bessie";
    private static final String DEFAULT_COW_QUOTE = "Moo.";

    private String name; // Stores cows name
    private String quote; // Stores what the cow utters
    private double gallonsProduced = 0.0; // The amount of milk the cow has produced

    /**
     * Initialize the cow with a specified name and utterance
     * 
     * @param cowName   The cow's name
     * @param utterance What the cow should say
     */
    public Cow(String cowName, String utterance) {
        this.name = cowName;
        this.quote = utterance;
    }

    /**
     * Initialize the cow with the default name "Bessie" and the default quote
     * "Moo."
     */
    public Cow() {
        this(DEFAULT_COW_NAME, DEFAULT_COW_QUOTE);
    }

    /**
     * Getter for the cow's name
     * 
     * @return the private variable name
     */
    public String getName() {
        return name;
    }

    /**
     * Prints name: "quote" to the standard output ending in a newline
     */
    public void moo() {
        System.out.printf("%s: \"%s\"\n", name, quote);
    }

    /**
     * Display information about the cow in the format:
     * Name: name
     * Quote: "quote"
     * Gallons produced: (gallons produced) gallons
     */
    public void display() {
        final DecimalFormat GALLON_DECIMAL_FORMAT = new DecimalFormat("0.0");
        System.out.printf("Name: %s\n", name);
        System.out.printf("Quote: \"%s\"\n", quote);
        System.out.printf("Gallons produced: %s gallons\n", GALLON_DECIMAL_FORMAT.format(gallonsProduced));
    }

    /**
     * Milk the cow, producing a call to Cow.moo() and increasing the
     * gallonsProduced by 0.5
     */
    public void milk() {
        moo();
        gallonsProduced += .5;
    }
}
