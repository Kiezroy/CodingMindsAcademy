import java.util.*;

public class ReviewP2 {
	public static void main(String[] args) {
		//System.out.println(Arrays.toString(randomNumberGenerator(10)));
		//System.out.println(singleRandomNum());
		//System.out.println(isPositive(-1));
		
		Integer[] arr = {4, -5, 10, -33, 70};
		//Double[] arr = {4.2, -5.55, 10, -33.9, 70.1};
		//System.out.println(minimum(arr));
		//System.out.println(average(arr));
		//System.out.println(maximum(arr));
		
		//ArrayList<String> arrList = new ArrayList<>();
		//schoolDatabase();
		System.out.println(Arrays.toString(iveIve(arr)));
	}
	
	/*
	//Random Number Generator
	public static Integer[] randomNumberGenerator(int size) {
		Random rand = new Random();
		Integer[] arr = new Integer[size];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100 + 100) - 100;
		}
		return arr;
	}
	*/
	
	/*
	public static int singleRandomNum() {
		Random rand = new Random();
		return rand.nextInt(100 + 100) - 100;
	}
	*/
	
	/*
	public static boolean isPositive(int num) {
		if(num >= 0) {
			return true;
		}
		return false;
	}
	*/
	
	/*
	public static int minimum(Integer[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	*/
	
	/*
	
	public static double average(Integer[] num) {
		int sum = 0;
		for(int i : num) {
			sum += i;
		}
		return sum / 2;
	}
	
	*/
	
	/*
	public static int maximum(Integer[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	*/
	
	/*
	public static void printArrayList(ArrayList<String> list) {
		for(String str: list) {
			System.out.println(str);
		}
	}
	*/
	
	/*
	public static void schoolDatabase() {
		Scanner input = new Scanner(System.in);
		ArrayList<String> students = new ArrayList<>();
		
		boolean looping = true;
		
		while(looping) {
			System.out.println("Enter student or 'STOP'...");
			String student = input.nextLine();
			if(student.equalsIgnoreCase("STOP")) {
				looping = false;
			}else {
				students.add(student);
			}
		}
		System.out.println(students);
	}
	*/
	
	
	
	
}
