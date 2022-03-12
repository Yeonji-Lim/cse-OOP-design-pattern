//Basics 5
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("-----Name Class Test-----");
		System.out.println();

		Name n1 = new Name("Jane", "Black");
		System.out.println(n1.getInits() + " " + n1.getFirstAndLastName());
		System.out.println(n1.getLastCommaFirst());
		System.out.println();
		
		Name n2 = new Name("Mary", "Ann", "Smith");
		System.out.println(n2.getInits() + " " + n2.getFirstAndLastName());
		System.out.println(n2.getLastCommaFirst());
		System.out.println();

		System.out.println("-----Name Class Test-----");
		System.out.println();

		try {
			CardOrder co1 = new CardOrder("fullNameString");
		} catch (NameException e) {
			System.out.println("Not A Valid Name");
		}

		try {
			CardOrder co2 = new CardOrder("fullNameString that is over 28");
		} catch (NameException e) {
			System.out.println("Not A Valid Name");
		}

		try {
			CardOrder co3 = new CardOrder("Yeonj Lim");
			System.out.println(co3.getInitials());
			System.out.println(co3.getFormattedName());
			co3.setBorder('#');
			co3.setNumCards(10);
			System.out.println(co3.getSampleCard());
		} catch (NameException e) { System.out.println("Not A Valid Name"); }

		try {
			CardOrder co3 = new CardOrder("Hyeonseong Donggang Lim");
			System.out.println(co3.getInitials());
			System.out.println(co3.getFormattedName());
			co3.setBorder('@');
			co3.setNumCards(210);
			System.out.println(co3.getSampleCard());
		} catch (NameException e) { System.out.println("Not A Valid Name"); }

	}

}
