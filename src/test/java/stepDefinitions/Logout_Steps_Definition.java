package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LogOutPage;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;

public class Logout_Steps_Definition {
    HomePage homePage = new HomePage();
    LogOutPage logOutPage = new LogOutPage();
    LoginPage loginPage = new LoginPage();

    @When("User clicks on LogOut button")
    public void user_clicks_on_log_out_button() {
        homePage.signOutButton.click();
        BrowserUtils.wait(1);
    }
    @Then("User should be directed on LogOut confirmation page")
    public void user_should_be_directed_on_log_out_confirmation_page() {
        BrowserUtils.wait(1);
        Assert.assertEquals(logOutPage.LogOutConfirmationPageTitle, Driver.getDriver().getTitle());
    }
    @Then("User should see header {string}")
    public void user_should_see_header(String header) {
        BrowserUtils.wait(1);
       Assert.assertEquals(header,logOutPage.confirmLogoutText.getText());
    }

    @Then("User should be directed to Log In page")
    public void user_should_be_directed_to_log_in_page() {
        BrowserUtils.wait(1);
        Assert.assertEquals(loginPage.pageTitle,Driver.getDriver().getTitle());
    }
    @When("User clicks on LogOut Confirmation button")
    public void user_clicks_on_log_out_confirmation_button() {
       logOutPage.logoutConfirmationButton.click();
    }
    @Then("User should see message {string}")
    public void user_should_see_message(String message) {
        Assert.assertEquals(message,loginPage.logoutSuccessfulMessage.getText());
    }

    @When("User click navigate back and refreshes page")
    public void user_click_navigate_back_and_refreshes_page() {
       Driver.getDriver().navigate().back();
       BrowserUtils.wait(1);
       Driver.getDriver().navigate().refresh();
       BrowserUtils.wait(1);
    }
}