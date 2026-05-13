package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void testAddItemToCart() {
        driver.get("https://www.saucedemo.com");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();

        // Verify cart count
        String cartCount = inventoryPage.getCartCount();
        Assert.assertEquals(cartCount, "1", "Cart count should be 1!");
        System.out.println("Add to cart test passed! ✅");
    }

    @Test
    public void testRemoveItemFromCart() {
        driver.get("https://www.saucedemo.com");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add item then go to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();

        // Go to cart and remove item
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();
        cartPage.removeFirstItem();

        // Verify cart is empty
        int itemCount = cartPage.getCartItemCount();
        Assert.assertEquals(itemCount, 0, "Cart should be empty!");
        System.out.println("Remove from cart test passed! ✅");
    }
}