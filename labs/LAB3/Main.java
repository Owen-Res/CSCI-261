public class Main {
	public static void printDelimiter() {
		final int LENGTH = 50;
		System.out.println("-".repeat(LENGTH));
	}

	public static void main(String[] args) {
		Library lib = new Library();

		// add some books
		lib.addBook(new CirculatingBook("Anthony Burgess",
				"A Clockwork Orange",
				"978-0393312836", "DR.00.G5"));

		lib.addBook(new ReferenceBook("Samuel A. Rebelsky",
				"Experiments in Java",
				"0201612674", "64.2 R25ex", "Iowa Room"));

		// some users check out and return books
		lib.checkout("Donald Duck", "March 1, 2012", "DR.00.G5"); // This succeeds
		lib.checkout("Donald Duck", "March 12, 2012", "64.2 R25ex"); // This fails
		printDelimiter();

		lib.returned("DR.00.G5"); // This succeeds
		lib.returned("64.2 R25ex"); // This fails
		printDelimiter();

		lib.checkout("Goofy", "March 28, 2012", "DR.00.G5"); // This succeeds

		// print final status of library
		lib.printLibrary();

		lib.organize();
		printDelimiter();

		lib.printLibrary();
	}
}