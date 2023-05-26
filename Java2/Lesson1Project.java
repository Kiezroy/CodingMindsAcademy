package codingMinds;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		int n;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Calcutec.");
        System.out.println("Press a number for operations: 1. prime?, 2. isEven?, 3. factorial, 4. exponentiate");
        
        n = scanner.nextInt();
         
       	if(n == 1){
       		System.out.println("Enter a number: ");
       		int number = scanner.nextInt();
            if(prime(number)) {
            	System.out.println("Prime!");
            }else {
            	System.out.println("Not Prime!");
            }
        }else if(n == 2) {
        	
        	System.out.println("Enter a number: ");
        	int number = scanner.nextInt();
        	
        	if(isEven(number)) {
        		System.out.println("Even!");
        	}else {
        		System.out.println("Odd!");
        	}
        }else if(n ==3) {
        	System.out.println("Enter a number: ");
        	int number = scanner.nextInt();
        	System.out.println("Calculated number: " + factorial(number));
        }else if (n == 4){
        	System.out.println("Enter in base number: ");
        	int base = scanner.nextInt();
        	
        	System.out.println("Enter power: ");
        	int power = scanner.nextInt();
        	
        	System.out.println("Calculated number: " + exponentiate(base, power));
        }else {
        	System.out.println("Invalid input! Error occurred...");
        }
        

	}
	
	public static boolean prime(int a){
		/* Kyle's Way
		int count = 0;
		for(int i = 1; i <= a; i++) {
			if(a % i == 0) {
				count++;
			}
		}
		if(count <= 2) {
			return true;
		}
		return false;
		*/
		
		//More efficient way
		if(a == 1) {
			return false;
		}
		
		for(int i = 2; i < a; i++) {
			if(a % i == 0) {
				return false;
			}
		}
		return true;
	}
    
    public static boolean isEven(int a){
        if(a % 2 == 0) {
        	return true;
        }
        return false;
    }
    
    public static int factorial(int a) {
    	int number = 1;
    	for(int i = 1; i <= a; i++) {
    		number *= i;
    	}
    	return number;
    }
    
    public static int exponentiate(int base, int power) {
    	/* Use if cannot use Math.pow
    	int var = base;
    	for(int i = 1; i < power; i++) {
    		var *= base;
    	}
    	return var;
    	   */
    	
    	return (int) Math.pow(base, power);
    }

}
