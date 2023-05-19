
/**
 * The GameStats class keeps track of the game stats. It increments
 * wins and loses and shows a final summary if printed.
 *
 * @author Caitlin G.
 * @version 4.10.23
 */
public class GameStats
{
    int totalGames;
    int gamesWon;
    int gamesLost;
    
    /**
     * Constructor for GameStats. Sets all stats to 0.
     */
    public GameStats(){
        totalGames = 0;
        gamesWon = 0;
        gamesLost = 0;
    }
    
    /**
     * Increments wins and total games.
     */
    public void win(){
        gamesWon++;
        totalGames++;
    }
    
    /**
     * Increments losses and total games.
     */
    public void lose(){
        gamesLost++;
        totalGames++;
    }
    
    /**
     * When a GameStats object is printed, shows a summary of stats.
     * @return String A string stating number of games lost, won,
     * and played.
     */
    public String toString(){
        String retval = "You won " + gamesWon + " and lost " + gamesLost + " out of " + totalGames + " total";
        if(totalGames == 1){
            retval += " game played.\n";
        }else{
            retval += " games played.\n";
        }
        return retval;
    }
}
