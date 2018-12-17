package Group.ChristmasGame;

public class Workshop {

	public static int workshopStory(int remainingHours, boolean fixedSled) {
		remainingHours -=3;
		if(fixedSled) {
		System.out.println("You head to your workshop. As you enter the elves appear to be in a busy state, and for good reason \n. "
				+ "The workshop is crammed full of all this year's christmas presents, and they appear to be ready for collection \n. "
				+ "With the assistance of a few of your little helpers you load your sled full of presents ready to be delivered tomorrow.");
		
		}
		else {
			System.out.println("You can't load your sled if it's broken! You should visit the garage to sort it out!");
		}
		System.out.println("You now have " + remainingHours +" hours left in the day.\n\n");
		return remainingHours;
	}
}