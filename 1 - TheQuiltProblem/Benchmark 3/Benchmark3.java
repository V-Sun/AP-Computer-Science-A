import java.util.Scanner;

public class Benchmark3 {
	public static void main(String[] args) {
		
		
		String pattern = "x ";
		String reverse = "o ";
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How wide should the quilt be?");
		int width = keyboard.nextInt();
		System.out.println("How long should the quilt be?");
		int length = keyboard.nextInt();
		for(int i = 0; i < width; i++) {
			System.out.println();
			for(int x = 0; x < length; x++) {
				if((x + i) % 2 == 0) {
					System.out.print(pattern);
				} else {
					System.out.print(reverse);
				}

				
			}
		}
		keyboard.close();
	}
}
