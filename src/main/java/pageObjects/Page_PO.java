package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Page_PO {

    public Page_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo(String url) {
        getDriver().get(url);
    }

    public void waitForAlert_And_Validate(String text) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertText, text);
    }

    public boolean chekCurrentURL(String url) {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
        return false;
    }
}
