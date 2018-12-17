import java.io.IOException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class PlayerFactory{
      public static File aFile;
    public static ArrayList<String> names;
    public static Scanner scanner = new Scanner(System.in);
  public PlayerFactory(){

  }

  public Players[] createPlayers(int ppg, int number)throws IOException{
    int id = 0;
        int w = 0;
        int d = 0;
        int l = 0;
        int points = 0;
        String name = "";
        Players[] player = new Players[ppg];

        String filename = "names.txt";  
        aFile = new File(filename);
        if (!aFile.exists())  
            // createFile(filename);
            System.out.print("Hello");
        else{
            names = new ArrayList<String>();
            Scanner in = new Scanner(aFile);
            String aLineFromFile;		
            while(in.hasNext())
            {
              aLineFromFile = in.nextLine();
               aLineFromFile = aLineFromFile.replaceAll(",$", "");
                names.add(aLineFromFile);
            }
            in.close();

            Random rand = new Random();
            int n = 0;
            while(n < ppg){
                boolean inList = false;
                if(!inList){
                    name = names.get(number);
                    player[n] = new Players(id,name, w, d, l, points);
                    id++;
                    number++;
                    n+=1;
                }
                
            }
        }
        return player;
  }
}