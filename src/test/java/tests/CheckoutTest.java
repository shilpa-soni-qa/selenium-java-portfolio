package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    public void testSuccessfulCheckout() {
        driver.get("https://www.saucedemo.com");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();

        // Go to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();

        // Checkout
        cartPage.clickCheckout();

        // Fill checkout details
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails("Shilpa", "Soni", "682001");

        // Finish order
        checkoutPage.clickFinish();

        // Verify confirmation
        String confirmationMessage = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!",
                "Order confirmation failed!");
        System.out.println("Checkout test passed! ✅");
    }
}