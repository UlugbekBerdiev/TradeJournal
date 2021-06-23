package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;

public class DeleteSteps {
	
	HomePage page = new HomePage();
	BrowserUtils utils = new BrowserUtils();
	LoginPage logInPage = new LoginPage();

	
	@Given("That user is on login page")
	public void that_user_is_on_login_page() {
	    Driver.getDriver().get("http://ec2-3-142-242-205.us-east-2.compute.amazonaws.com:8080/");
	}

	@Given("the user enters valid username {string} and password {string} and clicks SignIn")
	public void the_user_enters_valid_username_and_password_and_clicks_sign_in(String username, String password) {
		logInPage.usernameInputBox.sendKeys(username);
	    logInPage.passwordInputBox.sendKeys(password);
	    logInPage.signInButton.click();

	}

	@Then("verify user is on the home page")
	public void verify_user_is_on_the_home_page() {
		utils.waitUntilElementVisible(page.tableView);
		Assert.assertTrue(page.tableView.isDisplayed());
	}

	@When("the user clicks on the delete button")
	public void the_user_clicks_on_the_delete_button() {
	    page.deleteButton.click();
	}

	@Then("a pop-up modal should appear with the text: Are you sure you want to delete this record?")
	public void a_pop_up_modal_should_appear_with_the_text_are_you_sure_you_want_to_delete_this_record() {
		utils.waitUntilAlertIsPresent();
	}

	@When("the user clicks on Ok button")
	public void the_user_clicks_on_ok_button() {
		utils.switchToAlert();
	    utils.alertAccept();
	}

	@Then("the modal should close and the system should delete that particular stock from the table view")
	public void the_modal_should_close_and_the_system_should_delete_that_particular_stock_from_the_table_view() {
		Assert.assertTrue(page.tableView.isDisplayed());
	}

	// Clicking Cancel button to return to home page without any deletion
	@When("the user clicks on Cancel button")
	public void the_user_clicks_on_cancel_button() {
	    utils.switchToAlert();
	    utils.alertDismiss();
	}

	@Then("the modal should close without anything been deleted")
	public void the_modal_should_close_without_anything_been_deleted() {
		Assert.assertTrue(page.tableView.isDisplayed());
	}


}
