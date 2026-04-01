
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    private final By logout = By.cssSelector("a.button.secondary.radius");
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void assertLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
    }
}
