package montyHall;

import java.util.Random;
import java.util.Scanner;

/**
 * This application proves the Paradox of Monty Hall.
 * 
 * 
 * @author almazbekbegaliev
 *
 */
public class Paradox {

	Random random = new Random();
	Scanner scan = new Scanner(System.in);

	public String player;
	int choice;
	int bingo;
	int open;
	int switching;
	int secondChoice;
	static int stickAndWin=0;
	static int switchAndWin=0;
	int count=0;
	
	public void run() {
		System.out.println(
				"\t\tWelcome to the Monty Halls paradox !!! \nYou have three doors, there is one CAR behinde one door, "
						+ "and two GOATS behind others. \n\t\tYour goal is to win the CAR.");
		while (count < 100) {
			count++;
			bingo();
//			Scanner scan = new Scanner(System.in);
//			System.out.println(
//					"\n\t\t1. To choose the door \n\t\t2. To see Number of bingos \n\t\t3. To QUITE the game\n");
//			int function = scan.nextInt();
			int function =1;
			switch (function) {
			case 1:
//				System.out.println("Choose your door: \n 1.First door \n 2 Second door \n 3 Third door ");
//				int door = scan.nextInt();
				int door = randomNum();
				
				switch (door) {
				case 1:
					choice = 1;
					choose();
					break;
				case 2:
					choice = 2;
					choose();
					break;
				case 3:
					choice = 3;
					choose();
					break;
				default:
					System.out.println("Wrong choice");
				}
				break;
			case 2: 
				printResult();
				break;
			case 3:
				System.out.println("Have a nice day.");
				return;
			}

		}

	}

	public void choose() {
		open = openOne();
//		System.out.println("Door " + open + " contains a goat.\n");
//		System.out.println("\n Knowing where one of the doors with Goat are opend, do you wish to keep your current door,"
//				+ "\n or do you want to change? \n		 1. yes \n		 2. no");
//		switching = scan.nextInt();
		//hard coded: 1 always changing the choice		2 keeps the first choice
		switching=1;
		switch(switching) {
		case 1:
			secondChoice();
			if(secondChoice==bingo) {
				switchAndWin++;
				System.out.println("********CONGRATULATIONS********\n You switched your choice and win.");
			}else {
				System.out.println("You lose.");
			}
			break;
		case 2:
			if(choice == bingo) {
				stickAndWin++;
				System.out.println("********CONGRATULATIONS********\n You sticked with your choice and win.");
			}else {
				System.out.println("You lose.");
			}
			}
			
		}

	public int randomNum() {
		// gets a random number between the lower and upper range;
		return 1 + (int) (Math.random() * 3); // randomNum = minimum + (int)(Math.random() * maximum);
	}

	public void bingo() {
		bingo = randomNum();
	}

	public int openOne() {
		while (true) {
			int num = randomNum();
			if (num != bingo && num != choice) {
				return num;
			}
		}
	}

	public void secondChoice() {
		while (true) {
			secondChoice = randomNum();
			if (secondChoice != openOne() && secondChoice != choice)
				break;
		}
	}
	
	public static void printResult() {
		System.out.println("Changed choice and win : "+switchAndWin+ (switchAndWin > 1 ?" times":" time"));
		System.out.println("Did not change your choice and win : "+stickAndWin+ (stickAndWin>1 ?" times":" time"));
		
	}
	
	
}
