package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class CheckoutTest extends BaseTest {

    @Test
    public void testSuccessfulCheckout() {
        test = ExtentReportManager.createTest("Successful Checkout Test");
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
        test.info("Clicking checkout");
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        test.info("Filling checkout details");
        checkoutPage.fillCheckoutDetails("Shilpa", "Soni", "682001");
        test.info("Clicking finish");
        checkoutPage.clickFinish();

        String confirmationMessage = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!",
                "Order confirmation failed!");
        test.info("Order confirmed: " + confirmationMessage);
        System.out.println("Checkout test passed! ✅");
    }
}