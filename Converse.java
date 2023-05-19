import java.util.Scanner;
/**
 * The Converse class takes input from the user and facilitates gameplay.
 *
 * @author Caitlin G.
 * @version 4.10.23
 */
public class Converse
{
    int floorSize;
    int maxTotalMoves;
    char row;
    int col;
    boolean hasQuit;
    Coord startingLocation;
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Scanner s = new Scanner(System.in);
    
    /**
     * Constructor for Converse with no parameters. Initializes name,
     * floorSize, and maxMoves to default values.
     */
    public Converse(){
        //Default values
        this.floorSize = 3;
        this.maxTotalMoves = 10;
        this.hasQuit = false;
        
        //Conversation ago
        if(floorSetup()){
            return;
        }
        //System.out.println(convo1.floorSize);
        if(maximumMoves()){
            return;
        }
        //System.out.println(convo1.maxTotalMoves);
        if(placementSetup()){
            return;
        }
        //System.out.println("" + convo1.col + ", " + convo1.row);
        System.out.println("<game play commences...>");
    }
    
    /**
     * Checks to see whether the user has entered "quit" with any
     * capitalization.
     * @param ans The user's answer, which we check whether is "quit."
     * @return boolean Returns whether the answer is "quit."
     */
    public boolean checkQuit(String ans){
        if(ans.toLowerCase().equals("quit")){
            hasQuit = true;
        }
        if(hasQuit)System.out.println("Thanks for playing!");
        return hasQuit;
    }
    
    /**
     * Tells the user to enter a floor size. Sets the instance
     * variable floorSize to the size or to a default value.
     * @return boolean Returns whether the answer is "quit."
     */
    public boolean floorSetup(){
        System.out.println("Enter a floor size (integer) between 1 and 13.");
        try{
            String ans = s.nextLine();
            if(checkQuit(ans)){
                return true;
            }
            int ansInt = Integer.parseInt(ans);
            if((ansInt <= 13) && (ansInt >= 1)){
                floorSize = ansInt;
            }else{
                System.out.println("Your floor size was set to the default value 3.");
            }
        }catch(Exception e){
            System.out.println("Your floor size was set to the default value 3.");
        }
        return false;
    }
    
    /**
     * Tells the user to enter the max moves. Sets the instance
     * variable maxTotalMoves to the max moves or to a default
     * value.
     * @return boolean Returns whether the answer is "quit."
     */
    public boolean maximumMoves(){
        System.out.println("Enter a maximum number of moves (integer) between 1 and 10,000.");
        try{
            String ans = s.nextLine();
            if(checkQuit(ans)){
                return true;
            }
            int ansInt = Integer.parseInt(ans);
            if((ansInt <= 10000) && (ansInt >= 1)){
                maxTotalMoves = ansInt;
            }else{
                System.out.println("Your maximum moves were set to the default value of 10.");
            }
        }catch(Exception e){
            System.out.println("Your maximum moves were set to the default value of 10.");
        }
        return false;
    }
    
    /**
     * Asks the player to enter the starting position of the bug
     * until the player enters a valid position. Protects against
     * various errors to ensure the position is a letter and a number.
     * @return boolean Returns whether the answer is "quit."
     */
    public boolean placementSetup(){
        System.out.println("Enter a two character string for the start position of the bug (e.g. A1).");
        boolean assigned = false;
        while(!assigned){
            try{
                String ans = s.nextLine();
                if(checkQuit(ans)){
                    return true;
                }
                try{
                    row = ans.toUpperCase().charAt(0);
                    col = Integer.parseInt(ans.substring(1, ans.length()));
                    //Checks that the row is a letter and the col is a number
                    if((letters.indexOf(row) >= 0) && (letters.indexOf(col) < 0)){
                        int asciiRow = row;
                        if((asciiRow >= 65) && (asciiRow <= 65 + floorSize) && (col <= floorSize) && (col > 0)){
                            startingLocation = new Coord(row, col);
                            assigned = true;
                        }
                        else{
                            System.out.println("Your floor is not that big. Please try again.");
                        }
                    }
                    else{
                        System.out.println("Invalid answer. Please try again.");
                    }
                }catch(Exception e){
                    System.out.println("Invalid answer. Please try again.");
                }
            }catch(Exception e){
                System.out.println("Invalid answer. Please try again.");
            }
        }
        return false;
    }
    
    
    /**
     * Getter method for floorSize.
     * @return int floorSize
     */
    public int getFloorSize(){
        return floorSize;
    }
    
    /**
     * Getter method for maxMoves.
     * @return int maxTotalMoves;
     */
    public int getmaxTotalMoves(){
        return maxTotalMoves;
    }
    
    /**
     * Getter method for the row and col of the starting location, represented by a Coord.
     * @return Coord A new Coord object created with row and col fields
     */
    public Coord getStartingLocation(){
        return new Coord(row, col);
    }
}
