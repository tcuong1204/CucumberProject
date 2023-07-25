package tma.sharing.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class ElementHandler extends BrowserHandler {

    public static void enterText(String xPathLocator, String text) {
        findAndWaiElement(xPathLocator).sendKeys(text);
    }

    public static void clickButton(String xPathLocator) {
        findAndWaiElement(xPathLocator).click();
    }

    public static boolean elementIsDisplayed(String xPathLocator) {
        return findAndWaiElement(xPathLocator).isDisplayed();
    }

    public static String getDisplayText(String xPathLocator) {
        return findAndWaiElement(xPathLocator).getText();
    }

    public static WebElement findAndWaiElement(String xPathLocator) {
        WebElement element = null;
        Properties properties = PropertiesHandler.loadApplicationProperties();
        int timeout = Integer.parseInt(properties.getProperty("timeout.maximum"));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xPathLocator))));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return element;

    }

}
