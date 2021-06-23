//create a class for HW2//
public class HW2{
  
  /* this method determines as if the first numbers of characters each input are exactly the same 
   */
  public static boolean samePrefix(String string1, String string2, int num){
    
    /*check is the given position is within a string or not,
     only true if it is within the string. */
    if (num < string1.length() && num < string2.length()){ 
      
      /* this loop will scan through each index of the stirng. 
       if at each index before the position there is any different characters, 
       it should return false
       */ 
      for (int index = 0; index < num; index++){
        
        //it will return false if the start character in this given position is different//
        if (string1.charAt(index) != string2.charAt(index)){
          return false;
        }
      }
      
      //return true if they have same first character at the given position
      return true;
    }
    
    //return false if the checking start position is not in the string// 
    else {
      return false;
    }
  }
  
  /*
   a method removes the characters in string 1 repects to order of string2. 
   It will remove the first occurence of the same character in string1, and only 
   remove the next first same occurnece of character in string1 after the removed character.
   If no character is removed, then nothing is removed next.
   */
  public static String subtract(String string1, String string2){
    
    //build a new string for output//
    StringBuilder builder = new StringBuilder();
    
    //create a variable loop index/
    int index = 0; 
    
    //create a limit for the variable in avoiding the out of bound.
    if (index < string1.length()) {
      
      /* this loop will scan through the each character in the string1. 
       The goal is it won't append the first occurence of a character in string 1 
       that the same as the string2, respectively going through each character in the second string*/
      for (int i = 0; i < string1.length(); i++) {
        
        //this limits the index just to be the same as the numbers of character in string 2//
        if (index < string2.length()) {
          
          //this will return the first occurence letter in string1 that is not match the letter in string2// 
          if (string1.charAt(i) != string2.charAt(index)) {
            builder.append(string1.charAt(i));
          }
          
          //if the letter matches, it will be skipped and the loop will continue//
          else {
            
            index++;
          }
        }
        
        //if the index is now smaller than number of character in string1 but it already scannes each character with the string2//
        //return the rest letter//
        else {
          builder.append(string1.charAt(i));
        }
      }
    }
    
    //this will return the new string after the removall//
    return builder.toString();
  }
  
  /*this private method will check as if a string contains only digits or not*/
  private static boolean isDigit(String s){
    
    //create a varaible for checking//
    boolean isDigit = false;
    
    //this loop to check if every character in the string is digit or not//
    //if all the characters are digit, then it will return true//
    for( int i = 0;i < s.length();i++)
      //it is only return true if every character is digit
      if(Character.isDigit(s.charAt(i)))
      isDigit = true;
    
    return isDigit; 
  }
  
  
  /* this method returns a string from using each digit in all-digit string2 as 
   an index to identify the matched character in string1 and put it in the output string.
   */
  
  public static String indexWord(String string1, String string2){
    
    //create a new string// 
    StringBuilder builder = new StringBuilder(); 
    
    //this method only works if the second string contains only digits and first string must at least 10 character//
    if (isDigit(string2) && string1.length() > 9){
      
      /* this loop will scan through each character in the second string,
       convert those char digits to int digits and use it as an index to identify character in string1
       */
      for (int index = 0; index < string2.length(); index++){
        
        //this char c only use inside this loop. It represent the character in each position of second string//
        char c = string2.charAt(index);
        
        //this int d only use inside this loop. It will convert the char digit in each position into a int digit
        int d = Character.getNumericValue(c);
        
        /*this will build the output string as using the int digit from the second string
         as an index to indentify the character from the first input string. 
         */
        builder.append(string1.charAt(d));
      }
    }
    //return the new output string//
    return builder.toString();
  }
  
  /*This method returns the string content the same contents as the input string,
   but if there is any extra spaces betweens words, and before and after the string
   */
  public static String removeExtraSpaces(String str){
    
    //create a new String//
    StringBuilder builder = new StringBuilder();
    
    //create a variable for checking inside the loop//
    int index = 0; 
    
    /*loop through each character in the string 1. 
     If at an index or only one whitespace, it is a character, then it will append.
     If there is more than one white space/whitespace before and the end of string, it should not be append
     */
    for (int i = 0; i < str.length() ; i++){
      
      /*if the first character is a white space,
       it will skip until it reaches the charater that is not whitespace
       */
      if(Character.isWhitespace(str.charAt(index))){
        index++;
      }
      
      //this will append every character in the string that is not whitespace//
      else if (!Character.isWhitespace(str.charAt(i))){
        builder.append(str.charAt(i));
      }
      
      
      //this will check the space and extra space.
      else if (Character.isWhitespace(str.charAt(i)) && (i+1) < str.length()){
        
        /* If there is only one space, it will be appended. 
         If ther is more than one space, 
         it will be skipped and only append if it is followed by a non-whitespace character
         */
        if (!Character.isWhitespace(str.charAt(i+1))){
          builder.append(str.charAt(i));
        }
      }
    }
    //return the string that has no extra spaces between words, before and after string.
    return builder.toString();
  }
  
