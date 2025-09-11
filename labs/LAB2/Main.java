public class Main {

	public static void testHistoryDie() {
		DieRoller roller = new DieRoller();
		HistoryDie history = new HistoryDie(6);
		roller.rollRepeatedly(history, 10);

		history.printHistory();
	}

	public static void testBasicDie() {
		BasicDie basic = new BasicDie(6);
		System.out.println(basic.getNumRolls());
	}

	public static void testCrookedDie() {
		CrookedDie crooked = new CrookedDie(6);
		for (int i = 0; i < 10; i++) {
			if (i % 3 == 0)
				System.out.printf("Time to Lie, should be: %d\ngot:", crooked.getNumSides());
			System.out.println(crooked.roll());
		}

		crooked.printHistory();
	}

	public static void testConstructorPrints() {
		BasicDie basic = new BasicDie();
		System.out.println("--------------------------");
		CrookedDie crooked = new CrookedDie(6);
		System.out.println("--------------------------");
		HistoryDie history = new HistoryDie(6);
	}

	/**
	 * Ensure that all the dice classes properly initialize themselves with the
	 * 0-arg constructor
	 */
	public static void testDefaultConstructorPrints() {
		BasicDie basic = new BasicDie();
		System.out.println(basic.getNumSides());

		System.out.println("--------------------------");

		CrookedDie crooked = new CrookedDie();
		System.out.println(crooked.getNumSides());

		System.out.println("--------------------------");

		HistoryDie history = new HistoryDie();
		System.out.println(history.getNumSides());
	}

	// in part3 we are instructed to implement a main function, this is that
	public static void part3Main() {
		BasicDie basic;
		HistoryDie history;
		CrookedDie crooked;

		// is everything working?
		basic = new BasicDie(6);
		System.out.println(basic.roll());
		System.out.println(basic.roll());
		System.out.println(basic.toString());

		basic = new HistoryDie(6);
		basic.roll();
		// basic.printHistory(); doesn't work
		((HistoryDie) basic).printHistory(); // this works :)

		basic = new CrookedDie(6);
		basic.roll(); // Will output 6
		((HistoryDie) basic).printHistory(); // this works :)
		System.out.println();
		((CrookedDie) basic).printHistory(); // this works too! :)

		history = new CrookedDie(6);
		history.roll(); // Will output 6 (dynamic dispatch)

		/**
		 * # Emergent Pattern
		 * 
		 * When we instantiate a class with one of its subclasses we can not call
		 * subclass variables on that function unless we downcast. Some functions like
		 * roll() will have different behavior depending on the subclass they have been
		 * instantiated with regardless of the type of the variable containing it.
		 */
	}

	public static void testDieRoller() {
		DieRoller roller = new DieRoller();
		// this will not compile if rollRepeatedly expects a HistoryDie or CrookedDie
		System.out.println(roller.rollRepeatedly(new BasicDie(6), 100));

		// this will not compile if rollRepeatedly expects a CrookedDie
		System.out.println(roller.rollRepeatedly(new HistoryDie(6), 100)); // this works

		System.out.println(roller.rollRepeatedly(new CrookedDie(6), 100)); // this also works

		CrookedDie cd = new CrookedDie();
		/**
		 * # Emergent Pattern
		 * 
		 * rollRepeatedly can only accept type that are equal to or inherit from the
		 * type of the argument
		 */
	}

	public static void main(String[] args) {
		/** Uncomment to test various functionality */

		// testHistoryDie();
		// testBasicDie();
		// testCrookedDie();
		// testConstructorPrints();
		// testDefaultConstructorPrints();
		// part3Main();
		// testDieRoller();
	}
}
