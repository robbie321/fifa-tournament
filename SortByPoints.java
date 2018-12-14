public class SortByPoints implements Comparable<Players>{

    public int compare(Players a, Players b){
        return a.points - b.points;
    }

}