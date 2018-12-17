// import javax.swing.JOptionPane;

// // import jdk.incubator.http.internal.frame.GoAwayFrame;

// import java.io.*;      
// import java.util.*;

// public class Create{
//     public static File aFile;
//     public static ArrayList<String> names;
//     public static Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) throws IOException
 
//     {
//         int players = Integer.parseInt(JOptionPane.showInputDialog(null, "Players"));
//         int groups = Integer.parseInt(JOptionPane.showInputDialog(null, "Groups"));
//         int ppg = players/groups;
//         int groupStages = groups*2;
//         int index = 0;
//         int groupNumber = 1;
//         PlayerFactory playerss = new PlayerFactory();
//         Players[] player = new Players[ppg];
//         //create groups
//         Group[] group = new Group[groups];
//         Group[] groupStage = new Group[groups];
//         //create tournament
//         Tournament tournament = new Tournament(group);

        
        
        
//         for(int i = 0; i < group.length; i++){
//             //create players for each group
//             player = createPlayers(ppg, index);
//             //create the finsihed group
//             group[i] = createGroup(groupNumber, player);
//             groupNumber++;
//             index = index + ppg;
//         }

        

        
//         // setPoints(group);

//         for(int i = 0; i < group.length; i++){
//             // player[i].setPoints(i + 1);
//             //set positions
//             // group[i].setGroupPositions();
//              //create fixtures for that group
//             System.out.println(group[i].toString());
//             //generate tournament
//             createFixtures(group[i]); //move this to tournament
            
//         }
//         try{
//             //declare variable for user option
//             int menuOption = 0;
//             do{
//             //setting menu option equal to the return of showMenu()
//             menuOption = showMenu();
//             //switching on the value given by the user
//                 switch(menuOption){
//                     case 1:
//                         enterScores(group);
//                     break;
//                     case 2:
//                         progressGroup(group, groupStage);
//                     break;
//                     case 3:
//                         System.exit(0);
//                         break;
//                 }
//             }while(menuOption != 3);
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

//         // enterScores(fixtures);

//     }

//     public static int showMenu(){
//         // Declaring var for user option and defaulting to 0
//         int option = 0;

//         // Printing menu to screen
//         System.out.println("Menu:");
//         System.out.println("1. Enter Scores");
//         System.out.println("2. Progress Teams");
//         System.out.println("3. Quit Program");


//         // Getting user option from above menu
//         System.out.println("Enter Option from above...");
//         option = scanner.nextInt();

//         return option;

//     }

//     public static void progressGroup(Group[] group, Group[] secondRound){
//         int gn = 1;
//         int j = 0;
// 		int index = 8;
//         //2 players per group
//         for(int i = 0; i < group.length-1; i += 2){
//             Players[] players = new Players[2];
//             Players[] playersTwo = new Players[2];

//             //get players at first and second positions from each group
//             players[0] = group[i].getPlayer(0);
//             players[1] = group[i+1].getPlayer(1);     
            
//             playersTwo[0] = group[i+1].getPlayer(0);
//             playersTwo[1] = group[i].getPlayer(1); 
//             //make group
//             secondRound[j] = createGroup(gn, players);
//             secondRound[j+index] = createGroup((gn+index), playersTwo);
//             //incerement group number
//             gn++; j++;
//         }
//         //debuging
//         for(int i = 0; i < secondRound.length; i++){
//             System.out.println(secondRound[i].toString());
//         }
//     }

//     public static void enterScores(Group[] group){
//         int groupNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Group Number"));
//         int playerID = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Home Player ID"));
//         int playerIDTwo = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Away Player ID"));
//         int scoreOne = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Home Score"));
//         int scoreTwo = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Away Score"));

//         group[groupNumber-1].getPlayer(playerID-1).setResult(scoreOne, scoreTwo);
//         group[groupNumber-1].getPlayer(playerIDTwo-1).setResult(scoreTwo, scoreOne);


//         for(int i = 0; i < group.length; i++){
//             group[i].setGroupPositions();
//             System.out.println(group[i].toString());
            
//         }
//     }

//     public static void setPoints(Group[] group){
//         for(int i = 0; i < group.length; i++){
//             //set points
//             int points = Integer.parseInt(JOptionPane.showInputDialog(null, "Set Points"));
//             //set positions
//             group[i].getPlayer(i).setPoints(points);
//         }
//     }

