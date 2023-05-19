
/**
 * The Bug class represents the bug playing character, which has a location, cells adjacent to that
 * location, a symbol, as well as keeping track of the floor and maxMoves.
 *
 * @author Caitlin G.
 * @version 4.2.23
 * 
 */
public class Bug
{
    Floor f;
    Coord location;
    Coord startLoc;
    int maxMoves;
    int moves;
    char symbol;
    char startSymbol = 'S';
    char endSymbol = 'E';
    Coord[] adjacentCells;
    
    /**
     * Constructor for Bug. Initializes floorSize, maxMoves, and startingLocation from
     * the Converse class.
     * @param floorSize
     * @param maxMoves
     * @param startingLocation
     */
    public Bug(int floorSize, int maxTotalMoves, Coord startingLocation){
        f = new Floor(floorSize);
        location = startingLocation;
        startLoc = startingLocation;
        maxMoves = maxTotalMoves;
        moves = 0;
        adjacentCells = makeAdjacent(location);
    }
    
    /**
     * Constructor for Bug. Initializes floorSize, maxMoves, and startingLocation from
     * the Converse class. Uses default of 3 for floorSize.
     * @param maxMoves
     * @param startingLocation
     */
    public Bug(int maxTotalMoves, Coord startingLocation){
        this(3, maxTotalMoves, startingLocation);
    }
    
    /**
     * (row, column) of adjacent cells given a bug's location, noted by X below:
     * Starting clockwise from upper left (you can start relative to any location here)
     *
     *  0 | 1 | 2
     * ---|---|---
     *  7 | X | 3
     * ---|---|---
     *  6 | 5 | 4
     *
     * The coordinate values are relative to the bug's location!
     * Just add the appropriate row/col values to the bug's current location.
     * So, the relative/adjacent coordinates are as follows:
     * 0: (-1, 1) 1: ( 0, 1) 2: ( 1, 1)
     * 3: ( 1, 0) 4: ( 1,-1) 5: ( 0,-1)
     * 6: (-1,-1) 7: (-1, 0)
     * Example: adding coord(-1, 1) to bug's last known location specified by coord named 'X',
     * will move the bug to the upper left cell named '0' as long as cell 0 is a valid cell.
     * If the coord named 'X' is located at (0,0) in the floor's array, this is not a valid cell to move to.
     *
     */
    private Coord[] makeAdjacent(Coord start){
        Coord[] arr = new Coord[8];
        final Coord[] surrounding = {new Coord(-1, -1), new Coord(-1, 0), new Coord(-1, 1), new Coord(0, -1), new Coord(0, 1), new Coord(1, -1), new Coord(1, 0), new Coord(1, 1)};
        for(int i = 0; i < 8; i++){
            arr[i] = start.add(surrounding[i]);
        }
        return arr;
    }
    
    /**
     * The bug makes a single move to a random valid location
     * that is adjacent to its last location on the floor, and
     * updates its location to the new location.
     */
    private void walk(){
        while(true){
            int rand = (int)(Math.random()*8);
            adjacentCells = makeAdjacent(location);
            Coord potMove = adjacentCells[rand];
            if(f.floorSize == 1){
                location = new Coord(0,0);
                f.updateFloor(location, 'X');
                break;
            }
            if(isValidMove(potMove)){
                location = potMove;
                f.updateFloor(location, 'X');
                break;
            }
        }
        return;
    }
    
    /**
     * Returns whether the given coordinate is a valid move based
     * on the bug's current location.
     * @param coord The potential coordinate.
     * @return boolean Whether the potential coordinate is valid.
     */
    private boolean isValidMove(Coord coord){
        return coord.row >= 0 && coord.row < f.floorSize && coord.col >= 0 && coord.col < f.floorSize;
    }
    
    /**
     * Returns whether the bug is done walking, which is either when
     * all of the elements of the floor are populated with the bug
     * symbol or the bug has reached its max total moves.
     * @return boolean Whether the bug has finished walking.
     */
    private boolean isFinishedWalking(){
        return (moves == maxMoves) || isFloorFull();
    }
    
    /**
     * Returns whether the floor is fully marked up with 'X's that
     * represent where the bug has walked.
     * @return boolean Whether the floor is full.
     */
    private boolean isFloorFull(){
        for(int i = 0; i < f.floorSize; i++){
            for(int j = 0; j < f.floorSize; j++){
                if(f.floor[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Begins the game, and send the bug off walking till it is finished
     * walking.
     */
    public void startWalking(){
        while(!isFinishedWalking()){
            walk();
            moves++;
        }
        f.updateFloor(startLoc, startSymbol);
        f.updateFloor(location, endSymbol);
        //System.out.println("Done");
    }
    
    /**
     * Returns whether the bug has won the game, meaning the floor is
     * full and the bug hasn't exceeding its maximum moves.
     * @return boolean Whether the bug has won the game.
     */
    public boolean isWinner(){
        return isFloorFull() && (moves <= maxMoves);
    }
    
    /**
     * toString that represents the floor after the bug has walked on it,
     * and a message stating whether the player has won or lost.
     * @return A string with the game board (floor) and a win/lose msg.
     */
    public String toString(){
        String retval = f.drawFloor() + "\n";
        if(isWinner()){
            retval += "You won!";
        }else{
            retval += "You lost.";
        }
        return retval;
    }
}
