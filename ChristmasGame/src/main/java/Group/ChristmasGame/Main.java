package Group.ChristmasGame;

import java.util.Scanner;

public class Main {
	
	private static int[][] locations = new int[15][15];
	
	private static String[] locationDescription = new String[25];
	
	private static int gridSize = 51;
	private static int grid[][];
	private static int presentCount;

	private static int santaX;
	private static int santaY;
	
	private static int sleighX;
	private static int sleighY;
	
	private static double difficulty = 0.975;
	
	private static int sleighHolding = 0;
	private static int presentsHolding = 0;
	private static int maxAmountOfPresents = 20;
	
	private static boolean gameRunning = false;
	
	
	public static void startGame() {
		gameRunning = true;
		grid = new int[gridSize + 1][gridSize + 1];
		
		initGrid();
		initDescriptions();
		initSanta();
		
		while(gameRunning) {
			System.out.println("\n\n\n");
			
			System.out.println("You done fucked it and crashed boi. Sort your shit out.\n");
			System.out.println("Your location: X: " + santaX + " Y: "+ santaY);
			System.out.println("Your Sleighs location: X: " + sleighX + " Y: "+ sleighY + "\n");
			
			move();
			checkPos();
		}
	}
	
	public static void bossFight() {
		boolean jezAlive = true;
		int santaHealth = 40;
		int jezHealth = 50;
		int healthPotions = 3;
		
		System.out.println("\n\n");
		System.out.println("You have collected enough of the missing presents! Christmas is..");
		System.out.println("You see a small green figure in the distance..");
		System.out.println("It's getting closer.. it's Jez..");
		System.out.println("He's trying to take all of the presents and ruin Christmas! FINISH HIM!\n");
		
		
		while(jezAlive) {
			
			System.out.println("Your health: " + santaHealth + ". Jez's health: " + jezHealth + ".");
			System.out.println("Will you: ||Attack|| ||Heal:(" + healthPotions + ")||");
			Scanner fInput = new Scanner(System.in);
			String fChoice = fInput.nextLine();
			
			if(fChoice.equals("Attack") || fChoice.equals("attack")) {
				int attackDMG = (int)(Math.random() * 9);
				jezHealth -= attackDMG;
				if(jezHealth <= 0) {
					System.out.println("You have killed the foul beast.");
					System.out.println("Christmas is saved!");
					gameRunning = false;
					jezAlive = false;
				} else {
					int takeDMG = (int)(Math.random() * 9);
					santaHealth -= takeDMG;
					if(santaHealth <= 0) {
						System.out.println("Jez has defeated you. Christmas is ruined forever. His dreams have come true.");
						gameRunning = false;
						jezAlive = false;
					}
					System.out.println("You attacked Jez for " + attackDMG + " health points. Your health is: " + santaHealth);
				}		
			} else if(fChoice.equals("heal") || fChoice.equals("Heal")) {
				if((santaHealth + 15) < 40) {
					santaHealth += 15;
					System.out.println("You healed yourself for 15 health points.");
				} else if((santaHealth + 15) > 40){
					santaHealth = 40;
					System.out.println("You are now at maximum health.");
				}
			}
		}
	}
	
	public static void checkPos() {
		
		if(grid[santaX][santaY] == 1) {
			if(presentsHolding < 5) {
				presentsHolding += 1;
				grid[santaX][santaY] = 0;
				
				System.out.println("You are currently carrying: " + presentsHolding + " presents.");
				if(presentsHolding == 5) {
					System.out.println("You now have the max amount of presents you can carry, go drop them off.");
				}
			} else {
				System.out.println("You are carrying too many presents! Go drop them off then come back for this one.");
			}
		} else if (santaX == sleighX && santaY == sleighY) {
			sleighHolding += presentsHolding;
			System.out.println("You have dropped off: " + presentsHolding + " presents. Your sleigh now holds: " + sleighHolding + " presents.");
			presentsHolding = 0;
		}
		
		if(sleighHolding >= maxAmountOfPresents) {
			bossFight();
		} else {
			System.out.println("You still need: " + (maxAmountOfPresents - sleighHolding));
		}
		
	}

	public static void initSanta() {
		boolean santaLocation = false;
		
		if(santaLocation == false) {
			double santaxgen = Math.random();
			double santaygen = Math.random();
			santaxgen *= 50;
			santaygen *= 50;
			santaX = (int)(santaxgen);
			santaY = (int)(santaygen);
		}
		
		sleighX = santaX + 1;
		sleighY = santaY + 1;
	}
	
	public static void move() {
		double locationd = Math.random();
		locationd *= 25;
		int x = (int)(locationd);
		System.out.println(locationDescription[x] + "\n");
		
		System.out.println("Where would you like to move? Use WASD Keys.");
		Scanner m_scan = new Scanner(System.in);
		String testMove = m_scan.nextLine();
		
		if(testMove.equals("w") || testMove.equals("W")) {
			if(santaY != 0) {
				santaY --;
			} else {
				System.out.println("You have reached the edge, move in another direction to continue.");
			}
		}
		
		else if(testMove.equals("a") || testMove.equals("A")) {
			if(santaX != 0) {
				santaX --;
			} else {
				System.out.println("You have reached the edge, move in another direction to continue.");
			}
		}
		
		else if(testMove.equals("s") || testMove.equals("S")) {
			if(santaY != (gridSize - 1)) {
				santaY ++;
			} else {
				System.out.println("You have reached the edge, move in another direction to continue.");
			}
		}
		
		else if(testMove.equals("d") || testMove.equals("D")) {
			if(santaX != (gridSize - 1)) {
				santaX ++;
			} else {
				System.out.println("You have reached the edge, move in another direction to continue.");
			}
		}
		else if(testMove.equals("k")) {	
			presentsHolding = 20;
			santaX = sleighX;
			santaY = sleighY;
		} else {
			System.out.println("Invalid key entered. Try Again.");
		}

	}
	
