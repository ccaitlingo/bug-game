
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class for Coord and Floor.
 *
 * @author  Prairie Goodwin
 * @version 1.0
 */
public class GradingTest
{
    @Test
    public void CoordTest(){
        Coord c = new Coord('B',2);
        assertEquals(1,c.row);
        assertEquals(1,c.col);

        Coord c2 = new Coord(1,1);
        assertEquals(1,c2.row);
        assertEquals(1,c2.col);
    }

    @Test
    public void FloorConstructorTest(){
        int num = 7;
        Floor fl = new Floor(num);
        assertEquals(num,fl.floorSize);
        assertEquals(num,fl.floor.length);
        assertEquals(num,fl.floor[0].length);

        num = 5;
        fl = new Floor(num);
        assertEquals(num,fl.floorSize);
        assertEquals(num,fl.floor.length);
        assertEquals(num,fl.floor[0].length);

    }

    @Test
    public void FloorMethodsValidTest(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(-1,1));
        assertEquals(false, valid, "Left side out of bounds");
    }

    @Test
    public void FloorMethodsValidTest2(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(8,1));
        assertEquals(false, valid, "Right side out of bounds");
    }

    @Test
    public void FloorMethodsValidTest3(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(1,-1));
        assertEquals(false, valid, "Top side out of bounds");

    }

    @Test
    public void FloorMethodsValidTest4(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(1,8));
        assertEquals(false, valid, "Bottom side out of bounds");

    }

    @Test
    public void FloorMethodsValidTest5(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(-1,-1));
        assertEquals(false, valid, "Left upper corner out of bounds");
    }

    @Test
    public void FloorMethodsValidTest6(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(8,-1));
        assertEquals(false, valid, "Left lower corner out of bounds");

    }

    @Test
    public void FloorMethodsValidTest7(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(-1,8));
        assertEquals(false, valid, "Right upper corner out of bounds");

    }

    @Test
    public void FloorMethodsValidTest8(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(8,8));
        assertEquals(false, valid, "Right lower corner out of bounds");

    }

    @Test
    public void FloorMethodsValidTrue(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean valid = fl.isValidMove(new Coord(3,1));
        assertEquals(true, valid);

    }


    @Test
    public void FloorMethodsMove(){
        int num = 5;
        Coord coord = new Coord(1,1);
        Floor fl = new Floor(num);
        assertEquals(num,fl.getFloorSize());

        boolean success = fl.move(coord,'X');
        assertEquals(true, success);

        char c = fl.getFloorValue(coord);
        assertEquals('X', c);

        success = fl.move(new Coord(3,8),'X');
        assertEquals(false, success);

        fl = new Floor(12);
        fl.move(new Coord(1,1), 'X');
        System.out.println(fl);

    }
}
