import javax.swing.JOptionPane;
import java.io.*;      
import java.util.*;
public class Tournament{
    private PlayerFactory player = new PlayerFactory();
    private GroupFactory groupFactory = new GroupFactory();
    private Players[] players;
    private Group[] group;
    public static Scanner scanner = new Scanner(System.in);
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

                        // enterScores(group);
                    break;
                    case 2:
                    System.exit(0);

                        // progressGroup(group, groupStage);
                    break;
                    case 3:
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
        int playerSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Players"));
        int groups = Integer.parseInt(JOptionPane.showInputDialog(null, "Groups"));
        int ppg = playerSize/groups;
        int index = 0;
        int groupNumber =1;
        group = new Group[groups];
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
}

  

