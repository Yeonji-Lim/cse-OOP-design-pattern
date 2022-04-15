class NameException extends RuntimeException {}   

/**
 * OOP Assignment One
 * CardOrder class keeps details of one card order
 * and provides methods to print a card 
 * and determine the price
 *
 */
public class CardOrder {
	private Name name;  	//the name printed on the card
	private char border;    //the card border
	private int numCards;   //the number of cards to be printed

	private static char space = ' ';
	private String initials;

	private static final int CARD_LEN = 32;  //the length of the card in characters
	
	//initialises name from value in parameter
	//and sets other instance variables to suitable default values
	//you can create a Name from a single string after L5
      //If you want to start before then, just write name = new Name("A", "B", "C") in the constructor!
	public CardOrder(String fullName) throws NameException {
		if(!nameIsValid(fullName)) { throw new NameException(); }
		String[] nameArr = fullName.split(" ");
		if(nameArr.length == 2) name = new Name(nameArr[0], nameArr[1]);
		else name = new Name(nameArr[0], nameArr[1], nameArr[2]);
		initials = name.getInits();
		border = '*';
		numCards = 0;
	}
	
	///////////////////////////////////////////
	//accessor/mutator methods

	public String getInitials() { return initials; }

	public String getFormattedName() {
		String formatted;
		if(initials.length() == 3) formatted = name.getFirstName() +space+ initials.charAt(1) +space+ name.getLastName();
		else formatted = name.getFirstAndLastName();
		return formatted;
	}

	public static boolean nameIsValid(String fullName) {
		if(fullName.length() > 28 || fullName.indexOf(space) == -1) {
			System.out.println("Not A Valid Name");
			return false;
		}
		return true;
	}
	
	//returns the character used in the border
	public char getBorder() { return border; }
	
	//sets the character used in the border 
	//to that provided in the parameter
	public void setBorder(char ch) { border = ch; }
	
	//returns the name 
	public Name getName() { return name; }
	
	//sets the name used in the card
	//to that provided in the parameter
	public void setName(Name _name) { name = _name; }
	
	//returns the number of cards to be printed
	public int getNumCards() { return numCards; }
	
	//sets the number of cards to be printed 
	//to that provided in the parameter
	public void setNumCards(int n) { numCards = n; }
	///////////////////////////////////////////
	
	//returns a sample card, including a newline at the end of each line
	public String getSampleCard() {
		return getTopLine() + getBlankLine() + this.getLineWithName()
		       + getBlankLine() + getTopLine();
	}
	
	//returns a String containing the top or bottom line
	//of a card, including a newline character at the end
	private String getTopLine() {
		//use this value until more code written
		String topLine = initials;
		for(int i = 0; i < CARD_LEN-initials.length()*2; i++) topLine += border;
		topLine += initials;
		return topLine+"\n";
	}
	
	//returns a String containing the blank line
	//of a card, with a border char at each end
	//and including the newline character	
	private String getBlankLine() {	
		//use this value until more code written
		String blankLine = ""+border;
		for(int i = 0; i < CARD_LEN-2; i++) blankLine += space;
		blankLine += border;
		return blankLine+"\n";
	}
	
	//returns a String containing the name line
	//of a card, including name, padding and border
	//and including the newline character	
	private String getLineWithName() {
		//use this value until more code written
		int nameLen = getFormattedName().length();
		String nameLine = ""+border;
		if(nameLen%2 == 1) nameLine += space;
		for(int i = 0; i < (CARD_LEN-2-nameLen)/2; i++) nameLine += space;
		nameLine += getFormattedName();
		for(int i = 0; i < (CARD_LEN-2-nameLen)/2; i++) nameLine += space;
		nameLine += border;
		return nameLine+"\n";
	}
	
	//returns the price of one card
	//in pounds (i,e either 0.20 or 0.25)
	//based on the number of characters in the name to be printed
	//0.20 if <=12 otherwise 0.25
	public double getCardPrice() {
		//use this value until more code written
		double price = 40;
		if(getFormattedName().length() > 12) price += 10;
		return price;
	}

	//returns the final cost of the order
	//which is the number of cards multiplied by the card price
	//and reduced by 10% if >= 100 cards
    public double getFinalCost() {
		//use this value until more code written
		double cost = getCardPrice();
		if(hasDiscount()) cost *= 0.9;
		return cost * numCards;   	
    }
    
    //returns true if number of cards < 100, false otherwise
    public boolean hasDiscount() {
		if(numCards < 200) return false;
		else return true;
    }
}
