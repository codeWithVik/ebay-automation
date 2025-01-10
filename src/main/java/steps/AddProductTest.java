package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ItemsPage;

import static core.ChromeFactory.*;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.SeleniumUtils.*;

public class AddProductTest {
    private CartPage cartPage;
    private HomePage homePage;
    private ItemsPage itemsPage;

    @BeforeAll
    public void setUp() {
        setupChrome();
        homePage = new HomePage();
        itemsPage = new ItemsPage();
        cartPage = new CartPage();
    }

    @Given("User navigates to ebay website {string}")
    public void user_navigates_to_ebay_website(String webUrl) {
        openWebpageUrl(webUrl);
    }

    @When("User Searches {string} and clicks on {int} item in the list")
    public void user_searches_and_clicks_on_item_in_the_list(String itemToSearch, int itemNumberToClick) {
        homePage.searchItem(itemToSearch);
        itemsPage.selectItemFromList(itemNumberToClick);
    }

    @And("User adds the item to cart")
    public void user_adds_the_item_to_cart() {
        switchToChildWindow();
        cartPage.addItemToCart();
        switchToParentWindow();
    }

    @Then("Verify that cart has been updated and number of items in the cart are {int}")
    public void verify_that_cart_has_been_updated_and_number_of_items_in_the_cart_are(int expectedItemsInCart) {
        refreshPage();
        assertEquals(cartPage.getItemsInCart(), expectedItemsInCart);
    }

    @AfterAll
    void closeSession() {
        closeChromeSession();
    }

}
