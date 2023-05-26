package codingMinds;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class turnbattle {
	public static Map<String, Integer> player = new HashMap<String, Integer>();
	public static Map<String, String> playerEquips = new HashMap<String, String>();
	
	public static Map<String, Integer> genEnemy() {
		Map<String, Integer> enemy = new HashMap<String, Integer>();
		enemy.put("health", 100);
		enemy.put("exp", 500);
		enemy.put("gold", 100);
		enemy.put("damage", 15);
		return enemy;	
	}
	
	public static int roll(int n) {
		Random rand = new Random();
		return rand.nextInt(n)+1;
	}
	
	public static void attack(Map<String, Integer> enemy) {
		int damage = player.get("damage") + roll(15);
		int playerHP = player.get("currHealth");
		int enemyHP = enemy.get("health");
    
    
		if(playerEquips.get("weapon").equals("sharp")){
			//150% increase
            damage *= 1.5;
		}
		else if(playerEquips.get("weapon").equals("blunt")){
			//130% increase;
            damage *= 1.3;
		}
		else if(playerEquips.get("weapon").equals("ranged")){
			// 2/3 chance of 120% increase
            if(roll(3) >= 2) {
            	damage *= 1.2;
            }
		}
    
		// 10% chance to straight up miss
		if(roll(10) == 10) {
            System.out.println("Attack missed!");
		}
		else {
			enemyHP -= damage;
			enemy.put("health", enemyHP);
			System.out.println("You hit the enemy for: " + damage);
			

			System.out.println("Your HP: " + playerHP);
			System.out.println("Enemy HP: " + enemyHP);
		}
	
	}
	
	public static void skill(Map<String, Integer> enemy) {
		Scanner scan = new Scanner(System.in);
		int in;
		int damage = player.get("damage");
		int playerHP = player.get("currHealth");
  		int playerMP = player.get("currMana");
		int enemyHP = enemy.get("health");
		

		System.out.println("Skills: 1. Wallop \t 2. Heal");
		in = scan.nextInt();
		if(in == 1 && player.get("currMana") > 20) {
			if(roll(10) <= 8) {
		        enemyHP -= (damage*2);
		        enemy.put("health", enemyHP);
		        System.out.println("You hit the enemy for: " + (damage*2));

		        System.out.println("Your HP: " + playerHP);
		        System.out.println("Enemy HP: " + enemyHP);
		    }
		    else {
		        enemyHP -= (damage*1.5);    
		        enemy.put("health", enemyHP);
		        System.out.println("You hit the enemy for: " + (damage*1.5));

		        System.out.println("Your HP: " + playerHP);
		        System.out.println("Enemy HP: " + enemyHP);
		        }
		    

		    player.put("currMana", playerMP-20);
		}
		else if(in == 2 && player.get("currMana") > 35) {
			 if(roll(10) <= 8) {
			        int HP = player.get("currHealth") + 25;
			        player.put("currHealth", HP);
			        System.out.println("You heal for 25");
			    }
			    else {
			        int HP = player.get("currHealth") + 15;
			        player.put("currHealth", HP);
			        System.out.println("You heal for 15");
			    }
			    player.put("currMana", playerMP-35);
		}
		else {
			System.out.println("Not enough mana for skill.");
		}
	}
	
	public static void battle(Map<String, Integer> enemy) {
		boolean first; // helps decide if enemy or player attacks first
		Scanner scan = new Scanner(System.in);
		int in; // take in user input
		int dmg; // calculate damage
		int turn = 1; // keep track of turns
		
		System.out.println("You enter combat!!");
		// roll for initiative 
		if(roll(2) == 1) {
		    System.out.println("You catch the enemy off guard and get to attack first!");
		    first = true;
		}
		else {
		    System.out.println("You've been ambushed!!");
		    first = false;
		}
		
		while(player.get("currHealth") > 0 && enemy.get("health") > 0) {
		    System.out.println("\n Turn: " + turn);
		    // player's turn
		    if(first) {
		        System.out.println("1. Attack \t 2. Skill \t 3. Escape (40%)");
		        in = scan.nextInt();
		        if(in == 1) {
		            attack(enemy);
		        }
		        else if(in == 2) {
		            skill(enemy);	
		        }
		        else if(in == 3) {
		            if(roll(10) > 6) {
		                System.out.println("You run away successfully.");
		                break;
		            }
		            else {
		                System.out.println("You fail to escape.");
		            }
		        }

		    }else {
		    	//Enemy goes first
		    	System.out.println("_________________________");// enemy's turn
		    	// inside while loop, after player's turn (if block)

		    	int intent = roll(10);
		    	if(intent < 7) {
		    	    int damage = enemy.get("damage") + roll(10);
		    	    player.put("currHealth", player.get("currHealth") - damage);
		    	    System.out.println("\n The enemy hits you for " + damage);

		    	    System.out.println("Your HP: " + player.get("currHealth"));
		    	    System.out.println("Enemy HP: " + enemy.get("health"));
		    	}
		    	else {
		    	    enemy.put("health", enemy.get("health") + 10 + roll(10));
		    	    System.out.println("\n The enemy heals!");
		    	    System.out.println("Your HP: " + player.get("currHealth"));
		    	    System.out.println("Enemy HP: " + enemy.get("health"));
		    	}
		    }
		    
		    first = true;
		    turn++;
		    System.out.println("_________________________");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		player.put("maxHealth", 200);
		player.put("currHealth", 200); 
		player.put("mana", 100);
		player.put("currMana", 100);
		player.put("exp", 0);
		player.put("expToLevel", 1000);
		player.put("damage", 10);
		player.put("gold", 1000);
		
		playerEquips.put("weapon", "sharp");
		playerEquips.put("armor", "light");
		
		Map<String, Integer> enemy = genEnemy();
		battle(enemy);

	}

}