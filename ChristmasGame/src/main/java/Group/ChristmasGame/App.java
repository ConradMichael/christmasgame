package Group.ChristmasGame;

import java.util.Scanner;

public class App {
	private static Story story = new Story();
	private static Scanner sc;
	static int remainingHours;
	static boolean fixedSled = false;
	static boolean workShopDone = false;

	public static void main(String[] args) {
		story.storyStart();
		int i = 0;
		remainingHours = 12;

		while (remainingHours > 0) {
			if (i > 0) {
				System.out.println("Where next? Try 'Garage', 'Workshop', 'Bed'");
			}
			executeChoice(getChoice());
			i++;
		}
		if (fixedSled && workShopDone) {
			Main.startGame();
		} else {
			System.out.println(
					"Uh oh! You didn't finish your tasks in time. Will you try again next year? Try 'Yes', 'No'");
			sc = new Scanner(System.in);
			String retry = sc.nextLine();
			while (true) {
				if (retry.equals("Yes") || retry.equals("yes")) {
					main(new String[0]);
				} else if (retry.equals("No") || retry.equals("no")) {
					System.out.println("Thanks for playing");
					break;
				} else {
					System.out.println("Please enter yes or no.");
				}
			}
		}

	}

	public static String getChoice() {
		sc = new Scanner(System.in);
		String input = sc.nextLine();
		while (true) {

			if (input.equals("Garage") || input.equals("garage") || input.equals("Workshop") || input.equals("workshop")
					|| input.equals("Bed") || input.equals("bed")) {
				return input;
			} else {
				System.out.println("Please enter one of the three available options.");
				input = sc.nextLine();
			}
		}
	}

	public static void executeChoice(String choice) {
		if (choice.equals("Garage") || choice.equals("garage")) {
			remainingHours = Garage.garageStory(remainingHours, fixedSled);
			if (fixedSled = true) {
				workShopDone = true;
			}
		} else if (choice.equals("Workshop") || choice.equals("workshop")) {
			remainingHours = Workshop.workshopStory(remainingHours, fixedSled);
		} else if (choice.equals("Bed") || choice.equals("bed")) {
			remainingHours = Story.storyBed(remainingHours);
		}

	}
}