
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class for testing placement.  
 *
 * @author  Prairie Goodwin
 * @version 1.0
 */
public class TestPlacement
{
    @Test
    public void testStartQuit(){
        System.out.println("***quit***");
        Converse c = new Converse();
        boolean retval = c.placementSetup();
        assertEquals(true, retval);
    }

	@Test
    public void testStartQuitUpper(){
        System.out.println("***QUIT***");
        Converse c = new Converse();
        boolean retval = c.placementSetup();
        assertEquals(true, retval);
    }

    @Test
    public void testStart(){

        Converse c = new Converse();
        System.out.println("***5***");        
        c.floorSetup();
        System.out.println("***00***");
        System.out.println("***11***");
        System.out.println("***BB***");
        System.out.println("***A0***");
        System.out.println("***empty string***");
        System.out.println("***1***");
        System.out.println("***A***");
        System.out.println("***A1***");
        boolean retval = c.placementSetup();
        assertEquals('A', c.row);
        assertEquals(1, c.col);
        assertEquals(false, retval);
    }
}
