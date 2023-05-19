import java.util.Scanner;

/**
 * The PlayBugGame class brings together the GameStats, Converse, and Bug
 * classes to play the game.
 *
 * @author Caitlin G.
 * @version 4.10.23
 */
public class PlayBugGame
{
    String name;
    
    /**
     * Constructor for PlayBugGame with no parameters. Plays game and prints
     * out final stats.
     */
    PlayBugGame(){
        GameStats stats = new GameStats();
        String name = "Player 1";
        if(!greeting()){
            while(true){
                Converse c = new Converse();
                if(c.hasQuit){
                    break;
                }
                //try{
                    Bug b = new Bug(c.getFloorSize(), c.getmaxTotalMoves(), c.getStartingLocation());
                    b.startWalking();
                    System.out.println(b);
                    winLose(stats, b);
                //}catch(Exception e){
                    //continue;
                //}
            }
        }   
        System.out.println(name + "'s Stats:");
        System.out.println(stats);
    }
    
    /**
     * Main method for PlayBugGame. Simply makes a new instance of the
     * game.
     */
    public static void main(String[] args){
        PlayBugGame game = new PlayBugGame();
    }
    
    /**
     * Helps the GamesStats class increment wins and loses.
     * @param g A GameStats object that keeps track of wins/loses.
     * @param b The bug in the game.
     */
    public void winLose(GameStats g, Bug b){
        if(b.isWinner()){
            g.win();
        }else{
            g.lose();
        }
        return;
    }
    
    /**
     * Tells the user to enter their name or quit. Sets the instance
     * variable name to their name or to a default value.
     * 
     * This method and instance variable name were moved from Converse class
     * because I liked having the loop in the PlayBugGame class instead of
     * the converse class. I didn't want the player to have to make a new 
     * name each time, but I did want to be able to encapsulate converse 
     * methods in a single class that be run again and again easily. Also, 
     * this way, the Bug and Converse class have a cleaner way of 
     * communicating (through a third middle-man class, PlayBugGame), 
     * instead of Converse class calling Bug methods and all game play 
     * happening inside Converse.
     * 
     * @return boolean Returns whether the answer is "quit."
     */
    public boolean greeting(){
        System.out.println("The Random Bug Walk Game");
        System.out.println("Welcome");
        System.out.println("Enter name, or type quit to exit.");
        Scanner s = new Scanner(System.in);
        try{
            String ans = s.nextLine();
            if (ans.toLowerCase().equals("quit")){
                return true;
            }
            if (!ans.equals("")){
                this.name = ans;
            }
            else{
                System.out.println("Your name is Player 1.");
            }
        }catch(Exception e){
            System.out.println("Your name is Player 1.");
        }
        return false;
    }
}
