
/*
 * OOP Assignment 1
 * Contains methods for interaction with user
 */
import java.util.Scanner;
public class CardInteraction {
	private Scanner scanner;
	private CardOrder card;
	
	public CardInteraction() {
		scanner = new Scanner(System.in);
	}
	
	//runs the program as follows:
	//Gets details of card name from user
	//Displays card
	//Repeatedly, until user responds ok
	//	Asks the user if they would like to change the border
	//	If so, change the border and print the new card
	//Print the price of the order
	//print whether a discount is applicable or not
	public void run() {
		//Alter this gradually to add more details
		card = new CardOrder(getNameFromUser());
		System.out.println();

		System.out.println("Here is a sample card:\n");
		System.out.print(card.getSampleCard());
		System.out.println();

		System.out.print("Enter “OK” if this card is ok, otherwise enter an alternative border character: ");
		String cmd = scanner.nextLine();
		while(!cmd.equals("OK")) {
			card.setBorder(cmd.charAt(0));
			System.out.println("Here is a sample card:\n");
			System.out.print(card.getSampleCard());
			System.out.println();

			System.out.print("Enter “OK” if this card is ok, otherwise enter an alternative border character: ");
			cmd = scanner.nextLine();
		}
		System.out.println();

		card.setNumCards(getNumberFromUser());
		System.out.println();
		
		System.out.println("The price of " +card.getNumCards()+ " cards is " +(int)card.getFinalCost()+ " won.");
		System.out.println();

		if(card.hasDiscount()) System.out.println("10% discount applied");
		else System.out.println("No discoint given");
		System.out.println();
	}

	//repeatedly requests and reads name from user
	//until valid (i.e. <=28 chars and contains at least one space
	//finally returns the valid text
	private String getNameFromUser() {
		//use this value until more code written
		String name;
		do{
			System.out.print("Enter name: ");
			name = scanner.nextLine();
		} while(!CardOrder.nameIsValid(name));
		return name;
	}
	
	//repeatedly requests and reads number from user
	//until valid number entered i.e. between 1 and 1000
	//finally returns the valid number	
	private int getNumberFromUser() {
		//use this number until more code written
		System.out.print("How many cards would you like? ");
		int num = scanner.nextInt();
		while(num < 1 || 1000 < num) {
			System.out.println("Not A Valid Number");
			System.out.print("How many cards would you like? ");
			num = scanner.nextInt();
		}
		return num;
	}
	
}


