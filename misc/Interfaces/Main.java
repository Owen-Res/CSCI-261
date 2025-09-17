public class Main {

	public static void main(String[] args) {
		TV t = new TV();
		UniversalRemote remote = new UniversalRemote(t);
		for (int i = 0; i < 10; i++)
			remote.pressUp();

		System.out.println(remote);

		remote.pressUp();
		System.out.println(remote);

		remote.switchDevice(new Radio());
		System.out.printf("%s\n", "-".repeat(35));
		for (int i = 0; i < 10; i++)
			remote.pressUp();

		System.out.println(remote);

		remote.pressUp();
		System.out.println(remote);
	}
}
