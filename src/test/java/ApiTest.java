import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiTest extends BaseTest{

    @Test
    public void testStatusWebsite()
    {
        int actual = RestAssured.get("https://automationexercise.com").statusCode();
        Assertions.assertEquals(200,actual);
    }
}
