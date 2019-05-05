// import java.util.Scanner;
// import java.util.Random;
// import java.lang.*;
// public class Project1{
//     public static Scanner scanner = new Scanner(System.in);
//     public static void main(String[] args) {
//         try{
//             //declare variable for user option
//             int menuOption = 0;
//             do{
//             //setting menu option equal to the return of showMenu()
//             menuOption = showMenu();
//             //switching on the value given by the user
//                 switch(menuOption){
//                     case 1:
//                         valueContent();
//                     break;
//                     case 2:
//                         consonantContent();
//                         break;
//                     case 3: 
//                     analyseContent();
//                     break;
//                     case 5:
//                     System.exit(0);
//                 }
//             }while(menuOption != 5);
//           }catch(Exception ex){
//               // Error Message
//             System.out.println("Sorry problem occured within Program");
//             // flushing scanner
//             scanner.next();
//           }finally {
//             // Ensuring that scanner will always be closed and cleaning up
//             // resources
//             scanner.close();
//          }

//         }

//     public static int showMenu(){
//             // Declaring var for user option and defaulting to 0
//             int option = 0;

//             // Printing menu to screen
//             System.out.println("Menu:");
//             System.out.println("1.Vowel Content");
//             System.out.println("2.Consonant Content");
//             System.out.println("3.Analyse word/sentence/phrase");
//             System.out.println("4. Print many times");
//             System.out.println("5. Quit Program");
    
//             // Getting user option from above menu
//             System.out.println("Enter Option from above...");
//             option = scanner.nextInt();
    
//             return option;
    
//     }
//     public static void valueContent(){
//         String word;
//         boolean finished = false;
//         int aVowel = 0;
//         int eVowel = 0;
//         int iVowel = 0;
//         int oVowel = 0;
//         int uVowel = 0;
//         String vowels = "aeiou";
//         System.out.println("Enter a word sentance or phrase to check its vowel content... ");
//         int numberofvowels = 0;
//        do{
//             word = scanner.nextLine().toLowerCase();
//             // checkVowelFrequency(word);
//             // checkAllVowels(word);
//             // checkVowelFrequency(word);
//             /**
//              * first checks is each charavter is equal to a vowel then,
//              * check if the position k is equal to the position j
//              * first check k agaisnt the string 'a' 'e' 'i' 'o' 'u'
//              * then k is incrementted and checks the string again
//              */
//             for(int k = 0; k < word.length(); k++){
//                 char a = word.charAt(k);
//                 if(a == vowels.charAt(0)){
//                    aVowel++;

//                 }
//                 if(a == vowels.charAt(1)){
//                     eVowel++;
//                 }
//                 if(a == vowels.charAt(2)){
//                     iVowel++;
//                 }
//                 if(a == vowels.charAt(3)){
//                     oVowel++;
//                 }
//                 if(a == vowels.charAt(4)){
//                     uVowel++;
//                 }
//                 //System.out.println("Here");
//                 for(int j = 0; j < vowels.length(); j++){
//                     char w = vowels.charAt(j);
//                 // System.out.println("Here Now");
//                     if(a==w){
//                         numberofvowels++;
                        
//                     }
                    
//                 }
            
//                 finished=true;
//             }
            
//        }while(!finished);
//        //if word contains no vowels
//        if(numberofvowels == 0){
//         System.out.println("\nWord contains 0 vowels\n");
//     }else{
//         //create array for the frequency of each vowel
//      int[] frequency = {aVowel,eVowel,iVowel,oVowel,uVowel};

//      System.out.println("\nThe frequency of each vowel:");
//      //itterate through arrau and check if each position is greater than 0
//          for(int i = 0; i < frequency.length; i++){
//              if(frequency[i] > 0){
//                 // char letter = vowels.charAt(i);
//                 // char letterUpper = Character.toUpperCase(letter);
//                  //if > 0, print the letter and its frequency
//                 // result +=  Character.toUpperCase(vowels.charAt(i)) + "("+frequency[i]+")"+"\n";
//                  System.out.print( Character.toUpperCase(vowels.charAt(i)) + "("+frequency[i]+")"+"\n");
//              }
            
//          }
//         // result2 = "Total number of vowels: " +numberofvowels+"\n";
//          System.out.println("Total number of vowels: " +numberofvowels+"\n");
//      }
       
