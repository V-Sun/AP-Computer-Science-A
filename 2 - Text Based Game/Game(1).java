import java.util.Scanner;

public class Game {
	
	public static void scene1() {
		System.out.println("Feed me and I'll live, give me something to drink and I die. What am I?");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		if (input.equalsIgnoreCase("fire")) {	
			System.out.println("Fire is correct, you will now move on!");
			scene2();
		} else {
			System.out.println("Wrong Answer! Try again!");
			scene1(); }
		}
	public static void scene2() {
		System.out.println("Welcome to room 2. There is an enemy. Do you want to"
				+ "\nA) Attack"
				+ "\nB) Defend");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		if (input.equalsIgnoreCase("A")) {
			System.out.println("You attacked and defeated the enemy!");
		} else if (input.equalsIgnoreCase("B")) {
			System.out.println("The enmy attacked but you didn't take much damage!");
			scene2();
		} else {
			System.out.println("I don't understand what you're trying to say!");
			scene2();
		}
	}
	public static void main(String args[]) {
		scene1();
		
	}
}
