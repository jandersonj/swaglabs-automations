package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class Cart_PO extends Page_PO{

    private @FindBy(xpath = "//*[@id='user-name']") WebElement username_TextField;
    private @FindBy(id = "password") WebElement password_TextField;
    private @FindBy(id = "login-button") WebElement clickLogin_Button;

    private @FindBy(id = "add-to-cart-sauce-labs-backpack") WebElement addSauceLabsBackpack_Button;
    private @FindBy(xpath = "//a[@class='shopping_cart_link']") WebElement clickCart_Button;

    public Cart_PO() {
        super();
    }


    //add product to the cart and validate the product is added
    public void addProductToCart(String productName) {
        //add product to the cart
        addSauceLabsBackpack_Button.click();
    }

    public void goToCart() {
        //go to the cart page
        clickCart_Button.click();
    }

    public void validateProductInCart(String productName) {
        //validate the product is added to the cart
        List<WebElement> productNames = getDriver().findElements(By.xpath("//div[@class='inventory_item_name']"));
        assert !productNames.isEmpty() : "Produto não encontrado no carrinho";
    }

}

