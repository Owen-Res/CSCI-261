import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static int divide(int a, int b) throws ArithmeticException{
		if(a == 5)
			throw new RuntimeException("No 5s allowed");

		return a / b;
	}

	public static void main(String[] args) {
		System.out.println(divide(1, 5));
		
		Scanner sc = new Scanner(System.in);

		int number = 0;
		boolean numberFound = false;
		while(!numberFound){
			try{
				number = sc.nextInt();
				numberFound = true;
			} catch (InputMismatchException e){
				System.out.printf("Invalid Input, expected number, got: \"%s\"\n", sc.nextLine());
				continue;
			}
		}
		System.out.println(number);
		sc.close();
	}
}
