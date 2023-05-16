import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.*;

public abstract class Pages {

    protected static WebDriver driver;

    public Pages() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver", "chromedriver");

            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("ignore-certificate-errors");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");
            //options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
    }

    public static void closeTheDriver()
    {
        if(driver != null){
            driver.close();
            driver = null;
        }
    }

    protected void navigateTo(String url)
    {
        driver.navigate().to(url);
    }

    public void javaScriptExecutor(String functionName)
    {
        ((JavascriptExecutor) driver).executeScript(functionName);
    }

    public void scrollToXpath(By xpath)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView", driver.findElement(xpath));
    }

    public void waitForXpath(By xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
    }

    public static String[] readFile(String fileName)
    {
        List<String> resultList = new ArrayList<>();

        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                resultList.add(scanner.nextLine());
            }
            scanner.close();
        }   catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultList.toArray(new String[0]);
    }

    public void writeFile(HashMap<String, String> map, String fileName)
    {
        List<Map.Entry<String, String>> entryList = new ArrayList<>(map.entrySet());
        Collections.reverse(entryList);

        try{
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);

            for(Map.Entry<String, String> entry: entryList){
                fileWriter.write(entry.getKey() + ":" + entry.getValue());
            }
            fileWriter.close();

        }   catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
