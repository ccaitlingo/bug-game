import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Caitlin's test class for methods in Bug, GameStats, Floor, etc.
 * Note that some methods must be made public in order to test.
 *
 * @author  Caitlin Gong
 * @version 4.10.23
 */
public class MyTest
{
    @Test
    public void BugConstructor1(){
        Bug b = new Bug(10, 100, new Coord(1,1));
        assertEquals(b.f instanceof Floor, true);
        assertEquals(b.f.floorSize, 10);
        assertEquals(b.location instanceof Coord, true);
        assertEquals(b.maxMoves, 100);
        assertEquals(b.moves, 0);
    }
    
    @Test
    public void BugConstructor2(){
        Bug b = new Bug(100, new Coord(1,1));
        assertEquals(b.f instanceof Floor, true);
        assertEquals(b.f.floorSize, 3);
        assertEquals(b.location instanceof Coord, true);
        assertEquals(b.maxMoves, 100);
        assertEquals(b.moves, 0);
    }
    
    /*
    @Test
    public void makeAdjacentTest(){
        Bug b = new Bug(10, new Coord(1,1));
        Coord[] cor = {new Coord(0,0), new Coord(0,1), new Coord(0,2), new Coord(1, 0), new Coord(1,2), new Coord(2,0), new Coord(2,1), new Coord(2,2)};
        Coord[] tst = b.makeAdjacent(b.location);
        for(int i = 0; i < 8; i++){
            assertEquals(cor[i].row, tst[i].row);
            assertEquals(cor[i].col, tst[i].col);
        }
    }
    */
    
    /*
    @Test
    public void walkTest(){
        Bug b = new Bug(10, new Coord(1,1));
        b.walk();
        int filledSpots = 0;
        for(int i = 0; i < b.f.floorSize; i++){
            for(int j = 0; j < b.f.floorSize; j++){
                if(b.f.floor[i][j] != ' ')filledSpots++;
            }
        }
        assertEquals(filledSpots, 1);
    }
    */
    
    /*
    @Test
    public void isFloorFullTest(){
        Bug b = new Bug(3, new Coord(1,1));
        b.f.floor = new char[][]{{'X', 'X', 'X'}, {'X', 'X', 'E'}, {'X', 'S', 'X'}};
        assertEquals(b.isFloorFull(), true);
        b.f.floor = new char[][]{{' ', 'X', 'X'}, {'X', 'X', 'E'}, {'X', 'S', 'X'}};
        assertEquals(b.isFloorFull(), false);
    }
    */
    
    @Test
    public void startWalkingTest(){
        Bug b = new Bug(3, new Coord(1,1));
        assertEquals(b.moves, 0);
        b.startWalking();
        assertNotEquals(b.moves, 0);
    }
    
    @Test
    public void isWinnerTest(){
        Bug b = new Bug(3, 10, new Coord(1,1));
        b.f.floor = new char[][]{{'X', 'X', 'X'}, {'X', 'X', 'E'}, {'X', 'S', 'X'}};
        b.moves = 10;
        assertEquals(b.isWinner(), true);
    }
    
    @Test
    public void gameStatsConstructor(){
        GameStats g = new GameStats();
        assertEquals(g.gamesWon, 0);
        assertEquals(g.gamesLost, 0);
        assertEquals(g.totalGames, 0);
    }
    
    @Test
    public void winTest(){
        GameStats g = new GameStats();
        g.win();
        assertEquals(g.gamesWon, 1);
    }
    
    @Test
    public void loseTest(){
        GameStats g = new GameStats();
        g.lose();
        assertEquals(g.gamesLost, 1);
    }
    
    @Test
    public void updateFloorTest(){
        Floor f = new Floor(5);
        f.updateFloor(new Coord(3,1), 'C');
        assertEquals(f.floor[3][1], 'C');
    }
    
    @Test
    public void isValidMoveTest(){
        Floor f = new Floor(3);
        assertEquals(f.isValidMove(new Coord(0,0)), true);
        assertEquals(f.isValidMove(new Coord(0, 4)), false);
        assertEquals(f.isValidMove(new Coord(-2, 2)), false);
    }
    
    @Test
    public void moveTest(){
        Floor f = new Floor(5);
        assertEquals(f.move(new Coord(0,2), 'C'), true);
        assertEquals(f.floor[0][2], 'C');
    }
    
    @Test
    public void addTest(){
        Coord c1 = new Coord(3,5);
        Coord c2 = new Coord(-1,2);
        Coord add = c1.add(c2);
        assertEquals(add.row, 2);
        assertEquals(add.col, 7);
    }
}
