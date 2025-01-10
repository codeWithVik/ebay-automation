package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.ChromeFactory.driver;
import static core.ChromeFactory.webDriverWait;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search for anything']")
    WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement searchButton;

    public void searchItem(final String itemToSearch) {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(itemToSearch);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
}