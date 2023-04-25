package browserfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        // Maximise Window
        driver.manage().window().maximize();
        //Implicit Time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void sendTextToElement(By by, String text) {
        //find the element to enter text into
        driver.findElement(by).sendKeys(text);
    }
    /**
     * This method will get text from element and check whether it is displayed or not.
     */
    public boolean verifyTextDisplayed(By by, String expectedText){
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : "Text is not found: " + expectedText;
        return true;
    }

    /**
     * This method will get number from element and check
     * whether it is displayed or not.
     */
    public boolean verifyNumberFromElement(By by,int expectedNumber){
        int actualNumber = driver.findElements(by).size();
        assert actualNumber == expectedNumber : "Expected Number of items not displayed: " + expectedNumber;
        return true;
    }
    /*
    Click on element method
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
}

