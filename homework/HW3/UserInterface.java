import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The User interface class which contains the main method of the program and
 * allows the user to specify a file containing terms and search for desired
 * terms.
 * 
 * @version 10/6/2025
 * @author Owen Resnikoff
 */
public class UserInterface {

	/**
	 * Print a generic List<T> item, each element on a seperate line
	 * 
	 * @param <T>  The type contained in the list
	 * @param list The list to be printed line by line
	 */
	private static <T> void printList(List<T> list) {
		for (T o : list) {
			System.out.println(o);
		}
	}

	/**
	 * Get input from the user and try to use it for readTermsFromFile, this runs in
	 * a loop until a valid path is given or EOF is supplied.
	 * 
	 * @param autoComplete The AutoComplete object to be filled with terms
	 * @param inputScanner The Scanner reading from stdin
	 * @throws NoSuchElementException If the Scanner recieves an EOF it will throw
	 *                                and exception
	 */
	private static void queryPath(AutoComplete autoComplete, Scanner inputScanner) throws NoSuchElementException {
		String path = "";
		boolean validPath = false; // Have we found a valid path?
		while (!validPath) {
			try {
				System.out.print("Enter filename: ");
				path = inputScanner.nextLine(); // This will fail if there is no next line, i.e EOF supplied

				autoComplete.readTermsFromFile(path); // This will fail if the path can't be resolved to an existing
														// file
				validPath = true;
			} catch (FileNotFoundException e) {
				System.out.printf("Could not open file '%s'. Please try again.\n", path);
			}
		}
	}

	/**
	 * Prompt the user for a terms file and then continually for a term to be
	 * searched for until the user enters ".quit"
	 * 
	 * @param args Args from console, these do no impact the behavior of the program
	 */
	public static void main(String[] args) {
		AutoComplete auto = new AutoComplete();
		Scanner sc = new Scanner(System.in);
		try {
			queryPath(auto, sc);
		} catch (NoSuchElementException e) { // If the user supplies EOF
			sc.close();
			return; 
		}

		while (true) {
			System.out.print("> "); // Prefix input with >
			String command = "";

			try {
				command = sc.nextLine();
			} catch (NoSuchElementException e) { // Handle EOF case
				System.out.printf("\"%s\"\n", e.getMessage());
				sc.close();
				return;
			}

			if (command.equals(".quit")) // User supplies quit
				break;

			List<Term> terms = auto.getMatches(command); //query terms
			printList(terms);
			System.out.println(); //Line Break
		}

		sc.close();
	}
}
