
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement $(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        $(locator).click();
    }
    protected void type(By locator, String text) {
        WebElement el = $(locator);
        el.clear();
        el.sendKeys(text);
    }
    protected String text(By locator) {
        return $(locator).getText();
    }

    public String getProperties(String key){
        Properties property=new Properties();
        try (InputStream input = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\config\\config.properties")) {
            property.load(input);
            return property.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error loading configuration file: ");
        }
    }
}
