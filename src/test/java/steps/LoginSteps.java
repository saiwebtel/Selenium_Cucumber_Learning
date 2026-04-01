
package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.DashboardPage;
import pages.LoginPage;
import support.DriverFactory;

public class LoginSteps {
    private LoginPage login() {
        return new LoginPage(DriverFactory.get());
    }
    private DashboardPage dashboard() {
        return new DashboardPage(DriverFactory.get());
    }

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        login().open();
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_user_and_pass(String user, String pass){
        login().login(user, pass);
    }

    @Then("I should see the dashboard")
    public void i_should_see_the_dashboard() {
        dashboard().assertLoaded();
    }

    @Then("I should see an error message containing {string}")
    public void i_should_see_error(String msg) {
        Assertions.assertTrue(login().flashMessage().toLowerCase().contains(msg.toLowerCase()));
    }
}
