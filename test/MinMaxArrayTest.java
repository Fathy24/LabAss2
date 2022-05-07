import org.junit.Test;

import static org.junit.Assert.*;

public class MinMaxArrayTest {

    @Test
    public void TenMaxZeroMinSorted() {
        int arr[] = {0,1,2,3,4,5,6,7,8,9,10};
        MinMaxArray test1 = new MinMaxArray();
        assertEquals(test1.GetMax(arr),10);
        assertEquals(test1.GetMin(arr),0);
    }

    @Test
    public void TenMaxZeroMinUnsorted() {
        int arr[] = {9,5,10,1,8,4,0,6,2,3,7};
        MinMaxArray test2 = new MinMaxArray();
        assertEquals(test2.GetMax(arr),10);
        assertEquals(test2.GetMin(arr),0);
    }
}