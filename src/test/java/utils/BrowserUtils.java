package utils;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     *
     * */
    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            Assert.assertFalse(element.isDisplayed());
                   } catch (NoSuchElementException e) {
            Assert.assertFalse(false);

        }
    }
    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) { return false; }
    }
    public static void switchToNewWindow(){
        // Switch to new window opened
        for(String winHandle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(winHandle);
        }}
    public static void switchBackToOriginWindow(String originWindow) {
        // Close the new window, if that window no more required
        Driver.getDriver().close();
        // Switch back to original browser (first window)
        Driver.getDriver().switchTo().window( originWindow );

    }
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
}

