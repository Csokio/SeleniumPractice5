import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends Pages{

    public TablePage()
    {
        super();
    }

    private final String url = "https://demo.seleniumeasy.com/";

    private final By NAVBAR = By.xpath("//ul[@class='nav navbar-nav']");

    public void navigateToTableSort()
    {
        driver.navigate().to(url);
        WebElement TABLE_MENU = driver.findElement(NAVBAR).findElement(By.xpath("./li[3]"));
        TABLE_MENU.click();
        WebElement TABLE_SORT = TABLE_MENU.findElements(By.xpath("./ul/li")).get(3);
        TABLE_SORT.click();
    }

    private final By BUTTON_SELECT = By.xpath("//select[@name='example_length']");

    private final By TEXT_INFO = By.id("example_info");

    private final By TABLE = By.id("example");

    public Integer[] getFirstThreeAges(int selectValue)
    {

        navigateToTableSort();
        Select select = new Select(driver.findElement(BUTTON_SELECT));
        select.selectByValue(String.valueOf(selectValue));

        List<WebElement> rowList = driver.findElement(TABLE)
                .findElements(By.xpath("./tbody/tr/td[4]")).subList(0,3);

        Integer[] resultArray = new Integer[rowList.size()];
        int count = 0;

        for(WebElement row: rowList){
            resultArray[count++] = Integer.parseInt(row.getText());
        }
        return resultArray;
    }
}
