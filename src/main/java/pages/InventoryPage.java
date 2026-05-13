package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    // Locators
    By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    By cartBadge = By.className("shopping_cart_badge");
    By pageTitle = By.className("title");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void addFirstItemToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    //By.xpath("//button[contains(text(),'Add to cart')]")
    //Finds the first "Add to cart" button on the page.cartBadge
    //That's the little red number on the cart icon showing how many items are in cart. We're grabbing its text to verify count..getText()
    //Gets the visible text of an element. We use this to read what's on screen and verify it in our tests.
}