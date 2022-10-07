import com.revature.testing.CountIncreasingValues;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountIncreasingTest {
    static CountIncreasingValues count;

    @BeforeClass
    public static void setupBeforeClass(){
        count = new CountIncreasingValues();
    }

    @Test
    public void exampleTest(){
        int[] list = {120, 101, 145, 113, 123, 99, 215, 106};
        Assert.assertEquals(3, count.countIncreasingValues(list));
    }

    @Test
    public void negativeExampleTest(){
        int[] list = {120, 101, 145, 113, 123, 99, 215, 106};
        Assert.assertNotEquals(4, count.countIncreasingValues(list));
    }

    @Test
    public void allIncreasingTest(){
        int[] list = {1,2,3,4,5,6,7};
        Assert.assertEquals(6, count.countIncreasingValues(list));
    }

    @Test
    public void negativeAllIncreasingTest(){
        int[] list = {1,2,3,4,5,6,7};
        Assert.assertNotEquals(7, count.countIncreasingValues(list));
    }

    @Test
    public void allDecreasingTest(){
        int[] list = {9,8,7,6,5,4,3,2,1};
        Assert.assertEquals(0, count.countIncreasingValues(list));
    }

    @Test
    public void negativeAllDecreasingTest(){
        int[] list = {9,8,7,6,5,4,3,2,1};
        Assert.assertNotEquals(1, count.countIncreasingValues(list));
    }
}
