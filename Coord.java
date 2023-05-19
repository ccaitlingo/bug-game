
/**
 * The Coord class stores coordinates (row, col).
 *
 * @author Caitlin G.
 * @version 2.28.23
 */
public class Coord
{
    public int row;
    public int col;
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    /**
     * Constructor for Coord. Initializes instance variables
     * row and col, making adjustments as needed.
     * @param row The row as a character value.
     * @param col The col starting at 1.
     */
    public Coord(char row, int col){
        this.row = letters.indexOf(row);
        this.col = col - 1;
    }
    
    /**
     * Other constructor for Coord. Initializes instance
     * variables row and col.
     * @param row The row.
     * @param col The col.
     */
    public Coord(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    /**
     * Adds a coordinate to the coordinate it is called on and 
     * returns a copy of the results. Does not actually modify
     * the coordinate it is called on.
     * @param coord The coordinate that is being added.
     * @return Coord The modified/"added" coordinate.
     */
    public Coord add(Coord coord){
        Coord newCoord = coord;
        newCoord.row = row + coord.row;
        newCoord.col = col + coord.col;
        return newCoord;
    }
}
