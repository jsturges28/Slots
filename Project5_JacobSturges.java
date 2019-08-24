import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit; 

public class Project5_JacobSturges {
	public static void main(String[] args) throws InterruptedException{
		Scanner scnr = new Scanner(System.in);
		boolean x = true;
		String playAgain = new String("No");
		int tokens = 20;			// start with 20 tokens
		while(x && tokens > 0) {	// sentinel loop with the condition that you have tokens
		
			int[] scores = new int[3];
			int win;
		
			System.out.println("You have " + tokens + " tokens.");
			scores = generateRandomDigits(1, 10, 3);	// call method to generate random digits
			
			TimeUnit.SECONDS.sleep(1);  // simulate waiting for a spinning wheel
			
			System.out.println("Your spin was " + Arrays.toString(scores));
			
			win = calculateWin(scores);		// call method to calculate the win total from the array of random scores
			System.out.println("You earned " + win + " tokens.");
			tokens = tokens + win;
			System.out.println("You now have " + tokens + " tokens.");
			System.out.println("Would you like to play again?");
			playAgain = scnr.next();		// ask user if they want to play again
			if (playAgain.equals("Yes")) {
				x = true;
			}
			else if (playAgain.equals("No")) {
				x = false;
			}
			else {
				System.out.println("Come play again!");
				x = false;
			}
		
		}
	}
	
	public static int calculateWin(int[] scores) {	// create method to calculate win total based on win conditions
		if (scores[0] == 7 && scores[1] == 7 && scores[2] == 7) {
			return 500;
		}
		else if (scores[0] != 7 && scores[0] == scores[1] && scores[1] == scores[2]) {
			return 50;
		}
		else if (scores[0] == scores[1] || scores[1] == scores[2] || scores[0] == scores[2]) {
			return 3;
		}
		else if ((scores[0] == 7 && scores[1] == 7) || (scores[0] == 7 && scores[2] == 7) || (scores[1] == 7 && scores[2] == 7)) {
			return 15;
		}
		else {
			return -1;
		}
	}
	
	public static int[] generateRandomDigits(int low, int high, int size) {
		int[] scores = new int[size];
		for (int i = 0; i < size; i++) {
			scores[i] = findRandom(low, high);	// call the findRandom method to generate random numbers in the array
		}
		return scores;
	}
	
	public static int findRandom(int low, int high) {	// create method to generate random int numbers between 1 and 10
		int numRand = (int) ((Math.random() * high) + low);
		return numRand;
	}

}
