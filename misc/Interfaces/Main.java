public class Main {

	public static void main(String[] args) {
		TV t = new TV();
		Store st = new Store();
		st.addItem(t);

		st.addItem(t);

		st.addItem(t);
		System.out.println(st);
	}
}
