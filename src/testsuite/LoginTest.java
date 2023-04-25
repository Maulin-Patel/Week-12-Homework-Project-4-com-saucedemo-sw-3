package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before // JUnit Annotation which will run before every method

    public void setUp() { // calling openBrowser method using baseUrl value
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // Enter password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        // Click on Login
        clickOnElement(By.xpath("//input[@type='submit']"));
        // Verify actual and expected text
        verifyTextDisplayed(By.xpath("//span[contains(text(),'Products')]"), "Products");
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // Enter password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        // Click on Login
        clickOnElement(By.xpath("//input[@type='submit']"));
        // Verify number of products displayed
        verifyNumberFromElement(By.className("inventory_item"), 6);
    }

    @After // JUnit Annotation which will run after every method
    public void tearDown() {
        closeBrowser();
    }
}
