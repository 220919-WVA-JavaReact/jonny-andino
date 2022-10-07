import com.revature.testing.Calculator;
import com.revature.testing.DivideByZeroException;
import org.junit.*;

public class CalculatorTest {

    // below here, we'll introduce methods to begin testing our object

    // to test ur calculator we'll need a testing object

    static Calculator calc;

    // right  now this value is null, we could directly instantiate it, but we
    // are going to use dependency injection instead

    // what i am going to do to create a new calc object is use a before class
    // annotation to create the calc object before any of the test methods are run
    // to run something before the entire class, i'll use the beforeclass annotation

    @BeforeClass
    public static void setupBeforeClass(){
        System.out.println("This runs before the entire class");

        calc = new Calculator();
    }

    // i'll add some additional methods to see how they stack out when we run the test suite

    @Before
    public void beforeEach(){
        System.out.println("This runs before each test");
    }

    @After
    public void afterEach(){
        System.out.println("This runs after each test");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("This runs after the class.");
    }

    // let's create some test cases

    // positive test: we should be checking for the right solution
    @Test
    public void positiveAdditionTest(){
        //assertEquals
        System.out.println("Positive addition test");
        Assert.assertEquals(4,calc.addNumbers(2,2));
    }

    // negative addition test
    @Test
    public void negativeAdditionTest(){
        System.out.println("Negative addition test");
        Assert.assertNotEquals(7, calc.addNumbers(2,3));
    }

    // how do we test for an exception
    @Test(expected = DivideByZeroException.class)
    public void testDivideByZero(){
        calc.divideNumbers(2,0);
    }

    @Test(expected = ArithmeticException.class)
    public void testIntDivideByZero(){
        calc.divideNumbers(2,0);
    }
}
