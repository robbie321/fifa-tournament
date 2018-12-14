public class Players{
    String name;
    int id;
    int w;
    int d;
    int l;
    int points;
    int score;
    public Players(int id, String name, int w, int d, int l, int points){
        this.id = id;
        this.name = name;
        this.w = w;
        this.d = d;
        this.l = l;
        this.points = points;
    }

    public String getPlayerName(){
        return name;
    }
    public int getWins(){
        return w;
    }
    public int getDraw(){
        return d;
    }
    public int getLoss(){
        return l;
    }
    public int getPoints(){
        return points;
    }
    public int getID(){
        return id;
    }
    public int getScore(){
        return score;
    }
    public void setPoints(int i){
        this.points = i;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score = score;
    }

    public void setResult(int i, int j){
        if(i > j){
            w++;
            points+=3;
        }
        if(i < j){
            l++;
        }
        if(i==j){
            d++;
            points+=1;
        }

    }

    // public void reset(){
    //     this.w = 0;
    //     this.d = 0;
    //     this.l = 0;
    //     this.points = 0;
    // }

}