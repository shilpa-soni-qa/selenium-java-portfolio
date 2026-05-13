package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    // Locators
    By cartIcon = By.className("shopping_cart_link");//By.className("shopping_cart_link")Finds element using its CSS class name. Same as By.id() but uses class instead of id.
    By cartItems = By.className("cart_item");//
    By removeButton = By.xpath("//button[contains(text(),'Remove')]");//By.xpath("//button[contains(text(),'Remove')]")XPath is like a search path through the page. This one says:"Find any button whose text contains the word 'Remove'"This is useful when there's no id or class available.
    By checkoutButton = By.id("checkout");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickCart() {
        driver.findElement(cartIcon).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void removeFirstItem() {
        driver.findElement(removeButton).click();
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
        //driver.findElements(cartItems).size() - Notice findElements — plural. This finds all matching elements and returns a list. .size() counts how many. So this counts how many items are in the cart.
    }
}