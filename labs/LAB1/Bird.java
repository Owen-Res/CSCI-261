/**
 * The Bird class containing the bird's name, the bird's quote and the number of
 * eggs it has produced
 * 
 * @author Owen Resnikoff
 * @version 9/3/2025
 */
public class Bird extends Animal{
    private static final String DEFAULT_BIRD_NAME = "Fowl";
    private static final String DEFAULT_BIRD_QUOTE = "Chirp.";

    private int eggsLaid = 0;

    /**
     * Initialize the cow with the default name "Fowl" and the default quote
     * "Chirp."
     */
    public Bird() {
        super(DEFAULT_BIRD_NAME, DEFAULT_BIRD_QUOTE);
    }
    
    public Bird(String name, String quote){
        super(name, quote);
    }

    /**
     * Display information about the bird in the format:
     * Name: name
     * Quote: "quote"
     * Eggs Laid: (eggs produced) eggs
     */
    @Override
    public void display() {
        super.display();
        System.out.printf("Eggs Laid: %d eggs\n", eggsLaid);
    }

    /**
     * Calls the Bird.squawk() function and increases the eggs laid by 1
     */
    public void layEgg() {
        speak();
        eggsLaid++;
    }
}
