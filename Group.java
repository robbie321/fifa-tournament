import java.io.*;      
import java.util.*;
public class Group{
    int groupNumber;
    Players [] playerNames;
    int numberOfPlayers = 0;
    int w=0,d=0,l=0;
    int[] positions;
    public Group(int groupNumber, Players[] playerNames){
        this.groupNumber = groupNumber;
        this.playerNames = playerNames;
    }

    public int getGroupNumber(){
        return groupNumber;
    }
    public Players getPlayerByID(int j){
        Players player = null;
        for(int i = 0; i <playerNames.length;i++){
            if(j == playerNames[i].getID()){
                player =  playerNames[i];
            }
        }
        return player;
    }
    public Players getPlayer(int j){
        Players player = null;
        for(int i = 0; i <playerNames.length;i++){
            if(playerNames[j].getID() == playerNames[i].getID()){
                player  =  playerNames[i];
            }
        }
        return player;
    }
    public String getName(int k){
        String result ="";
        for(int i = 0; i <playerNames.length;i++){
            if(k == i)
            result = playerNames[i].getPlayerName();
        }
        return result;
        
    }
    public void setGroupNumber(int i){
        i = groupNumber;
    }

    public void setGroupPositions(){
        // positions = new int[playerNames.length];
        System.out.print("Sorted");
            for(int i = 0; i < playerNames.length - 1;i++){
                for(int j=0; j< playerNames.length-i-1; j++){
                    if(playerNames[j].getPoints() < playerNames[j+1].getPoints()){
                        //switch
                        Players temp = playerNames[j];
                        playerNames[j] = playerNames[j+1];
                        playerNames[j+1] = temp;
                    }
                }
        }
    }

    public String toString(){
        String result = "";
        result = "Group Number: " + groupNumber + " \tW" +
        "\tD" + "\tL" + "\tPts" +"\n";
        for(int i = 0; i < playerNames.length; i++){
            result +=  (i+1)+") "+playerNames[i].getPlayerName()+"("+(playerNames[i].getID() + 1)+")" +"\t\t" + playerNames[i].getWins() + "\t" + playerNames[i].getDraw()  + "\t" + playerNames[i].getLoss()  + "\t" + playerNames[i].getPoints() +"\n";
        }
        // String.format(result);
        return result;
    }

    //determine position
    public void determinePosition(){
        //get points of player
        for(int i = 0; i<playerNames.length; i++){
            if(playerNames[i].getPoints() < playerNames[i+1].getPoints()){

            }
        }
    }

    public int size(){
        for(int i = 0; i <playerNames.length;i++){
            numberOfPlayers++;
        }
        return numberOfPlayers;
    }
}