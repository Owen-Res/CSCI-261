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
    private ArrayList<Animal> allAnimals;

    /**
     * initialize the farm, instantiating the underlying data
     */
    public Farm() {
        allAnimals = new ArrayList<Animal>();
    }

    /**
     * Add a animal to the list of cows on the farm
     * 
     * @param animal the Animal object to be added to the farm
     */
    public void addAnimal(Animal animal) {
        allAnimals.add(animal);
    }
    /**
     * Excite all the cows on the farm, causing them to moo
     */
    public void exciteAll() {
        for(Animal a : allAnimals){
            a.speak();
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

        for (int n = 0; n < allAnimals.size(); n++) {
            Animal a = allAnimals.get(n); // get the Animal at index n
            System.out.printf("#%d\n", n + 1);
            a.display();

            // add trailing new line on all entrys except for the last one
            if (n < allAnimals.size() - 1)
                System.out.println();
        }
    }

}
