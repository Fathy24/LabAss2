import org.junit.Test;

import static org.junit.Assert.*;

public class OddOrEvenTest {

    @Test
    public void even() {
        OddOrEven test1 = new OddOrEven();
        assertEquals(test1.EvenOrOdd(10),"Even");
    }
    @Test
    public void odd(){
        OddOrEven test2 = new OddOrEven();
        assertEquals(test2.EvenOrOdd(1),"Odd");
    }
}