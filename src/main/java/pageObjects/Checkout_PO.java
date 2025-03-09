package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout_PO extends Page_PO {

    private @FindBy(id = "checkout") WebElement checkout_Button;
    private @FindBy(id = "first-name") WebElement firstName_TextField;
    private @FindBy(id = "last-name") WebElement lastName_TextField;
    private @FindBy(id = "postal-code") WebElement zip_TextField;
    private @FindBy(id = "continue") WebElement continue_Button;
    private @FindBy(id = "finish") WebElement finish_Button;


    public Checkout_PO() {
        super();
    }

    public void clickCheckoutButton() {
        //click on checkout button
        checkout_Button.click();
    }

    public void fillNameLastNameAndZIP(String firstName, String lastName, String zip) {
        //fill the name, last name and ZIP
            firstName_TextField.sendKeys(firstName);
            lastName_TextField.sendKeys(lastName);
            zip_TextField.sendKeys(zip);
    }

    public void clickContinue() {
        //click on continue
        continue_Button.click();
    }

    public void validateCheckoutOverviewPage() throws InterruptedException {
        //esperar a pagina carregar
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        //assert getDriver().getCurrentUrl().contains("checkout-step-two.html") : "Página de checkout step-two não encontrada";
    }

    public void clickFinish() {
        //click on finish
        finish_Button.click();
    }

    public void validateCheckoutCompletePage() {
        //validate the checkout complete page
        assert getDriver().getCurrentUrl().contains("checkout-complete.html") : "Página de checkout não encontrada";
    }

    public void validateCheckoutCompleteMessage(String successMessage) {
        //validate the checkout complete message
        assert getDriver().findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText().contains(successMessage) : "Mensagem de sucesso não encontrada";
        System.out.println(successMessage);
    }
}
