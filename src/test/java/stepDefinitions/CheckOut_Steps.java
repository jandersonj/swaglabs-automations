package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Cart_PO;
import pageObjects.Checkout_PO;
import pageObjects.Login_PO;

public class CheckOut_Steps extends Checkout_PO {

    private final Cart_PO cart_po;
    private WebDriver driver;
    private final Login_PO login_po;
    private final Checkout_PO checkout_po;

    public CheckOut_Steps(Cart_PO cartPo, Login_PO loginPo, Checkout_PO checkoutPo) {
        cart_po = cartPo;
        login_po = loginPo;
        checkout_po = checkoutPo;
    }

    @Given("i am in login page")
    public void iAmInLoginPage() {
        login_po.navigateTo("https://www.saucedemo.com/");
    }

    @When("log in with user {string} and password {string}")
    public void logInWithUserAndPassword(String username, String password) {
        login_po.enter_Username(username);
        login_po.enter_Password(password);
        login_po.click_Login();

    }

    @Then("i should be redirected to the products page")
    public void iShouldBeRedirectedToTheProductsPage() {
        login_po.productsPage("https://www.saucedemo.com/inventory.html");
    }

    @When("i add product {string} to the cart")
    public void iAddProductToTheCart(String productName) {
        cart_po.addProductToCart(productName);
    }

    @And("i go to the cart page by clicking on the cart icon")
    public void iGoToTheCartPageByClickingOnTheCartIcon() {
        cart_po.goToCart();
    }

    @Then("i should see product {string} in the cart")
    public void iShouldSeeProductInTheCart(String productName) {
        cart_po.validateProductInCart(productName);
    }

    @When("i click on checkout button")
    public void iClickOnCheckoutButton() {
        checkout_po.clickCheckoutButton();
    }

    @Then("i should be redirected to the checkout page")
    public void iShouldBeRedirectedToTheCheckoutPage() throws InterruptedException {
        checkout_po.validateCheckoutOverviewPage();
    }

    @When("i fill the name {string}, last name {string} and ZIP {string}")
    public void iFillTheNameLastNameAndZIP(String firstName, String lastName, String zip) {

        checkout_po.fillNameLastNameAndZIP(firstName, lastName, zip);
    }

    @And("i click on continue")
    public void iClickOnContinue() {
        checkout_po.clickContinue();
    }

    @Then("i should be redirected to the checkout overview page")
    public void iShouldBeRedirectedToTheCheckoutOverviewPage() throws InterruptedException {
        checkout_po.validateCheckoutOverviewPage();
    }

    @When("i click on finish")
    public void iClickOnFinish() {
        checkout_po.clickFinish();
    }

    @Then("i should see the order confirmation page")
    public void iShouldSeeTheOrderConfirmationPage() {
        checkout_po.validateCheckoutCompletePage();
    }

    @And("i should see the message {string}")
    public void iShouldSeeTheMessage(String successMessage) {
        checkout_po.validateCheckoutCompleteMessage(successMessage);
    }
}
