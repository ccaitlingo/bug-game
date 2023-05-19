
/**
 * The Floor class keeps track of the gameboard/floor and makes moves on it.
 *
 * @author Caitlin G.
 * @version 2.28.23
 */
public class Floor
{
    char[][] floor;
    int floorSize;
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    /**
     * Constructor for Floor. Initializes floorSize from the
     * constructor input, and initilizes the character array floor
     * based on floorSize and fills it with empty characters.
     * @param The floor size.
     */
    public Floor(int floorSize){
        this.floorSize = floorSize;
        this.floor = new char[floorSize][floorSize];
        for(int i = 0; i < floorSize; i++){
            for(int j = 0; j < floorSize; j++){
                floor[i][j] = ' ';
            }
        }
    }
    
    /**
     * Another constructor for floor that creates a Floor with
     * a default size of 3.
     */
    public Floor(){
        this(3);
    }
    
    /**
     * Setter method for spaces on floor.
     * @param location The coordinate where the symbol should go.
     * @param symbol A character symbol that either represents
     * the bug or a place the bug hath tread.
     */
    public void updateFloor(Coord location, char symbol){
        floor[location.row][location.col] = symbol;
    }
    
    /**
     * When a Floor object is printed, an ascii drawing of the floor
     * is displayed by calling drawFloor().
     * @return String The ascii drawing of the floor.
     */
    public String toString(){
        return drawFloor();
    }
    
    /**
     * Accessor method for floorSize.
     * @return int Returns the instance variable floorSize.
     */
    public int getFloorSize(){
        return floorSize;
    }
    
    /**
     * Returns the char value of a specified position on the floor.
     * @param coord A Coord object, representing a coordinate pair.
     * @return char Returns the char at the coordinate position.
     */
    public char getFloorValue(Coord coord){
        return floor[coord.row][coord.col];
    }
    
    /**
     * Checks to see if the user's move is valid.
     * @param coord A Coord object, representing a coordinate pair.
     * @return boolean Returns whether the user's move is valid.
     */
    public boolean isValidMove(Coord coord){
        return (coord.row >= 0 && coord.row <= floorSize && coord.col >= 0 && coord.col <= floorSize);
    }
    
    /**
     * Moves the bug to be at the new position, if the move is
     * valid.
     * @param coord A Coord object, representing a coordinate pair.
     * @param buggie The character that will be placed at the
     * position, which will represent the bug.
     * @return boolean Returns whether the user's move is valid.
     */
    public boolean move(Coord coord, char buggie){
        if(isValidMove(coord))floor[coord.row][coord.col] = buggie;
        return isValidMove(coord);
    }
    
    /**
     * Draws an ascii floor, which includes a gameboard and
     * incorporates information from the char array floor.
     * @return String The ascii floor drawing.
     */
    public String drawFloor(){
        String board = "    ";
        //Row of number labels
        for(int i = 1; i <= floorSize; i++){
            //If else to account for 10, 11, 12, etc. being misspaced
            if(i >= 9){
                board += i + "  ";
            }
            else{
                board += i + "   ";
            }
        }
        //Remainder of board
        board += "\n";
        for(double i = 0; i < floorSize; i += .5){  
            //Col of letters
            if(i % 1 == 0){
                board += " " + letters.charAt((int)i);
                board += "  " + floor[(int)i][0] + " ";
            }else{
                board += "   ---";
            }
            //Remainder of board
            for(int j = 1; j < floorSize; j++){
                if(i % 1 == 0){
                    board += "| " + floor[(int)i][j] + " ";
                }
                else{
                    board += "|---";
                }
            }
            board += "\n";
        }
        return board;
    }
    
    /**
     * Main method.
     * @param args Command line to gather user input.
     */
    public static void main(String[] args){
        //Prints example empty floor
        Floor f = new Floor(4);
        System.out.println(f);
        //Prints example floor with bug placed at (2,3)
        f.move(new Coord(2, 3), 'b');
        System.out.println(f);
    }
}