	public static void initGrid() {
		
		for(int i = 1; i < gridSize + 1; i++) {
			for(int j = 1; j < gridSize + 1; j++) {
				double pres = Math.random();
				if(pres > difficulty && i != sleighX && j != sleighY) {
					grid[i][j] = 1;
					presentCount++;
				} else {
					grid[i][j] = 0;
				}
				
			}
		}
	}
	
	public static void initDescriptions() {
		locationDescription[0] = "You are in a lightly wooded forest. Candy canes, glittery baubles and what looks like one of Mrs Claus' bra's hang from the branches.";
		locationDescription[1] = "You are in a lightly wooded forest. The snow is falling fast, covering the ground in a thick blanket of snow that makes it difficult to navigate.";
		locationDescription[2] = "The area you are standing in sparkles with ice, creating a magical feeling that is only slightly ruined by the 'vomit icicles' that hang from the tree branches overhead. Presumably left behind after your last nightime adventure.";
		locationDescription[3] = "There is a line of snow-capped trees in the distance, empty cans of XXX Strength Mulled Wine litter the ground.";
		locationDescription[4] = "Snow crunches underfoot. An icy wind begins to blow, carrying faint strains of Slade's 'Merry Christmas Everybody'";
		locationDescription[5] = "You are standing in a patch of yellow snow, you're surrounded by reindeer poop. Reindeer poop as far as the eye can see.";
		locationDescription[6] = "You are standing at the base of a gentle slope, the scent of pine needles and moonshine surrounds you.";
		locationDescription[7] = "You are standing at the top of a small hill. below you is a frozen pile of clothes and an impression left in the snow by 4 or 5 randy elves.";
		locationDescription[8] = "You are standing by a frozen lake. In the centre can still be seen the vague silhouette of 'Glitter-toes', the unfortunate elf who fell in the lake and got trapped under the ice 3 years ago.";
		locationDescription[9] = "You stand on a barren, frozen plain. The plain horizon stretches far into the distance. Standing here it feels as if you are the only person on earth... from somewhere you hear the faint sounds of 'Baby Shark'!";
		locationDescription[10] = "The magical green glow of the northern lights shines majestically overhead. A gentle breeze caresses your beard and snow falls gently down around you, covering the earth in an unblemished, white blanket.... you slip in reindeer shit.";
		locationDescription[11] = "As you pass a pine thicket you see something carved into the bark of a pine tree \"Fucking cold and fucking dark. Listen to the huskies bark. - Lapland Winter. A short poem by Sugar-Socks McJingles";
		locationDescription[12] = "Half eaten mince pies and empty bottles of Brussel Sprout flavour WKD litter the ground. Signs of another elf bender that got out of hand.";
		locationDescription[13] = "An icy wind knifes through your bones. You feel the cold against your face and dream of a warming mug of hot chocolate... with a dash or two of whiskey.";
		locationDescription[14] = "In the distance you can see a menacing huddle of snowmen, whispering amongst themselves. They hear you and look up, their coal black eyes glittering. You decide to move on.";
		locationDescription[15] = "Snow stretches as far as the eye can see. Snow. White, cold, atmospheric water vapour frozen into ice crystals and falling in light white flakes or lying on the ground as a white layer.";
		locationDescription[16] = "You are standing in a slushy field. You burp and taste cinnamon and urinal cake.... a memory from last night comes back to haunt you and you decide to move on.";
		locationDescription[17] = "The blizzard starts to ease slightly allowing you to see more clearly. You note that in the distance can be seen an enormous snowman, standing like a sentinel against the cold. You decide to hurry on.";
		locationDescription[18] = "ou are standing on a rocky hilltop, you hear the sound of christmas carols being sung somewhere. Not one of the four actually good ones though so you decide to move on.";
		locationDescription[19] = "Snow falls softly around you. A robin perched on a nearby branch sings sweetly. You feel the beginning of a hangover start to throb in your skull.";
		locationDescription[20] = "Your beard blows in the breeze. A strand of tinsel dislodges itself and flies free along with several mince pie crumbs.";
		locationDescription[21] = "You look out over the snowy landscape of Lapland. The candy cane factories in the distance, the mince-pie warehouses towering over the selection-box storage huts... you feel the faint rumblings of early stage, type 2 diabetes.";
		locationDescription[22] = "The snow is falling heavily, making it difficult to see.";
		locationDescription[23] = "The wind blows through the trees, stinging your eyes.";
		locationDescription[24] = "You are standing next to a frozen puddle containing a carrot, an old scarf and a handful of coal. You pay your respects and move on.";
	}
}
