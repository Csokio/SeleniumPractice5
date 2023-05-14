import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlertTest extends BaseTest{

    AlertPage alertPage = new AlertPage();

    @Test
    public void testAlertMessage()
    {
        String actual = alertPage.getAlertMessage();
       System.out.println(actual);
        String expected = "I'm a normal warning message. To close use the appropriate button.";

        Assertions.assertEquals(expected, actual);
    }
}
