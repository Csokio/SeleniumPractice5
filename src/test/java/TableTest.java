import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TableTest extends BaseTest{

    TablePage tablePage = new TablePage();

    @Test
    public void testAges()
    {
        Integer[] actual = tablePage.getFirstThreeAges(10);
        String[] array = Pages.readFile("ages.txt");

        String[] arraySplit = array[0].split(",");
        Integer[] expected = new Integer[arraySplit.length];

        for(int i = 0; i < arraySplit.length; i++){
            expected[i] = Integer.parseInt(arraySplit[i]);
        }

            Assertions.assertArrayEquals(expected, actual);
    }
}
