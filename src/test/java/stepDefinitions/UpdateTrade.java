package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import pages.AddTradePage;
import pages.HomePage;


public class UpdateTrade {
	HomePage homePage = new HomePage();
	AddTradePage updateTrade = new AddTradePage();

	@When("user clicks on update")
	public void user_clicks_on_update() {
	   homePage.updatebtn.get(0).click();
	}

	@Then("user should see trade update form")
	public void user_should_see_trade_update_form() {
	    Assert.assertTrue(updateTrade.saveTradeLogo.isDisplayed());
	}

	// | Sell to Open | APPL | 06122021 | 150.0 | 06222021 | 250.0 |
	@When("user enters the following trade details")
	public void user_enters_the_following_trade_details() {
	   Select select = new Select(updateTrade.buyOrSellDropdown);
	   select.selectByIndex(0);
	   updateTrade.tradeSymbol.sendKeys("APPL");
	   updateTrade.entryDate.sendKeys("06222021");
	   updateTrade.entryPrice.sendKeys("150.0");
	   updateTrade.exitDate.sendKeys("06252021");
	   updateTrade.exitPrice.sendKeys("250.0");
	}

	@When("user clicks on save")
	public void user_clicks_on_save() {
		updateTrade.tradeSaveBtn.click();
	}

	@Then("the update is displayed in the trade table")
	public void the_update_is_displayed_in_the_trade_table() {
	    Assert.assertTrue(homePage.addTradeButton.isDisplayed());
	}

}