//     }
//     public static void analyseContent(){
//         String word;
//         String result;
//         String vowels = "aeiou";
//         boolean finished = false;
//         String [] words;
//         String row1 = "qwertyuiop";
//         String row2 = "asdfghjkl";
//         String row3 = "zxcvbnm";
//         boolean Orow = false,Trow = false,Erow = false;
//         System.out.println("Enter a word sentance or phrase to analyse its content... ");
        
//         do{
//             word = scanner.nextLine().toLowerCase();
//             words = word.split("\\s+");
//             Orow = checkRow(word,row1);
//             Erow = checkRow(word,row2); 
//             Trow = checkRow(word,row3);
//             result = checkAllVowels(word, vowels);
                   
//             //finished=true;

            
//         }while(!finished);
//         System.out.println("\n*/******************************/*");
//         System.out.println("There are "+ words.length+" words in this sentence");
//         if(Orow && Trow && Erow){
//             System.out.println("The word/sentence/phrase can be written using all rows of the keyboard");

//         }else if(Orow && Trow && !Erow){
//             System.out.println("The word/sentence/phrase can be written using the 1st & 3rd rows of the keyboard");
//         }else if(Orow && Erow && !Trow){
//             System.out.println("The word/sentence/phrase can be written using the 1st & 2nd rows of the keyboard");
//         }else if(Trow && Erow && !Orow){
//             System.out.println("The word/sentence/phrase can be written using the 2nd & 3rd rows of the keyboard");
//         }else if(Trow && !Erow && !Orow){
//             System.out.println("The word/sentence/phrase can be written using 3rd row of the keyboard");
//         }
//         else if(!Trow && Erow && !Orow){
//             System.out.println("The word/sentence/phrase can be written using the 2nd row of the keyboard");
//         }
//         else if(!Trow && !Erow && Orow){
//             System.out.println("The word/sentence/phrase can be written using 1st of the keyboard");
//         }

//         System.out.println("\n"+result);

//         System.out.println("*/******************************/*");
//     }
//     public static void consonantContent(){

//     }

//     public static boolean checkRow(String word, String row){
//         boolean onRow = false;
//         for(int h=0;h<word.length()-1; h++){
//             char letter = word.charAt(h);
//             for(int l = 0; l<row.length()-1; l++){
//                 char r = row.charAt(l);
//                 if(letter == r)
//                     onRow = true;
//             }
//         }
//         return onRow;
//     }

//     public static String checkAllVowels(String word, String vowels){       

//         int aVowel = 0;
//         int eVowel = 0;
//         int iVowel = 0;
//         int oVowel = 0;
//         int uVowel = 0;
//         int numberofvowels = 0;
//         String result = "", result2 = "";

//         for(int k = 0; k <= word.length()-1; k++){
//             char a = word.charAt(k);
//             if(a == vowels.charAt(0)){
//                aVowel++;

//             }
//             if(a == vowels.charAt(1)){
//                 eVowel++;
//             }
//             if(a == vowels.charAt(2)){
//                 iVowel++;
//             }
//             if(a == vowels.charAt(3)){
//                 oVowel++;
//             }
//             if(a == vowels.charAt(4)){
//                 uVowel++;
//             }
//             //System.out.println("Here");
//             for(int j = 0; j < vowels.length(); j++){
//                 char w = vowels.charAt(j);
//             // System.out.println("Here Now");
//                 if(a==w){
//                     numberofvowels++;
                    
//                 }
                
//             }
//         }
//         if(numberofvowels == 0){
//             System.out.println("\nWord contains 0 vowels\n");
//         }else{
//             //create array for the frequency of each vowel
//          int[] frequency = {aVowel,eVowel,iVowel,oVowel,uVowel};
 
//          System.out.println("\nThe frequency of each vowel:");
//          //itterate through arrau and check if each position is greater than 0
//              for(int i = 0; i < frequency.length; i++){
//                  if(frequency[i] > 0){
//                     // char letter = vowels.charAt(i);
//                     // char letterUpper = Character.toUpperCase(letter);
//                      //if > 0, print the letter and its frequency
//                      result +=  Character.toUpperCase(vowels.charAt(i)) + "("+frequency[i]+")"+"\n";
//                     // System.out.print( Character.toUpperCase(vowels.charAt(i)) + "("+frequency[i]+")"+"\n");
//                  }
                
//              }
//              result2 = "Total number of vowels: " +numberofvowels+"\n";
//              //System.out.println("Total number of vowels: " +numberofvowels+"\n");
//          }
//         return result + " "+result2;
//     }
// }

