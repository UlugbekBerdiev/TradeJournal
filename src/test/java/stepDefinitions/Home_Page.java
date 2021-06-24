package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AdditionalPages;
import pages.HomePage;
import utils.BrowserUtils;
import utils.Driver;

public class Home_Page {
    HomePage homepage = new HomePage();
AdditionalPages titles = new AdditionalPages();


// User click logo and should be able to be directed to the home page
    @Then("Logo is displayed")
    public void logo_is_displayed() {
Assert.assertTrue(homepage.logo.isDisplayed());
    }
    @When("User clicks on logo")
    public void user_clicks_on_logo() {
        homepage.logo.click();
    }
    @Then("User should be able to be directed to the home page")
    public void user_should_be_able_to_be_directed_to_the_home_page() {
        Assert.assertEquals(homepage.pageTitle, Driver.getDriver().getTitle());
    }


//User click home tab and should be able to be directed to the home page
    @Then("home tab is displayed")
    public void home_tab_is_displayed() {
Assert.assertTrue(homepage.labelHome.isDisplayed());
    }
    @When("User clicks on home tab")
    public void user_clicks_on_home_tab() {
homepage.labelHome.click();
    }



//User click finom tab and should be able to navigate to Finom Group website
    @Then("Finom Group tab is displayed")
    public void finom_group_tab_is_displayed() {
Assert.assertTrue(homepage.finomGroupTab.isDisplayed());
    }
    @When("User click on Finom Group tab")
    public void user_click_on_finom_group_tab() {
        homepage.finomGroupTab.click();
    }
    @Then("User should be able to navigate to Finom Group website")
    public void user_should_be_able_to_navigate_to_finom_group_website() {
        // Store the current window handle
        String originWindow = Driver.getDriver().getWindowHandle();
        BrowserUtils.switchToNewWindow();
        Assert.assertEquals(titles.finomLink, Driver.getDriver().getCurrentUrl());
        BrowserUtils.switchBackToOriginWindow(originWindow);
    }



//User click Slack tab and should be able to navigate to Slack Channel
    @Then("Slack Channel tab is displayed")
    public void slack_channel_tab_is_displayed() {
Assert.assertTrue(homepage.slackChannelTab.isDisplayed());
    }
    @When("User click on Slack Channel tab")
    public void user_click_on_slack_channel_tab() {
        homepage.slackChannelTab.click();
    }
    @Then("User should be able to navigate to PrimeTech_SDET_Batch1 slack channel")
    public void user_should_be_able_to_navigate_to_prime_tech_sdet_batch1_slack_channel() {
        // Store the current window handle
        String originWindow = Driver.getDriver().getWindowHandle();
        BrowserUtils.switchToNewWindow();
        Assert.assertTrue(homepage.slackChannelLogo.isDisplayed());
        BrowserUtils.switchBackToOriginWindow(originWindow);
    }



//User click Tools tab and calculator tab and should be able to navigate to calculator website
    @Then("Tools tab is displayed")
    public void tools_tab_is_displayed() {
Assert.assertTrue(homepage.toolsTab.isDisplayed());
    }
     @When("User click on Tools tab")
     public void user_click_on_tools_tab(){
        homepage.toolsTab.click();
     }
    @Then("User should see Tools dropdown window")
    public void user_should_see_tools_dropdown_window() {
        BrowserUtils.wait(4);
Assert.assertTrue(homepage.toolsDropDown.isDisplayed());
    }
    @Then("User click on Options Calculator tab")
    public void user_click_on_options_calculator_tab() {
homepage.calculatorTab.click();
    }
    @Then("User should be able to navigate to Options Calculator page")
    public void user_should_be_able_to_navigate_to_options_calculator_page() {
        String originWindow = Driver.getDriver().getWindowHandle();
        BrowserUtils.switchToNewWindow();
        Assert.assertEquals(titles.calculatorLink, Driver.getDriver().getCurrentUrl());
        BrowserUtils.switchBackToOriginWindow(originWindow);
    }

    //User click Tools tab should be able to navigate to finviz website
    @When("User clicks on Todays Market info tab")
    public void user_clicks_on_todays_market_info_tab() {
        BrowserUtils.wait(4);
        homepage.toolsTab.click();
        BrowserUtils.wait(4);
BrowserUtils.clickWithJS(homepage.todaysMarketTab);

    }
    @Then("User should be able to navigate to Finviz website")
    public void user_should_be_able_to_navigate_to_finviz_website() {
        String originWindow = Driver.getDriver().getWindowHandle();
        BrowserUtils.switchToNewWindow();
        Assert.assertEquals(titles.finvizLink, Driver.getDriver().getCurrentUrl());
        BrowserUtils.switchBackToOriginWindow(originWindow);
    }
//User click Tools tab should be able to navigate to converter website
    @And("User click on Vol ETF\\/ETN Price converter tab")
    public void user_click_on_vol_etf_etn_price_converter_tab() {

    }
    @Then("User should be able to navigate to Vol ETF\\/ETN Price converter page")
    public void user_should_be_able_to_navigate_to_vol_etf_etn_price_converter_page() {

//bug
    }
// User should be able to see Symbol search box
    @Then("Symbol search box is displayed")
    public void symbol_search_box_is_displayed() {
Assert.assertTrue(homepage.symbolInput.isDisplayed());
    }
//User should be able to see textbox mm/dd/yyyy
    @Then("textbox mm\\/dd\\/yyyy and calender date picker is displayed")
    public void textbox_mm_dd_yyyy_and_calender_date_picker_is_displayed() {
        Assert.assertTrue(homepage.dateInput.isDisplayed());
    }
//User should be able to see Search button
    @Then("Search button is displayed")
    public void search_button_is_displayed() {
        Assert.assertTrue(homepage.searchButton.isDisplayed());
    }
//User should be able to see Logout button
    @Then("Logout button is displayed")
    public void logout_button_is_displayed() {
        Assert.assertTrue(homepage.logoutButton.isDisplayed());
    }
//User should be able to see Add trade button
    @Then("Add trade button is displayed")
    public void add_trade_button_is_displayed() {
        Assert.assertTrue(homepage.addTradeButton.isDisplayed());
    }
//User should be able to see names of each column on table
    @Then("User should see able to all data table column names")
    public void user_should_see_able_to_all_data_table_column_names() {
Assert.assertEquals(homepage.actionCol.getText(), "Action");
        Assert.assertEquals(homepage.symbolCol.getText(), "Symbol");
        Assert.assertEquals(homepage.openDateCol.getText(), "Open date");
        Assert.assertEquals(homepage.entryCol.getText(), "Entry");
        Assert.assertEquals(homepage.closeDateCol.getText(), "Close date");
        Assert.assertEquals(homepage.exitCol.getText(), "Exit");
        Assert.assertEquals(homepage.gainLossCol.getText(), "Gain/Loss");
        Assert.assertEquals(homepage.action2Col.getText(), "Action");
    }
}
