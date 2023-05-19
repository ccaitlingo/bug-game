import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class for the converse class.
 *
 * @author  Prairie Goodwin
 * @version 1.0
 */
public class TestMethods
{
    int defaultMoves = 10;

    @Test
    public void testNameQuit(){
        System.out.println("***quit***");
        PlayBugGame g = new PlayBugGame();
        boolean retval = g.greeting();
        assertEquals(true, retval);

    }
    
    @Test
    public void testNameQuitUpper(){
        System.out.println("***QUIT***");
        PlayBugGame g = new PlayBugGame();
        boolean retval = g.greeting();
        assertEquals(true, retval);

    }

    @Test
    public void testName5Correct(){
        System.out.println("***5***");
        PlayBugGame g = new PlayBugGame();
        boolean retval = g.greeting();
        assertEquals(false, retval);
    }    

    @Test
    public void testNameEmpty(){

        System.out.println("***empty string***");
        PlayBugGame g = new PlayBugGame();
        boolean retval = g.greeting();
        assertEquals(false, retval);
    }    

    @Test
    public void testNameDudeCorrect(){

        System.out.println("***dude***");
        PlayBugGame g = new PlayBugGame();
        boolean retval = g.greeting();
        assertEquals(false, retval);
        assertEquals(g.name, "dude");
    }    


    @Test
    public void testFloorSizeEmpty(){

        System.out.println("***empty string***");
        Converse c = new Converse();
        boolean retval = c.floorSetup();
        assertEquals(false, retval);
        assertEquals(3, c.floorSize);
    }    


    @Test
    public void testFloorSizeA(){

        System.out.println("***a***");
        Converse c = new Converse();
        boolean retval = c.floorSetup();
        assertEquals(false, retval);
        assertEquals(3, c.floorSize);
    }    


    @Test
    public void testFloorSize0(){

        System.out.println("***0***");
        Converse c = new Converse();
        boolean retval = c.floorSetup();
        assertEquals(false, retval);
        assertEquals(3, c.floorSize);
    }    


    @Test
    public void testFloorSize15(){

        System.out.println("***15***");
        Converse c = new Converse();
        boolean retval = c.floorSetup();
        assertEquals(false, retval);
        assertEquals(3, c.floorSize);
    }    


    @Test
    public void testFloorSize5Correct(){

        System.out.println("***5***");
        Converse c = new Converse();
        boolean retval = c.floorSetup();
        assertEquals(false, retval);
        assertEquals(5, c.floorSize);

    }


    @Test
    public void testMaximumMovesEmpty(){

        System.out.println("***empty string***");
        Converse c = new Converse();
        boolean retval = c.maximumMoves();
        assertEquals(false, retval);
        assertEquals(defaultMoves, c.maxTotalMoves);
    }

    @Test
    public void testMaximumMovesA(){

        System.out.println("***a***");
        Converse c = new Converse();
        boolean retval = c.maximumMoves();
        assertEquals(false, retval);
        assertEquals(defaultMoves, c.maxTotalMoves);
    }

    @Test
    public void testMaximumMoves0(){

        System.out.println("***0***");
        Converse c = new Converse();
        boolean retval = c.maximumMoves();
        assertEquals(false, retval);
        assertEquals(defaultMoves, c.maxTotalMoves);
    }

    @Test
    public void testMaximumMovesneg1(){

        System.out.println("***-1***");
        Converse c = new Converse();
        boolean retval = c.maximumMoves();
        assertEquals(false, retval);
        assertEquals(defaultMoves, c.maxTotalMoves);
    }

    @Test
    public void testMaximumMoves5Correct(){

        System.out.println("***5***");
        Converse c = new Converse();
        boolean retval = c.maximumMoves();
        assertEquals(false, retval);
        assertEquals(5, c.maxTotalMoves);
    } 
}
