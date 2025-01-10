package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.ChromeFactory.driver;
import static core.ChromeFactory.webDriverWait;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "atcBtn_btn_1")
    WebElement addToCartButton;

    @FindBy(how = How.ID, using = "gh-cart-n")
    WebElement itemsInCart;

    public void addItemToCart() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addToCartButton)).click();
    }

    public int getItemsInCart() {
        return Integer.parseInt(webDriverWait.until(ExpectedConditions.visibilityOf(itemsInCart)).getText());
    }
}