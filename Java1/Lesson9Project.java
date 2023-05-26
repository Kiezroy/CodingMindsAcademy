package codingMinds;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner; 

public class triviaGame {

	public static void main(String[] args) {
		int round = 0;
		int points = 0;
		String s = "";
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		while(!s.equals("STOP")) {
		    System.out.println("Choose a category from the choices below.");
		    System.out.println("Press 0 for a random category.");
		    System.out.println("Press 1 for history questions");
		    System.out.println("Press 2 for a pop culture questions");
		    System.out.println("Press 3 for a science questions.");
		    System.out.println("Enter in STOP to stop");
		    System.out.println("Points Remaining: " + points);

		    System.out.println("Round: " + round);
		    s = scan.next();
		    if(s.equals("0")) {
		    	int num = random.nextInt(4 - 1) + 1;
		    	s = String.valueOf(num);
		    }
		    
		    //Start new if statement because the previous if statement will change the value of s
		    //If left as else if, the value of s would not change until the next loop
		    
		    if(s.equals("1")) {
		        points += history();
		    }
		    else if(s.equals("2")) {
		        points += pop();
		    }
		    else if(s.equals("3")) {
		        points += science();
		    }
		    round++;
		}

	}
	
	public static int history() {
		Map<String, String> questions = new HashMap<String, String>();

	    questions.put("Who was the first president of the United States? "
	                  + "\n A. George Washington \n B. Abroham Linkin \n C. Marcus Aurelius", "A");

	    questions.put("When did the United States earn its independence? "
	                  + "\n A. 1738 \n B. 1788 \n C. 1800", "B");

		questions.put("What year did World War II end?"
	                  + "\n A. 1990 \n B. 1958 \n C. 1945", "B");

	    return askQuestion(questions);
	}
	
	public static int pop() {
		Map<String, String> questions = new HashMap<String, String>();

	    questions.put("What does BBC stand for? "
	                  + "\n A. British Broadcasting Corporation \n B. Big Bunny Channel \n C. Bankers Bake Cookies", "A");

	    questions.put("Where would you find the Golden Gate bridge? "
	                  + "\n A. San Jose \n B. San Francisco \n C. Minneapolos", "B");

		questions.put("What's the name of the river that runs through Egypt?"
	                  + "\n A. The Great River \n B. The Nile \n C. The Zamber", "B");

	    return askQuestion(questions);
	}
	
	public static int science() {
		Map<String, String> questions = new HashMap<String, String>();

	    questions.put("What element is most frequent in natural air?"
	                  + "\n A. Oxygen \n B. Carbon Dioxide \n C. Nitrogen", "C");

	    questions.put("The concept of gravity was discovered by which famous physicist?"
	                  + "\n A. Sir John Williams \n B. Sir Isaac Newton \n C. Barack Obama", "B");

		questions.put("How many oxygen atoms are in Carbon Monoxide"
	                  + "\n A. 1 \n B. 18 \n C. 3", "A");

	    return askQuestion(questions);
	}
	
	public static int askQuestion(Map<String, String> questions) {
		Random random = new Random();
		List<String> keys = new ArrayList<String>(questions.keySet());
		Scanner scan = new Scanner(System.in);
		String randomKey = "";
		String correctAns = "";
		String userAns = "";
		int points = 0;
		
		for(int i = 0; i < questions.size(); i++) {
		    randomKey = keys.get(random.nextInt(keys.size()));
		    correctAns = questions.get(randomKey);
		    System.out.println(randomKey);
		    userAns = scan.next();

		    if(userAns.equals(correctAns)) {
		        System.out.println("You're right!!!\n");
		        points++;
		    }
		    else {
		        System.out.println("You're wrong!!!\n");
		    }
		}
		
		return points;
	}

}
