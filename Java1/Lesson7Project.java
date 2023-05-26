import java.util.ArrayList;
import java.util.Scanner;

public class day1 {

	public static void main(String[] args) {
	    boolean alive = true;
	    int food = 20;
	    int wood = 20;
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Airplane go brrrrr!! (in a bad way)");
	    System.out.println("You crash land on a deserted island. Dawn of the first day...");
	    
	    while(alive) {
	        // daytime loop
	        for(int i = 0; i < 13; i++) {
	            if(food > 0){
	                System.out.println("It is day time! Time to collect some wood or food to stave off the inevitable.\n");
	                System.out.println("Should I collect wood or food? Enter option and a number <= 12");
                	System.out.println("\nFood: " + food + " Wood: " + wood);

	                String input = scan.nextLine();
	                
	                String[] arr = input.split(" ");
	                
	                String option = arr[0];
	                int hours = Integer.parseInt(arr[1]);

	                if(option.equals("wood")) {
	                	//Duplicates the wood according to hours
	                	wood += 3*hours;
	                	
	                	//Subtracts the food
	                	food -= hours;
	                	
	                	//Adds the amount of hours to i
	                	i += hours;
	                	
	                	System.out.println("Food: " + food + " Wood: " + wood);
	                }
	                else if (option.equals("food")) {
	                	//Subtracts the food
	                	food += 2;
	                	
	                	//Adds the amount of hours to i
	                	i += hours;
	                	
	                	System.out.println("Food: " + food + " Wood: " + wood);
	                }
	            }
	            else{
	            	i = 13;
	                System.out.println("You run out of food and don't survive to see the morning.");
	                alive = false;
                	System.out.println("\nFood: " + food + " Wood: " + wood);
	            }
	        }
	        // night time loop
	        if(alive) {
	        	System.out.println("\nNight cycle has occured!");
		        for(int i = 0; i < 13; i++) {
		            wood-=2;
		        }
	        }
	        if(wood <= 0) {
	        	System.out.println("You run out of wood and don't survive to see the morning.");
	        	alive = false;
            	System.out.println("\nFood: " + food + " Wood: " + wood);
	        }
	    }
	}
	
}
