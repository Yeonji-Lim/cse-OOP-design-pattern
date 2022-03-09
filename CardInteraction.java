
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
		CardOrder order = new CardOrder("Jane Black");
		System.out.print(order.getSampleCard());

	}

	//repeatedly requests and reads name from user
	//until valid (i.e. <=28 chars and contains at least one space
	//finally returns the valid text
	private String getNameFromUser() {
		//use this value until more code written
		return "Bob Black";
	}
	
	//repeatedly requests and reads number from user
	//until valid number entered i.e. between 1 and 1000
	//finally returns the valid number	
	private int getNumberFromUser() {
		//use this number until more code written
		return 50;
	}
	

}


