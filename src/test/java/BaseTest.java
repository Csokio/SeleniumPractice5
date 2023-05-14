import org.junit.jupiter.api.AfterAll;

public class BaseTest {

    @AfterAll
    public static void closeDriver()
    {
        Pages.closeTheDriver();
    }
}
