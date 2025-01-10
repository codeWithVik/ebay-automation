package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static core.ChromeFactory.driver;
import static core.ChromeFactory.webDriverWait;

public class ItemsPage {

    public ItemsPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectItemFromList(final int itemToSelect) {
        List<WebElement> listOfItems = webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[@class='s-item__link']"), 0));
        listOfItems.get(itemToSelect + 1).click();
    }
}