import java.util.Scanner;

public class Benchmark2 {
	public static void main(String[] args) {
		
		String pattern = "abcde";
		String reverse = "edcba";
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Give me a whole number!");
		int number = keyboard.nextInt();
		if (number % 2 == 1) {
			System.out.println(reverse);
			
		} else {
			System.out.println(pattern);
		}
		keyboard.close();
	}
}