//     public static Group createGroup(int gn, Players[] names){
//         Group group = new Group(gn,names);
//         return group;
//     }


//     public static void createFixtures(Group group){
//         int teams = 0;
//         teams = group.size();
//           // If odd number of teams add a "ghost".
//           boolean ghost = false;
//           if (teams % 2 == 1) {
//               teams++;
//               ghost = true;
//           }
//                 // Generate the fixtures using the cyclic algorithm.
//                 int totalRounds = teams - 1;
//                 int matchesPerRound = teams / 2;
//                 String[][] rounds = new String[totalRounds][matchesPerRound];
//                 for (int round = 0; round < totalRounds; round++) {
//                     for (int match = 0; match < matchesPerRound; match++) {
//                         int home = (round + match) % (teams - 1);
//                         int away = (teams - 1 - match + round) % (teams - 1);
//                         // Last team stays in the same place while the others
//                         // rotate around it.
//                         if (match == 0) {
//                             away = teams - 1;
//                         }
//                         // Add one so teams are number 1 to teams not 0 to teams - 1
//                         // upon display.
//                         rounds[round][match] = group.getName((home)) + " v " + group.getName((away));
//                     }
//                 }
                
//                 // Interleave so that home and away games are fairly evenly dispersed.
//                 String[][] interleaved = new String[totalRounds][matchesPerRound];
                
//                 int evn = 0;
//                 int odd = (teams / 2);
//                 for (int i = 0; i < rounds.length; i++) {
//                     if (i % 2 == 0) {
//                         interleaved[i] = rounds[evn++];
//                     } else {
//                         interleaved[i] = rounds[odd++];
//                     }
//                 }
                
//                 rounds = interleaved;
        
//                 // Last team can't be away for every game so flip them
//                 // to home on odd rounds.
//                 for (int round = 0; round < rounds.length; round++) {
//                     if (round % 2 == 1) {
//                         rounds[round][0] = flip(rounds[round][0]);
//                     }
//                 }
                
//                 // Display the fixtures        
//                 for (int i = 0; i < rounds.length; i++) {
//                     System.out.println("Round " + (i + 1));
//                     System.out.println(Arrays.asList(rounds[i]));
//                     System.out.println();
//                 }
                
//                 System.out.println();
                
//                 if (ghost) {
//                     System.out.println("Matches against team " + teams + " are byes.");
//                 }
                
//                 System.out.print("Use mirror image of these rounds for "
//                     + "return fixtures.\n\n");
//     }



//     private static String flip(String match) {
//         String[] components = match.split(" v ");
//         return components[1] + " v " + components[0];
//     }

//     // public static Players[] createPlayers(int ppg, int number) throws IOException{
//     //     int id = 0;
//     //     int w = 0;
//     //     int d = 0;
//     //     int l = 0;
//     //     int points = 0;
//     //     String name = "";
//     //     Players[] player = new Players[ppg];

//     //     String filename = "names.txt";  
//     //     aFile = new File(filename);
//     //     if (!aFile.exists())  
//     //         createFile(filename);
//     //     else{
//     //         names = new ArrayList<String>();
//     //         Scanner in = new Scanner(aFile);
//     //         String aLineFromFile;		
//     //         while(in.hasNext())
//     //         {
//     //           aLineFromFile = in.nextLine();
//     //            aLineFromFile = aLineFromFile.replaceAll(",$", "");
//     //             names.add(aLineFromFile);
//     //         }
//     //         in.close();

//     //         Random rand = new Random();
//     //         int n = 0;
//     //         while(n < ppg){
//     //             boolean inList = false;
//     //             if(!inList){
//     //                 name = names.get(number);
//     //                 player[n] = new Players(id,name, w, d, l, points);
//     //                 id++;
//     //                 number++;
//     //                 n+=1;
//     //             }
                
//     //         }
//     //     }
//     //     return player;
//     // }


//     public static void createFile(String filename) throws IOException
//     { 
//     PrintWriter output = new PrintWriter(aFile);
//     // output.println(1 + "," + nameOfTournament+ "," + w + "," + d + "," + l);   
//     output.close();
//     }
// }