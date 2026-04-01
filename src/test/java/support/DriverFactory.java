
package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.BasePage;

import java.time.Duration;

import static java.lang.System.getProperty;

public class DriverFactory{
    private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();

    public static void start() {
        String browser = System.getProperty("browser",getProperty("browser"));
        boolean headless = Boolean.parseBoolean(getProperty("headless", "false"));
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new", "--window-size=1920,1080");
                TL.set(new ChromeDriver(options));
            }
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) options.addArguments("-headless");
                TL.set(new FirefoxDriver(options));
            }
            default -> throw new IllegalArgumentException("Unsupported browser: ");
        }
        TL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    public static WebDriver get() { return TL.get(); }

    public static void stop() {
        if (TL.get() != null) {
            TL.get().quit();
            TL.remove();
        }
    }
}
