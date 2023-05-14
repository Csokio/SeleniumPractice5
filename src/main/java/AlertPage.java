import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlertPage extends Pages{

    public AlertPage()
    {
        super();
    }

    private final String url = "https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html";

    private final By BUTTON_NORMAL = By.id("normal-btn-warning");
    private final By ALERT_MESSAGES = By.xpath("//div[@class=\"col-md-6 text-left\"]//div[@class=\"col-md-6\"]/div");

    public String getAlertMessage()
    {
        navigateTo(url);
        driver.findElement(BUTTON_NORMAL).click();
        List<WebElement> rowList = driver.findElements(ALERT_MESSAGES);

        String message = "";
        for(WebElement row: rowList){
            String style = row.getAttribute("style");
            if(style.equals("display: block;")){
                WebElement button = row.findElement(By.xpath("./button"));
                message = row.getText().replace(button.getText(), "");
                row.findElement(By.xpath("./button")).click();
            }
        }
        return message.trim();

    }
}
