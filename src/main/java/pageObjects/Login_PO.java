package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login_PO extends Page_PO {

    private @FindBy(id = "user-name") WebElement username_TextField;
    private @FindBy(id = "password") WebElement password_TextField;
    private @FindBy(id = "login-button") WebElement clickLogin_Button;


    public Login_PO() {
        super();
    }

    public void navigateTo_SwagLabForm() {
        navigateTo("https://www.saucedemo.com/");
    }

    public void enter_Username(String username) {
        username_TextField.sendKeys(username);
    }

    public void enter_Password(String password) {
        password_TextField.sendKeys(password);
    }

    public void click_Login() {
        clickLogin_Button.click();
    }

    public void productsPage(String url) {
        chekCurrentURL(url);
    }

}
























