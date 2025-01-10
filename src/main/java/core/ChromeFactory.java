package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.constants.TEN_SECONDS;

public class ChromeFactory {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void setupChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(TEN_SECONDS));
    }

    public static void closeChromeSession() {
        driver.close();
    }
}