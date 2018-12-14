public class Fixtures{
    String[][] rounds;
    Group group;
    // Players player1, player2;
    int score1;
    int score2;
    String result = "";
    public Fixtures(Group group, String[][] rounds){
        this.group = group;
        this.rounds = rounds;
    }



    public void enterScore(){
        for(int i = 0; i < rounds.length;i++){
            //score1 = input
            //score1 = round[i]
            //score2 = input
            //score2 = round[i+1]
        }
    }



    public String createFixtures(Group group){
        int teams = 0;
        teams = group.size();
          // If odd number of teams add a "ghost".
          boolean ghost = false;
          if (teams % 2 == 1) {
              teams++;
              ghost = true;
          }
                // Generate the fixtures using the cyclic algorithm.
                int totalRounds = teams - 1;
                int matchesPerRound = teams / 2;
                rounds = new String[totalRounds][matchesPerRound];
                for (int round = 0; round < totalRounds; round++) {
                    for (int match = 0; match < matchesPerRound; match++) {
                        int home = (round + match) % (teams - 1);
                        int away = (teams - 1 - match + round) % (teams - 1);
                        // Last team stays in the same place while the others
                        // rotate around it.
                        if (match == 0) {
                            away = teams - 1;
                        }
                        // Add one so teams are number 1 to teams not 0 to teams - 1
                        // upon display.
                        rounds[round][match] = group.getName((home)) + " v " + group.getName((away));
                    }
                }
                
                // Interleave so that home and away games are fairly evenly dispersed.
                String[][] interleaved = new String[totalRounds][matchesPerRound];
                
                int evn = 0;
                int odd = (teams / 2);
                for (int i = 0; i < rounds.length; i++) {
                    if (i % 2 == 0) {
                        interleaved[i] = rounds[evn++];
                    } else {
                        interleaved[i] = rounds[odd++];
                    }
                }
                
                rounds = interleaved;
        
                // Last team can't be away for every game so flip them
                // to home on odd rounds.
                for (int round = 0; round < rounds.length; round++) {
                    if (round % 2 == 1) {
                        rounds[round][0] = flip(rounds[round][0]);
                    }
                }
                
                // Display the fixtures        
                for (int i = 0; i < rounds.length; i++) {
                    System.out.println("Round " + (i + 1));
                    System.out.println(Arrays.asList(rounds[i]));
                    System.out.println();
                }
                
                System.out.println();
                
                if (ghost) {
                    System.out.println("Matches against team " + teams + " are byes.");
                }
                
                System.out.print("Use mirror image of these rounds for "
                    + "return fixtures.\n\n");

        return rounds;

    }
}