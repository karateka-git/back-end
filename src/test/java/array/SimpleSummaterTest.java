package array;
import myexception.ArraySummaterException;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SimpleSummaterTest {
    private SimpleSummater ss;

    @Before
    public void setUp() {
        this.ss = new SimpleSummater();
    }
    @Test
    public void testSum() {
        int original[] = {7,2,13,3,2};
        int trueCurrent = 27;
        try {
            int current = ss.sum(original);
            Assert.assertEquals(trueCurrent, current);
        }catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
    }
}
