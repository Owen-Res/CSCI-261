package OldImpl;
import java.util.ArrayList;

/**
 * The Farm class which holds all the cows and birds on a farm and provides
 * methods to
 * act on all of the cows and birds
 * 
 * @author Owen Resnikoff
 * @version 9/4/2025
 */
public class Farm {
    private ArrayList<Cow> allCows;
    private ArrayList<Bird> allBirds;

    /**
     * initialize the farm, instantiating the underlying data
     */
    public Farm() {
        allCows = new ArrayList<Cow>();
        allBirds = new ArrayList<Bird>();
    }

    /**
     * Add a cow to the list of cows on the farm
     * 
     * @param cow the Cow object to be added to the farm
     */
    public void addCow(Cow cow) {
        allCows.add(cow);
    }

    /**
     * Add a bird to the list of birds on the farm
     * 
     * @param bird
     */
    public void addBird(Bird bird) {
        allBirds.add(bird);
    }

    /**
     * Excite all the cows on the farm, causing them to moo
     */
    public void exciteAll() {
        for (Cow c : allCows) {
            c.moo();
        }

        for (Bird b : allBirds) {
            b.squawk();
        }
    }

    /**
     * Prints a summary of all the cows and birds on the farm including their index
     * and the
     * data that is displayed
     * when the method Cow.display() is called followed by the data for when
     * Bird.display() is called
     */
    public void summary() {
        System.out.println("-------------");
        System.out.println("Farm Summary");
        System.out.println("-------------");

        for (int n = 0; n < allCows.size(); n++) {
            Cow c = allCows.get(n); // get the cow at index n
            System.out.printf("# %d\n", n + 1);// prints #(n+1)
            c.display();
            System.out.println();// produce a newline for purely stylistic purpose
        }

        for (int n2 = 0; n2 < allBirds.size(); n2++) {
            Bird b = allBirds.get(n2); // get the bird at index n2
            System.out.printf("#%d\n", allCows.size() + n2 + 1);// prints the same thing as in the loop over cows,
                                                                // continuing from allCows.size()
            b.display();

            // add trailing new line on all entrys except for the last one
            if (n2 < allBirds.size() - 1)
                System.out.println();
        }
    }

}
