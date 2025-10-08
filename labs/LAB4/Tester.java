import java.util.LinkedList;

/**
 * This class creates a HistoryDie instance and exercises it a bit.
 * 
 * @author Brad Richards
 */
public class Tester {
    public static final int NUM_ROLLS = 1000;
    public static final int LIMIT = 100;

    public static void main(String[] args) {

        int result = 0;

        try {
            // Risky: This code could cause an exception!
            HistoryDie d = new HistoryDie(6);

            result = DieRoller.rollRepeatedly(d, NUM_ROLLS);
            System.out.println("In " + NUM_ROLLS + " rolls, total was " + result);
            result = DieRoller.rollUntil(d, LIMIT);
            System.out.println("Took " + result + " rolls to break " + LIMIT);

            // LinkedList<T> implements the List interface and thus is accepted by
            // DieRoller.rollAll
            LinkedList<BasicDie> ll = new LinkedList<>();
            ll.add(d);
            ll.add(new CrookedDie(7));
            DieRoller.rollAll(ll);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException | InvalidDiceException e) {
            // What to do if the risky code does throw an exception:
            System.out.println("I just caught " + e);
        } finally {
            System.out.println("Finally reached!");
        }

        System.out.println("Do I print?");
    }
}
