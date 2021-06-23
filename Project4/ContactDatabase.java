import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Class ContactDatabase
 * @author 
 */
public class ContactDatabase extends Database<Contact>{
  
  /**
   * print the list of contacts 
   * @param iterable is list to print
   */
  public void printList(Iterable<Contact> iterable){
    //mark each line starting from 1
    int i = 1; 
    //print out the contacts in the list and only one in each line
    for (Contact contact: iterable){
      System.out.println(i + " " + contact.toString());
      i++;
    }
  }
  
  /**
   * Main method to be used by the user.
   * @param args The command line input at run time.
   */
  public static void main(String[] args) {
    //take the input string
    Scanner scanner = new Scanner(System.in);
    
    //create a new contact database
    ContactDatabase data = new ContactDatabase();
    
    //an array list to use inside the loop
    ArrayList<Contact> list = null;
    
    //a linked list to use inside the loop
    LinkedList<Contact> alist = null;
    
    //a list to store either array list or linked list
    List<Contact> recentList = null;
    
    //a string that will hold the first word of the input 
    String command ="";
    
    /*this loop will only end if the first word of the command is quit
     Otherwise, it will do different function depends on the first word in the command
     */ 
    do {
      System.out.println("Enter the command: ");
      
      //scan for the first word of the input
      command = scanner.next();
      
      //if the first word is add, it will add the rest of the word into name, phoneNumber, email, respectively
      if (command.equalsIgnoreCase("add")) {
        
        //the name is the second "word" of the input string
        String name = scanner.next();
        
        //the phoneNumber is the third "word" of the input string
        String phoneNumber = scanner.next();
        
        //the email is the fourth "word" of the input string
        String email = scanner.next();
        
        //create a contact to hold those name, phoneNumber, and email
        Contact contact = new Contact (name, phoneNumber, email);
        
        //add the new contact to the data
        data.add(contact);
        
        //indicate that the contact has been added
        System.out.println("the contact has been added: " + contact);
      } 
      
      //if the first word is "listby", then it will sorted the data in order based on the input trait(name/phoneNumber/email).
      else if (command.equalsIgnoreCase("listby")) {
        
        //indicate the trait for sorting the data
        System.out.println("the trait: ");
        
        //the trait is the second word of the input command (if enter in one line)
        String trait = scanner.next();
        
        //check if there is any contact in the data
        if (!data.isEmpty()){
          
          //depending on the trait (name, phoneNumber, or email), it will sort the data based on those trait
          if (trait.equalsIgnoreCase("name") || trait.equalsIgnoreCase("phoneNumber") || trait.equalsIgnoreCase("email")){
            
            //store the sorted data in the list 
            list = data.getList(trait);
            
            //print out the list
            data.printList(list);
            
            //store it into the recentList
            recentList = list;
            
          } 
          
          //if the input trait is not name/phoneNumber/email, it will not require to try again
          else {
            System.out.println("Invalid trait, please try again!");
          }
        }
        
        //if there is no data
        else {
          System.out.println("No data available");
        }
      }
      
      //if the first word of the command is "find", then it will take the trait (name/phoneNumber/email) and the desired value one to find
      else if(command.equalsIgnoreCase("find")){
        //the second "word" of the input
        String trait = scanner.next();
        
        //the "word" to indicate what to find
        String value = scanner.next();
        
        //if the trait is "name"
        if(trait.equalsIgnoreCase("name")){
          
          //create a contact that have the name is same as the value and other field set to null
          Contact contact = new Contact(value, null, null);
          
          //look for the same name in the data and store it in a linked list
          alist = data.lookup(trait, contact);
        }
        
        else if(trait.equalsIgnoreCase("phoneNumber")){
          
          //create a contact that have the phoneNumber is same as the value and other field set to null
          Contact contact = new Contact(null, value, null);
          
          //look for the same phoneNumber in the data and store it in a linked list
          alist = data.lookup(trait, contact);
        }
        
        else if(trait.equalsIgnoreCase("email")){
          
          //create a contact that have the email is same as the value and other field set to null
          Contact contact = new Contact(null, null, value);
          
          //look for the same email in the data and store it in a linked list
          alist = data.lookup(trait, contact);
        }
        
        //if the trait is not those traits, in cannot process
        else {
          System.out.println("Invalid trait. Please check again!");
        }
        
        //print out the linkedlist hold the contact that has the value wants to find
        data.printList(alist);
        
        //store it into the recentList
        recentList = alist;
      }
      
      //if the first input word is delete 
      else if(command.equalsIgnoreCase("delete")) {
        //indicate which contact would be delete
        int index = scanner.nextInt();
        
        //the index in the array list starts from 0
        int position = index - 1;
        
        //only delete if the position is valid and there is contact in the data to delete and the list has the contacts to delete
        if (position >= 0){
          try {
            //if the array list has the contacts to delete
            Contact contact = recentList.get(position);
            data.delete(contact);
            System.out.println("this contact has been deleted: " + contact);
          }
          catch(Exception e){
            System.out.println("There is no data to delete");
          }
        }
        //when there is no data
        else
          System.out.println("There is no data to delete");
      }
      
    //if the first word of input is makeIndex
    else if(command.equalsIgnoreCase("makeindex")){
      
      //it will scan for the input trait (name, phoneNumber, email)
      String trait = scanner.next();
      
      //make the index of the contact by the input trait
      data.makeIndex(trait);
    }
      
      //enter each line for each command
      else
        System.out.println();
      
    } 
    //the loop continutes if the first word of the input is not quit
    while(!command.equalsIgnoreCase("quit"));
    
    //the loop ends if the first word of the input is quit
    scanner.close();
  }
}
