import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class adventureRPG {

	public static Map<String, Integer> player = new HashMap<String, Integer>();
	public static Map<String, Integer[]> playerInventory = new HashMap<String, Integer[]>();
	
	public static void main(String[] args) {
		 player.put("currHealth", 100);
		 player.put("maxHealth", 100);
		 
		 //In this version mana isn't used but is there for fun
		 player.put("mana", 100);
		 player.put("currMana", 100);
		 
		 player.put("exp", 0);
		 player.put("expToLevel", 1000);
		 player.put("damage", 10);
		 player.put("gold", 25000);

		 System.out.println("You awake in town.");
		 town();
	}
	
	public static Map<String, Integer> genEnemy() {
		Map<String, Integer> enemy = new HashMap<String, Integer>();
		enemy.put("health", 100);
		enemy.put("exp", 50);
		enemy.put("gold", 100);
		enemy.put("damage", 15);
		return enemy;	
	}
	
	public static void battle(Map<String, Integer> enemy) {
		int enemyHealth = enemy.get("health");
		int playerHealth = player.get("currHealth");
		int enemyDamage = enemy.get("damage");
		int playerDamage = player.get("damage");
		
		while(enemyHealth > 0 && playerHealth > 0) {
			enemyHealth -= playerDamage;
			enemy.put("health", enemyHealth);
			System.out.println("You hit enemy for " + player.get("damage"));
			
			playerHealth -= enemyDamage;
			player.put("currHealth", playerHealth);
			System.out.println("The enemy hits you for " + enemy.get("damage"));
			
			System.out.println("Your HP: " + playerHealth);
			System.out.println("Enemy HP: " + enemyHealth);
		}
	}
	
	public static void levelUp() {
		int newHealth = player.get("maxHealth") + 100;
		int newMana = player.get("mana") + 50;
		int newExpToLevel = player.get("expToLevel") + 500;
		int newDamage = player.get("damage") + 15;

		 player.put("maxHealth", newHealth);
		 player.put("currHealth", newHealth); 
		 player.put("mana", newMana);
		 player.put("currMana", newMana);
		 player.put("exp", 0);
		 player.put("expToLevel", newExpToLevel);
		 player.put("damage", newDamage);
		 printPlayer();
	}
	
	public static void outskirts() {
		int n = Integer.MAX_VALUE;
		while(n != 0) {
			Map<String, Integer> enemy = genEnemy();
			if(n == 2) {
				town();
			}
			
			System.out.println("A bandit accosts you the moment you step out of town!");
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Press 1 to engage, press 2 to flee");
			n = scan.nextInt();
			if(n == 1) {
				// battle logic
				battle(enemy);
                // if player wins, add gold and exp
				if(player.get("currHealth") > 0){
					System.out.println("You win!");
					int exp = player.get("exp") + enemy.get("exp");
					int gold = player.get("gold") + enemy.get("gold");
					player.put("exp", exp);
					player.put("gold", gold);
					//printPlayer();
                    // if player exp exceed exp to level, run level up method
					if(player.get("exp") >= player.get("expToLevel")) {
						System.out.println("You've gained a level!!");
						levelUp();
					}
				}
				else {
					System.out.println("Game over! Start the program again to play a new game.");
					n = 0;
					break;
				}
				System.out.println("Press 1 to keep battlling, or 2 to travel somewhere else");
				n = scan.nextInt();
			}
			else if(n == 2) {
				n = 0;
				System.out.println("You have fled back to Flavortown!\n");
				town();
			}
		}
	}
	
	public static void bridge() {
		Scanner input = new Scanner(System.in);
		System.out.println("Do you have 2500 Gold to repair the bridge? (Y/N)");
		String answer = input.nextLine();
		
		if(answer.equals("Y")) {
			if(player.get("gold") >= 2500) {
				player.put("gold", player.get("gold") - 2500);
				System.out.println("Congrats! You have repaired the bridge and saved the town!\n GAME COMPLETED WITH THESE STATS: \n");
				printPlayer();
				//Must exit the system b/c glitches with going back to outskirt() function
				System.exit(0);
			}else {
				System.out.println("You liar! Back to town you go!");
				town();
			}
		}else if(answer.equals("N")) {
			System.out.println("How sad! Come back next time. Traveling back to town!");
			town();
		}else {
			System.out.println("Invalid input! Traveling back to town!");
			town();
		}
	}
	
	public static void town() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Flavortown.");
		//System.out.println("Press 0 to travel somewhere else");
		int n = Integer.MAX_VALUE;
		
		while(n != 0) {
			System.out.println("\nPress 0 to travel somewhere else\nPress 1 to enter inn and heal. Press 2 to go to merchant and buy/sell");
			n = scan.nextInt();
			if(n == 1) {
				//If copied code from codingMinds, must put currHealth and maxHealth in player variable or will get NullPointerException error
				if(player.get("currHealth") < player.get("maxHealth")) {
					player.put("currHealth", player.get("maxHealth"));
					System.out.println("Healed to max health!");
				}else {
					System.out.println("At max health already!");
				}
				printPlayer();
			}
			if(n == 2) {
				System.out.println("Welcome to the shop! What would you like to purchase? Gold: " + player.get("gold") + "\n A. Restore Mana (250 Gold)\n B. Add 1000 Exp (500 Gold)");
				//Must put scan.nextLine() or else playerPurchase will be skipped (https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/)
				scan.nextLine();
				String playerPurchase = scan.nextLine();
				
				if(playerPurchase.equalsIgnoreCase("A")) {
					//Check if player has enough gold
					if(player.get("gold") >= 250) {
						player.put("currMana", player.get("mana"));
						player.put("gold", player.get("gold") - 250);
						System.out.println("Restored Mana to " + player.get("mana"));
					}else {
						System.out.println("Not enough!");
					}
				}else if(playerPurchase.equalsIgnoreCase("B")) {
					//Check if player has enough gold
					if(player.get("gold") >= 500) {
						player.put("exp", player.get("exp") + 1000);
						player.put("gold", player.get("gold") - 500);
						System.out.println("Added 1000 Exp!");
						if(player.get("exp") >= player.get("expToLevel")) {
							System.out.println("You've gained a level!!");
							levelUp();
						}
					}else {
						System.out.println("Not enough!");
					}
				}else {
					System.out.println("Unidentified input, error detected!");
				}
				
				
				//Implement sell function****************
			}
		}
		
		System.out.println("Press 1 to travel to outskirts. Press 2 to go to bridge.");
		n = scan.nextInt();
		if(n == 1) {
			outskirts();
		}
		if(n == 2) {
			bridge();
		}
	}
	
	public static void printPlayer() {
		Set<String> keySet = player.keySet();
		// enhanced for loop
		for (String key : keySet){
		    int value = player.get(key);
		    System.out.println(key + "-" + value);
		}
	}

}
