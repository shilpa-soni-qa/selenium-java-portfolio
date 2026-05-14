package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class CartTest extends BaseTest {

    @Test
    public void testAddItemToCart() {
        test = ExtentReportManager.createTest("Add Item To Cart Test");
        test.info("Navigating to SauceDemo");
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);
        test.info("Logging in");
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        test.info("Adding first item to cart");
        inventoryPage.addFirstItemToCart();

        String cartCount = inventoryPage.getCartCount();
        Assert.assertEquals(cartCount, "1", "Cart count should be 1!");
        test.info("Cart count verified: " + cartCount);
        System.out.println("Add to cart test passed! ✅");
    }

    @Test
    public void testRemoveItemFromCart() {
        test = ExtentReportManager.createTest("Remove Item From Cart Test");
        test.info("Navigating to SauceDemo");
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);
        test.info("Logging in");
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        test.info("Adding item to cart");
        inventoryPage.addFirstItemToCart();

        CartPage cartPage = new CartPage(driver);
        test.info("Going to cart");
        cartPage.clickCart();
        test.info("Removing item from cart");
        cartPage.removeFirstItem();

        int itemCount = cartPage.getCartItemCount();
        Assert.assertEquals(itemCount, 0, "Cart should be empty!");
        test.info("Cart verified empty");
        System.out.println("Remove from cart test passed! ✅");
    }
}