import javax.swing.JOptionPane;
import java.io.*;      
import java.util.*;
public class Tournament{
    private PlayerFactory player = new PlayerFactory();
    private GroupFactory groupFactory = new GroupFactory();
    private Players[] players;
    private Group[] group;
    private Group[] secondRound;
    public static Scanner scanner = new Scanner(System.in);
    boolean allFixturesPlayed = false;
    boolean tournamentCreated = false;
    public Tournament(){

    }

    //create menu
    public void CreateMenu(){
        try{
            //declare variable for user option
            int menuOption = 0;
            do{
            //setting menu option equal to the return of showMenu()
            menuOption = showMenu();
            //switching on the value given by the user
                switch(menuOption){
                    case 1:
                        OnCreate();
                    break;
                    case 2:
                    if(tournamentCreated){
                        enterScores(group);
                    }else
                        System.out.print("A tournament must be created first");
                    break;
                    case 3:
                    if(allFixturesPlayed){
                        ProgressGroup(group, secondRound);
                    }else
                        System.out.print("All fixtures must be played to progress groups!!");
                    break;
                    case 4:
                        System.exit(0);
                    break;
                }
            }while(menuOption != 3);
          }catch(Exception ex){
              // Error Message
            System.out.println("Sorry problem occured within Program");
            // flushing scanner
            scanner.next();
          }finally {
            // Ensuring that scanner will always be closed and cleaning up
            // resources
            scanner.close();
         }
    }
    //show menu
    public static int showMenu(){
        // Declaring var for user option and defaulting to 0
        int option = 0;

        // Printing menu to screen
        System.out.println("Menu:");
        System.out.println("1. Create Tournament");
        System.out.println("2. Enter Scores");
        System.out.println("3. Progress Teams");
        System.out.println("4. Quit Program");


        // Getting user option from above menu
        System.out.println("Enter Option from above...");
        option = scanner.nextInt();

        return option;

    }
    //create Tournament
    public void OnCreate() throws IOException{
        tournamentCreated = true;
        int playerSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Players"));
        int groups = Integer.parseInt(JOptionPane.showInputDialog(null, "Groups"));
        int ppg = playerSize/groups;
        int index = 0;
        int groupNumber =1;
        group = new Group[groups];
        secondRound = new Group[groups];
        //create players
        for(int i = 0; i < group.length; i++){
            //create players for each group
            players = player.createPlayers(ppg, index);             
            //create the finsihed group
            group[i] = groupFactory.CreateGroup(groupNumber, players);
            groupNumber++;
            index = index + ppg;
        }

        for(int i = 0; i < group.length; i++){
            System.out.println(group[i].toString());
            // createFixtures(group[i]); //move this to tournament
            
        }
    }

    //progress top 2 teams from each group to next stage
    public void ProgressGroup(Group[] group, Group[] secondRound){
        int gn = 1;
        int j = 0;
		int index = 8;
        //2 players per group
        for(int i = 0; i < group.length-1; i += 2){
            Players[] players = new Players[2];
            Players[] playersTwo = new Players[2];

            //get players at first and second positions from each group
            players[0] = group[i].getPlayer(0);
            players[1] = group[i+1].getPlayer(1);     
            
            playersTwo[0] = group[i+1].getPlayer(0);
            playersTwo[1] = group[i].getPlayer(1); 
            //make group
            secondRound[j] = groupFactory.CreateGroup(gn, players);
            secondRound[j+index] = groupFactory.CreateGroup((gn+index), playersTwo);
            //incerement group number
            gn++; j++;
        }
        //debuging
        for(int i = 0; i < secondRound.length; i++){
            System.out.println(secondRound[i].toString());
        }
    }

    //enter scores
    public void enterScores(Group[] group){
        int groupNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Group Number"));
        int playerID = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Home Player ID"));
        int playerIDTwo = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Away Player ID"));
        int scoreOne = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Home Score"));
        int scoreTwo = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Away Score"));

        group[groupNumber-1].getPlayerByID(playerID-1).setResult(scoreOne, scoreTwo);
        group[groupNumber-1].getPlayerByID(playerIDTwo-1).setResult(scoreTwo, scoreOne);


        for(int i = 0; i < group.length; i++){
            group[i].setGroupPositions();
            System.out.println(group[i].toString());
            
        }
    }
}

  

