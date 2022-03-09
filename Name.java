//Basics 3
public class Name {
  private String firstName;
  private String middleName;
  private String lastName;

  public Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
  }

  public Name(String fName, String lName) {
    firstName = fName;
    middleName = "";
    lastName = lName;
  }
  
  //getter
  public String getFirstName() {return firstName; }
  public String getMiddleName() { return middleName; }
  public String getLastName() {return lastName; }
  
  //setter
  public void setFirstName(String fn) { firstName = fn; }
  public void setMiddleName(String mn) { middleName = mn; }
  public void setLastName(String ln) { lastName = ln; }
  
  //custom getter
  public String getFirstAndLastName() { return firstName + " " + lastName; }
  public String getLastCommaFirst() { return lastName + ", "+ firstName; }

  public String getInits() {
    if(middleName.length() == 0) return firstName.substring(0, 1) + lastName.substring(0, 1);
    else return firstName.substring(0, 1) + middleName.substring(0, 1) + lastName.substring(0, 1);
  }

}

