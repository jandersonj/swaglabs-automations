package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Cart_PO;
import pageObjects.Login_PO;

import java.time.Duration;

public class Cart_Step extends Cart_PO {

    private final Cart_PO cart_po;
    private WebDriver driver;
    private final Login_PO login_po;
    public Cart_Step(Cart_PO cartPo, Login_PO loginPo) {
        cart_po = cartPo;
        login_po = loginPo;
    }


    @Given("I am logged in")
    public void iAmLoggedIn() {
        login_po.navigateTo("https://www.saucedemo.com/");
        login_po.enter_Username("standard_user");
        login_po.enter_Password("secret_sauce");
        login_po.click_Login();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        login_po.productsPage("https://www.saucedemo.com/inventory.html");
    }

    @When("I add product {string} to the cart")
    public void iAddProductSauceLabsBackpackToTheCart(String productName) {

        cart_po.addProductToCart(productName);
    }

    @And("I go to the cart page by clicking on the cart icon")
    public void iGoToTheCartPageByClickingOnTheCartIcon() {

        cart_po.goToCart();
    }

    @Then("I should see product {string} in the cart")
    public void iShouldSeeProductSauceLabsBackpackInTheCart(String productName) {

        cart_po.validateProductInCart(productName);
    }
}
