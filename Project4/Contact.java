import java.util.Comparator;

/**
 * a class Contact represent a phone/email contact 
 * @author n
 */
public class Contact implements DatabaseType<Contact>{
  
  // a private field for contact's name
  private String name;
  
  // a private field for contact's phoneNumber
  private String phoneNumber;
  
  //a private field for contact's email
  private String email;
  
  /**
   * the constructor for contact that takes contact's name, contact's phoneNumber, contact's email
   * @param name contact's name
   * @param phoneNumber contact's phoneNumber
   * @param email contact's email
   */
  public Contact(String name, String phoneNumber, String email){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }
  
  /**
   * Return contact's name
   * @return contact's name
   */
  public String getName(){
    return name;
  }
  
  /**
   * Set contact's name to the input name
   * @param name set the contact's name
   */
  public void setName(String name){
    this.name = name;
  }
  
  /**
   * Return contact's phoneNumber
   * @return contact's phoneNumber
   */
  public String getPhoneNumber(){
    return phoneNumber;
  }
  
  /**
   * Set contact's phoneNumber to the input phoneNumber
   * @param phoneNumber set the contact's phoneNumber
   */
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }
  
  /**
   * Return contact's email
   * @return contact's email
   */
  public String getEmail(){
    return email;
  }
  
  /**
   * Set the contact's email to the input email 
   * @param email set the contact's email 
   */
  public void setEmail(String email){
    this.email = email;
  }
  
  /**
   * Change the behavior of the inherited equals method. Two Contact are the same if they have the same name, phoneNumber, and email.
   * @return true only if two contacts have the same name, phoneNumber, and email. Otherwise, it is false
   */
  @Override
  public boolean equals(Object c){
    if (c instanceof Contact){
      Contact other = (Contact) c;
      return (this.getName().equals(other.getName()) && this.getPhoneNumber().equals(other.getPhoneNumber()) && this.getEmail().equals(other.getEmail()));
    }
    return false;
  }
  
  /**
   * Change behavior of the inherited toString() 
   */  
  @Override
  public String toString(){
    return ("Name: " + this.getName() + ", Phone Number: " + this.getPhoneNumber() + ", Email: " + this.getEmail() );
  }
  
  /**
   * Compare two contacts depends on the corresponding trait
   * @param trait is trait that can be name/phoneNumber/email
   * @return a Comparator compares two Contacts depends on the trait. Otherwise, the method return null
   */
  @Override
  public Comparator<Contact> getComparatorByTrait(String trait) {
    //if the trait compared is name
    if (trait.equalsIgnoreCase("name")) {
      return new Comparator<Contact>() {
        public int compare(Contact firstContact, Contact secondContact) {
          return firstContact.getName().compareTo(secondContact.getName());
        }        
      };
    }
    //if the trait compared is phoneNumber
    else if (trait.equalsIgnoreCase("phoneNumber")){
      return new Comparator<Contact>() {
        public int compare(Contact firstContact, Contact secondContact) {
          return firstContact.getPhoneNumber().compareTo(secondContact.getPhoneNumber());
        }
      };
    }
    //if the trait compared is email
    else if(trait.equalsIgnoreCase("email")) {
      return new Comparator<Contact>(){
        public int compare(Contact firstContact, Contact secondContact){
          return firstContact.getEmail().compareTo(secondContact.getEmail());  
        }
      };
    }  
    //if not those trait, return null
    else
      return null;
  }
}
