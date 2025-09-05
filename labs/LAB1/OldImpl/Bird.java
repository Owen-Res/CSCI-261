package OldImpl;
/**
 * The Bird class containing the bird's name, the bird's quote and the number of
 * eggs it has produced
 * 
 * @author Owen Resnikoff
 * @version 9/3/2025
 */
public class Bird {
    private static final String DEFAULT_BIRD_NAME = "Fowl";
    private static final String DEFAULT_BIRD_QUOTE = "Chirp.";

    private String name; // The name of the bird
    private String quote; // The quote that the bird will say on calls to squalk
    private int eggsLaid = 0;

    /**
     * Initialize the bird with a specified name and utterance
     * 
     * @param birdName  The bird's name
     * @param utterance What the cow should say
     */
    public Bird(String birdName, String utterance) {
        name = birdName;
        quote = utterance;
    }

    /**
     * Initialize the cow with the default name "Fowl" and the default quote
     * "Chirp."
     */
    public Bird() {
        this(DEFAULT_BIRD_NAME, DEFAULT_BIRD_QUOTE);
    }

    /**
     * Getter for the bird's name
     * 
     * @return the private variable name
     */
    public String getName() {
        return name;
    }

    /**
     * Prints name: "quote" to the standard output ending in a newline
     */
    public void squawk() {
        System.out.printf("%s: \"%s\"\n", name, quote);
    }

    /**
     * Display information about the bird in the format:
     * Name: name
     * Quote: "quote"
     * Eggs Laid: (eggs produced) eggs
     */
    public void display() {
        System.out.printf("Name: %s\n", name);
        System.out.printf("Quote: \"%s\"\n", quote);
        System.out.printf("Eggs Laid: %d eggs\n", eggsLaid);
    }

    /**
     * Calls the Bird.squawk() function and increases the eggs laid by 1
     */
    public void layEgg() {
        squawk();
        eggsLaid++;
    }
}
