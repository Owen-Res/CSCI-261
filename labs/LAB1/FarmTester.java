public class FarmTester {
	public static void main(String[] args) {
		Farm farm = new Farm();
		farm.addCow(new Cow());
		farm.addBird(new Bird());
		farm.addBird(new Bird("Prailine", "Squawk"));
		farm.exciteAll();
		farm.summary();
	}
}
