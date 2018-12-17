package Group.ChristmasGame;

public class Story {

	
	public void storyStart() {
		System.out.println("You wake up and check your calendar, it's the 23rd of December. As Santa Claus, you must prepare everything for "
				+ "the big night tomorrow. \n You need to: \n Take your sled to the garage. \n Feed your reindeer. \n Collect presents from"
				+" the workshop. \n Load presents onto the sled. \n Where will you start? Try 'Garage', 'Workshop' 'Bed'");
	}
	
	public static int storyBed(int remainingHours) {
		remainingHours -= 4;
		System.out.println("You decide to take a nap, this is way too stressful for you, I'm sure it'll be fine. \n You wake up worried that "
				+ "you've slept so long, you now have " + remainingHours + " hours left in the day.");
		return remainingHours;
	}
}