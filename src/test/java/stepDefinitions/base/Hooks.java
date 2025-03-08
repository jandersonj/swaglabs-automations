package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Timestamp;

import static driver.DriverFactory.clearDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {

    public WebDriver driver;


    //@Before("@Login")
    @Before
    public void setup() {

        getDriver();

    }

    // take screenshot after each step
    //advanced reporting
    //adiciona a foto do erro no relatório
    @AfterStep
    public void captureExecutionImage(Scenario scenario) {
        // take screenshot
        if(scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);

            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }
    }

    //@After("@Login")
    @After
    public void tearDown() {
        clearDriver();
    }
}
