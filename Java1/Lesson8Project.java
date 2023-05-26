import java.util.Random;
import java.util.Scanner;

public class timesTable {

	public static int genQuestion(int aDigits, int bDigits) {
		// write your question code here 
		// user should be asked and solve question WITHIN this method
		// method will return amt of points to add (assuming correct)
		int points = 0;
		Random rand = new Random();
		// you can use a and b as the random numbers to your question
		int a = rand.nextInt((int) Math.pow(10, aDigits));
		int b = rand.nextInt((int) Math.pow(10, aDigits));
		
		System.out.println("Please solve this question: " + a + "*" + b + "= ?");
		
		Scanner input = new Scanner(System.in);
		if(Integer.parseInt(input.nextLine()) == (a*b)) {
			int num = a*b;
			while(num > 0) {
				if(num >= 0) {
					points++;
				}
				num /= 10;
			}
			System.out.println("Correct! Awarded " + points + " points...");
		}else {
			System.out.println("Incorrect! No points awarded...");
		}
    
    
		return points;
	}
	
	public static void saveData(int aDigits, int bDigits, boolean snakeEyes, int points) {
		// write your save data code here
		// keep it consistent with your load data code
		// e.g. if save all info to one line, load all data from one line
		// e.g. if save each info on diff line, load each data from diff line
		
		//Haven't covered file saving yet?
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aDigits = 1;
		int bDigits = 1;
		boolean snakeEyes = false;
		int points = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Mather. Load previous progress? Y/N: ");
		String s = scan.next();
		
		if(s.equals("Y")  || s.equals("y")){
			// read data from file here
			// then set aDigits, bDigits, points, and snakeEyes to according values
			
			
		}
		else if(s.equals("N") || s.equals("n")){
			System.out.println("Starting new game... ");
		}
		
		int n = 0;
		
		while(n != 2) {
			System.out.println("Enter 0 to earn points, 1 to spend points, and 2 to save and quit: \n You have " + points + " points!");
			n = scan.nextInt();
			if(n == 0) {
				points += genQuestion(aDigits, bDigits);
			}
			else if (n == 1) {
				// write your gachapon code here, no need for another method
				// remember make sure user has > 5 points 
				if(points >= 5) {
					Random randNum = new Random();
					//Generates number 0-100
					int num = randNum.nextInt(100 - 0) + 0;
					if(num >= 0 && num < 20) {
						System.out.println("Number of a digits increased!");
						aDigits++;
					}else if(num >= 20 && num < 40) {
						System.out.println("Number of b digits increased!");
						bDigits++;
					}else if(num >= 40 && num < 50) {
						if(snakeEyes == false) {
							if(aDigits == bDigits) {
								//Add the number of digits to points b/c automatically solved
								points += aDigits;
							}
							snakeEyes = true;
						}
					}else {
						System.out.println("Nothing occured...");
					}
				}
			}
			else if (n == 2) {
				break;
			}
			else {
				System.out.println("Enter valid number. ");				
			}
		}
		System.out.println("Saving data... ");	
		saveData(aDigits, bDigits, snakeEyes, points);
		System.out.println("Goodbye.");	
	}
	

}
