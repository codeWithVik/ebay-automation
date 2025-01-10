package utilities;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;
import java.util.Set;

import static core.ChromeFactory.driver;
import static core.ChromeFactory.webDriverWait;

public class SeleniumUtils {
    private static String parentWindow = null;

    public static void openWebpageUrl(final String webUrl) {
        driver.navigate().to(webUrl);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void switchToChildWindow() {
        parentWindow = driver.getWindowHandle();

        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String childWindow : windowHandles) {
            if (!childWindow.equals(parentWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    public static void switchToParentWindow() {
        if (!Objects.isNull(parentWindow)) {
            driver.switchTo().window(parentWindow);
        }
    }
}
