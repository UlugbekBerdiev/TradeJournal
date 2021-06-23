package utils;

import org.junit.Assert;
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
}

