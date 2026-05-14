package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class E2ETest extends BaseTest {

    @Test
    public void testCompleteUserJourney() {
        test = ExtentReportManager.createTest("Complete E2E User Journey Test");

        test.info("Step 1: Navigating to SauceDemo");
        driver.get("https://www.saucedemo.com");

        test.info("Step 2: Logging in");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        test.info("Step 3: Verifying products page");
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products",
                "Not on inventory page!");

        test.info("Step 4: Adding item to cart");
        inventoryPage.addFirstItemToCart();
        Assert.assertEquals(inventoryPage.getCartCount(), "1",
                "Cart count should be 1!");

        test.info("Step 5: Verifying cart");
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 1,
                "Cart should have 1 item!");

        test.info("Step 6: Filling checkout details");
        cartPage.clickCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails("Shilpa", "Soni", "682001");

        test.info("Step 7: Confirming order");
        checkoutPage.clickFinish();
        String confirmation = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your order!",
                "Order confirmation failed!");

        test.info("🎉 Full E2E Test Passed!");
        System.out.println("\n🎉 Full E2E Test Passed!");
    }
}