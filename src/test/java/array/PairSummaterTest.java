package array;
import myexception.ArraySummaterException;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PairSummaterTest {
    private PairSummater ps;
    @Before
    public void setUp() {
        this.ps = new PairSummater();
    }
    @Test(expected = ArraySummaterException.class)
    public void testArraySummaterException() throws ArraySummaterException{
        int original[] = {7,2,13,3,2};
        int trueCurrent = 16;
        int current = ps.sum(original);
        Assert.assertEquals(trueCurrent, current);
    }

    @Test
    public void testMaxPair() {
        int original[] = {7,2,13,3};
        int trueCurrent = 16;
        try {
            int current = ps.sum(original);
            Assert.assertEquals(trueCurrent, current);
        }catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
    }
}
