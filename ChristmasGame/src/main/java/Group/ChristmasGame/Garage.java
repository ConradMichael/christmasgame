package Group.ChristmasGame;

public class Garage {

	public static int garageStory(int remainingHours, boolean fixedSled) {

		if (!fixedSled) {
			if (remainingHours > 8) {
				System.out.println(
						"You enter the garage and ask your elf mechanic about the situation regarding your sled. \n "
								+ "He informs you it will be at least 3 hours before your sled is fully repaired. \n You should go and "
								+ "do something else.");
			} else {
				System.out.println(
						"You enter the garage and ask your elf mechanic about the situation regarding your sled. \n "
								+ "Great news! your sled is ready for collection! It is good as new and ready to deliver presents tomorrow!");
			}

			System.out.println(
					"While in the garage you see your trusty reindeer in their pens. \n You remember that feeding them is probably a good "
							+ "idea. \n "
							+ "You give them each two steak bakes and a jug of ale. \n One of your elves looks at you with what could only be "
							+ "disgust or disbelief.");
			remainingHours -= 2;
		} else {
			System.out.println("you've already done everything you need to in the garage.");
		}
		System.out.println("You now have " + remainingHours +" hours left in the day.\n\n");
		return remainingHours;
	}
}