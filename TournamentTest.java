
public class TournamentTest{
  private Tournament tournament;
  public TournamentTest(){
    setTournament(new Tournament());
    tournament.CreateMenu();
  }

  public static void main(String [] args){
    new TournamentTest();
  }

  public Tournament getTournamet(){
    return tournament;
  }
  public void setTournament(Tournament tournament){
    this.tournament = tournament;
  }
}