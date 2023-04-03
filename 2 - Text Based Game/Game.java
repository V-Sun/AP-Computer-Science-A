import java.util.Random;
import java.util.Scanner;

public class Game {
	public static String Name;
	public static int HP = 35;
	public static int maxHP = 50;
	public static int potion;
	static Random random = new Random();
	static Scanner keyboard = new Scanner(System.in);
	public static int damage = random.nextInt(7) + 1;
	public static int heal = random.nextInt(10) + 1;
	public static int enemyHealth = 20;

	public static void death() {
		System.out.println("You have died in the Mansion of Horrors! Game Over!");
	}

	public static void scene1() {
		System.out.println("You wake up in a dark room with a door. What do you do?");
		String input = keyboard.nextLine();
		if (input.equalsIgnoreCase("open door")) {
			System.out.println("Welcome to the Mansion of Horrors! Try your best to find a way out.");
			System.out.println("There is an Enemy Ahead of you. Will you Attack or Heal.");
			FightEnemy();
		} else {
			System.out.println("You can't do that!");
			scene1();
		}
	}

	public static void FightEnemy() {

		while (enemyHealth > 0) {
			int enemyDamage = random.nextInt(3) + 1;
			String input;
			if (HP <= 0) {
				death();
				return;

			}
			input = keyboard.nextLine();
			if (input.equalsIgnoreCase("attack")) {
				enemyHealth = enemyHealth - damage;
				HP = HP - enemyDamage;
				System.out.format("You Have Been Hit, Your HP is %d", HP);
				System.out.println("");
				// FightEnemy();

			} else if (input.equalsIgnoreCase("heal")) {
				if (potion <= 0) {
					System.out.println("You are out of potions!");
					// FightEnemy();

				} else {
					HP = HP + heal;
					System.out.println("You healed yourself!");
					System.out.format("Your HP is %d", HP);
					System.out.println();
					HP = HP - enemyDamage;
					System.out.format("You Have Been Hit, Your HP is %d", HP);
					System.out.println();
					// FightEnemy();
				}
			} else {
				System.out.println("Input could not be read! Try Again!");
				// FightEnemy();
			}
		}
		System.out.println("You Defeated A Skeleton");
		maxHP = maxHP + 1;
		potion = potion + 3;
		System.out.println("You Have Leveled Up! HP is now " + HP + "!");
		System.out.println("You found 3 potions! Your potion count is now " + potion + "!");
		System.out.println("");
		room3();

	} 
	public static void RightRoom() { 
		System.out.println("Solve this final riddle to leave.  The person who makes it has no need of it; the person who buys it has no use for it.\n"
				+ "The person who uses it can neither see nor feel it. What is it?");
		String input = keyboard.nextLine();
		if (input.equalsIgnoreCase("coffin")) {
			System.out.println("You have finished the mansion of hoors and are now allowed to leave!");
		} else {
			System.out.println("That was the wrong answer. I guess you were fated to fail!");
			death();
		}
	}
	public static void WrongRoom() {
		System.out.println("This was the wrong room. I guess you were fated to fail!");
		death();
	}
	public static void RedRoom() {
		System.out.println("Feed me and I'll live, but give me a drink and I'll die. What am I?");
		String input = keyboard.nextLine();
		if (input.equalsIgnoreCase("fire")) {
			System.out.println("Correct!");
			RoomChoice();
		} else {
			System.out.println("Wrong Answer!");
			death();
		}
	}
	public static void RoomChoice() {
		System.out.println("You are presented with two doors. One says 'The ending' and one says 'The final'"
				+ "\nA) Ending"
				+ "\nB) Final");
		String input = keyboard.nextLine();
		if(input.equalsIgnoreCase("a")) {
			RightRoom();
		} else if (input.equalsIgnoreCase("b")) {
			WrongRoom();
		} else {
			System.out.println("Command not recognized");
		}
		
	}
	public static void BlueRoom() {
		System.out.println("I have 4 legs when I'm small, 2 legs when I grow up, and 3 legs when I become old. What am I?");
		String input = keyboard.nextLine();
		if (input.equalsIgnoreCase("Human")) {
			System.out.println("Correct!");
			RoomChoice();
		} else {
			System.out.println("Wrong Answer!");
			death();
		}
	}
	public static void room3() {
		System.out.println("You are presented with a red door and a blue door! Which one will you go through?"
				+ "\nA) Red Door"
				+ "\nB) Blue Door");
		String input = keyboard.nextLine();
		if(input.equalsIgnoreCase("a")) {
			RedRoom();
		} else if (input.equalsIgnoreCase("b")) {
			BlueRoom();
		} else {
			System.out.println("Command not recognized");
		}
	}
	public static void main(String args[]) {
		
		scene1();

	}
}
