package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddTradePage;
import pages.HomePage;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.PropertiesReader;



public class Add_Trade_Definition {

	AddTradePage addTradePage = new AddTradePage();

    BrowserUtils utils = new BrowserUtils();

    String inputSymbol;


    @Given("I am on the app sign in page")
	public void i_am_on_the_app_sign_in_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("url"));
	    utils.waitUntilElementVisible(addTradePage.username);
	    Assert.assertTrue(addTradePage.username.isDisplayed());

	}
	@When("I enter valid username {string} and password {string}")
	public void i_enter_valid_username_and_password(String username, String password) {
		addTradePage.username.sendKeys(username);
		addTradePage.password.sendKeys(password);

	}
	@When("I click on trade sign in button")
	public void i_click_on_trade_sign_in_button() {
		addTradePage.signinBtn.click();

	}
	@Then("I should be in the trade homepage")
	public void i_should_be_in_the_trade_homepage() {
		utils.waitUntilElementVisible(addTradePage.addTradeBtn);
		Assert.assertTrue(addTradePage.addTradeBtn.isDisplayed());

	}
	@When("I click on Add Trade button")
	public void i_click_on_add_trade_button() {
	    addTradePage.addTradeBtn.click();

	}
	@Then("I should be on Save Trade Form")
	public void i_should_be_on_save_trade_form() {
	   utils.waitUntilElementVisible(addTradePage.buyOrSellDropdown);
	   Assert.assertTrue(addTradePage.buyOrSellDropdown.isDisplayed());

	}
	@When("I enter following new trade details")
	public void i_enter_following_trade_details(DataTable dataTable) {

		List<String> list = dataTable.asList();
		inputSymbol = list.get(1);

		   utils.selectByVisibleText(addTradePage.buyOrSellDropdown, list.get(0));
		   addTradePage.tradeSymbol.sendKeys(list.get(1));
		   addTradePage.entryDate.sendKeys(list.get(2));
		   addTradePage.entryPrice.sendKeys(list.get(3));
		   addTradePage.exitDate.sendKeys(list.get(4));
		   addTradePage.exitPrice.sendKeys(list.get(5));

	}
	@When("I click save button")
	public void i_click_save_button() throws InterruptedException {
	    addTradePage.tradeSaveBtn.click();
	    Thread.sleep(3000);

	}
	@Then("the trade is displayed in the trade table")
	public void the_trade_is_displayed_in_the_trade_table() {
		utils.waitUntilElementVisible(addTradePage.anyRowStockSymbol.get(0));

		   for ( WebElement element : addTradePage.anyRowStockSymbol) {
			   String actualStockSymbol = element.getText();
			   boolean flag = false;
			   if (actualStockSymbol.equals(inputSymbol)) {
				   flag = true;
				   Assert.assertTrue(flag);
				   break;
	}
		   }
		   }


} 