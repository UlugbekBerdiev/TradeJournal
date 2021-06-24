package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;
import utils.PropertiesReader;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void before() {
        Driver.getDriver().get(PropertiesReader.getProperty("url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }
    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot)
                        Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }
            Driver.quitDriver();
        }
}