  // a method that reverse word in the string but not change the order of those words//
  public static String flipWords(String str) {
    
    //create a new string to use inside the loop//
    StringBuilder temp = new StringBuilder();
    
    //create a new string for return//
    StringBuilder builder = new StringBuilder();
    
    //this variable use to count the current word in the loop//
    int currentWord = 0; 
    
    /*this will scan through it character in the loop. 
     * It use to determine from the character that is non-letter and flip. 
     */
    for (int index = 0; index < str.length(); index++) {
      
      //create a variable char c that represent for the character at each index of the input string/
      char c = str.charAt(index);
      
      //check as if char c is a letter or not//
      //if char c is not a charater or the last char of the string, then it will use at a point to flip all the letter before it//
      
      if (!Character.isLetter(c) || index == str.length()-1) {
        
        //case that char c is not a character//
        if(!Character.isLetter(c)){
          
          //this has done of scanning a word in a string, and it will reverse the letter in the word and store in the temp string//
          for (int j = index-1; j >= currentWord; j--) {
            temp.append(str.charAt(j));
          }
          //this will store the temp string to the return string//
          builder.append(temp); 
          
          //this will store the non-letter character into the return string//
          builder.append(c);
          
          //this will return an empty temp string to use in the loop//
          temp = new StringBuilder(); 
          
          //this will count the current word to the next word for avoiding copy old words and flip//
          currentWord = index + 1;
        }
      }
      
      //case that it is the last char of the string//
      if(index == str.length()-1){
        
        //this loop will return the last words backward and append it to the builder//
        for (int j = index ; j >= currentWord; j--){
          builder.append(str.charAt(j));
        }
      }
    }
    
    //this to return the flipped words string. 
    return builder.toString();
  }
  
  
  /*a method that takes a string and an int n, and it will return a stings that 
   each word in the string will be repeated n times.  
   */
  public static String repeatWords(String str, int times){
    
    //create a string for using in the loop//
    StringBuilder temp = new StringBuilder();
    
    //create a string for return//
    StringBuilder builder = new StringBuilder(); 
    
    /* this will loop through the string and repeat the n time english word
     It won't repeat any non-word in the string.  
     It will use the cut-off as the non-letter character and build it in temp string for repeating. 
     After that, the temp string should be empty and use for the next word.
     */
    for (int i = 0; i < str.length(); i++){
      
      //this variable represent for the character at an index//
      char c = str.charAt(i); 
      
      //if at the index, the character is a letter, then it will append to temp//
      if (Character.isLetter(c)){
        temp.append(c);
      }
      
      /* if at an index, it is not a letter, then all the letter before it should be repeated. 
       Or if the string ends wih a word,  this word should be repeated.
       */
      if (!Character.isLetter(c) || (i == str.length() -1)){
        
        //this is to repeat times-1 of the word with the whitespace between it//
        for (int j = 0; j < times ; j++){
          if (j < times - 1 && temp.length() != 0){
            builder.append(temp); 
            builder.append(' ');
          }
          
          //this is repeat last times of the word and follow with any non-letter character as the same as the original string
          if (j == times -1){
            builder.append(temp); 
          }
        }
        
        //this will append the non-letter character in the string as the way it appears in the original string
        if (!Character.isLetter(c)){
          builder.append(c);  
        }
        
        //this will return an temp string to build use for the next word
        temp = new StringBuilder();
      }
    }
    
    //this will return a new string with those words repeat
    return builder.toString(); 
  }
  
  //this method will reverse both the columns and rows of an array
  public static void reverse(int[][] array) { 
    
    //intialize the start and end rows of the array
    int start = 0;
    int end = array.length-1; 
    
    /*the big loop will swap the position in reversed order
     the small loop will swap the columns within each row.
     */
    while (start <= end) {
      int[]temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      
      // if the index of the end and start is different, then it will swap from both end//
      if (start != end) { 
        
        //create an array to reverse the order of column in a row//
        int [] reverseColumns = new int[array[end].length];
        
        //loop for reverse the order of the columns in an end row //
        for (int index = 0; index < reverseColumns.length; index++) {
          reverseColumns[index] = array[end][array[end].length-1-index];
        }
        
        //this will store the reverse columns in a row which later be reversed in an end array.
        array[end] = reverseColumns;
        
        //create an array to reverse the orer of the columns in a start row//
        int [] reverseColumns2 = new int[array[start].length];
        
        //loop for reverse the order of the columns in a start row//
        for (int index = 0; index < reverseColumns2.length; index++) {
          reverseColumns2[index] = array[start][array[start].length-1-index];
        }
        
        //this will store the reverse columns in a eow which later be reversed in an end array
        array[start] = reverseColumns2;
      }
      
      //if the index of end and start is the same, so it only reverse one time
      if (start == end) {
        
        //create an order to reverse the order of column in a row//
        int [] reverseMiddleArray = new int[array[end].length];
        
        //loop for reverse the order of the column in and end row //
        for (int index = 0; index < reverseMiddleArray.length; index++) {
          reverseMiddleArray[index] = array[end][array[end].length-1-index];
        }
        
        //this will store the reverse columns in a row which later be reversed in an end array.
        array[end] = reverseMiddleArray;
      }
      
      //this is avoid the loop to be out of bound since the big loop must be stopped when start = end
      start++;
      
      //this will avoid further swap in a loop
      end--;
    }
  }
}

        
