package module;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import util.CalculatorService;

import static org.mockito.Mockito.*;

/**
 * @RunWith attaches a runner with the test
 * class to initialize the test data
 * @InjectMocks annotation is used to create
 * and inject the mock object
 * @Mock annotation is used to create the mock
 * object to be injected
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {
    /*
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calculatorService;
    */

    private MathApplication mathApplication;
    private CalculatorService calculatorService;

    @Before
    public void setUp() {
        mathApplication = new MathApplication();
        //this will be the parameter for mathApplication.setCalculatorService:
        calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void testAdd() {
        //add the behavior of calc service to add 2 numbers
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0,0);
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0,0);
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0,0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 0.0, 0);
        //TODO: why does it work when I enter 0.0 for actual instead of 10.0???

        //default call count is 1
        verify(calculatorService).subtract(20.0, 10.0);

        //verify the behavior, check if add fc is called 3 times
        verify(calculatorService, times(3)).add(10.0, 20.0);

        //verify that method was never called on a mock
        verify(calculatorService, never()).multiply(10.0, 20.0);
    }

    @Test
    public void testAddAndSubtract() {

        //add the behavior to add numbers & subtract numbers
        when(calculatorService.add(20.0, 10.0)).thenReturn(30.0);
        when(calculatorService.subtract(20.0, 10.0)).thenReturn(10.0);

        //TODO: what does this do?
        when(calculatorService.multiply(3.0, 4.0)).thenCallRealMethod();
        when(calculatorService.multiply(3.0, 4.0)).thenReturn(12.0);


        //test
        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(calculatorService);

        //following will make sure that add is first called and then subtract!
        inOrder.verify(calculatorService).subtract(20.0,10.0);
        inOrder.verify(calculatorService).add(20.0,10.0);
    }
}
