
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.DriverFactory;

public class Hooks {
    @Before
    public void before(Scenario scenario) {
        DriverFactory.start();
    }

    @After
    public void after(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] png = ((TakesScreenshot) DriverFactory.get()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(png, "image/png", "failed");
            }
        } catch (Exception ignored) {}
        DriverFactory.stop();
    }
}
