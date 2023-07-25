package tma.sharing.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;


public class BrowserHandler {

    public static WebDriver driver;

    public void initBrowser() {
        Properties properties = PropertiesHandler.loadApplicationProperties();
        String url = properties.getProperty("application.url");
        String browser = properties.getProperty("browser.default");

        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> System.out.println("Browser is not supported");
        }

        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    public void closeBrowser() {
        driver.close();
    }

}
