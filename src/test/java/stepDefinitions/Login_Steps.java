package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Login_PO;

public class Login_Steps extends Login_PO {

    private WebDriver driver = getDriver();

    private final Login_PO login_po;

    public Login_Steps(Login_PO loginPo) {
        login_po = loginPo;
    }

    @Given("I access SwagLabs login form")
    public void iAccessSwagLabsLoginForm() {
        login_po.navigateTo_SwagLabForm();
    }

    @When("I enter a valid username {word}")
    public void iEnterAValidUsernameStandard_user(String username) {
        login_po.enter_Username(username);
    }

    @And("I enter a valid password {word}")
    public void iEnterAValidPassword(String password) {
        login_po.enter_Password(password);

    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        login_po.click_Login();
    }



    /*
    Scenario: Login with invalid password
     */



    @And("I enter an invalid password {word}")
    public void iEnterAnInvalidPasswordSecret_sauce(String password) {
        login_po.enter_Password(password);
    }

    @Then("I should be redirected to the products page")
    public void iShouldBeRedirectedToTheProductsPage() {
        login_po.productsPage("https://www.saucedemo.com/inventory.html");
    }

    @Then("I should be presented with a unsuccessful validation message")
    public void iShouldBePresentedWithAUnsuccessfulValidationMessage() {
        String msg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(msg, "Epic sadface: Username and password do not match any user in this service");
        System.out.println(msg);
    }
}
