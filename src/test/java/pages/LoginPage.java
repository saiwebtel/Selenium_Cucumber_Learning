
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final String baseUrl = getProperties("url");
    private final By user = By.id("username");
    private final By pass = By.id("password");
    private final By submit = By.cssSelector("button[type='submit']");
    private final By flash = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/login");
    }

    public void login(String u, String p) {
        type(user, u);
        type(pass, p);
        click(submit);
    }

    public String flashMessage() {
        return text(flash);
    }
}
