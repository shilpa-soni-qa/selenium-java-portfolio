package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class E2ETest extends BaseTest {

    @Test
    public void testCompleteUserJourney() {
        // Step 1 - Navigate to site
        driver.get("https://www.saucedemo.com");
        System.out.println("Step 1: Navigated to SauceDemo ✅");

        // Step 2 - Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("Step 2: Login successful ✅");

        // Step 3 - Verify we're on inventory page
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products",
                "Not on inventory page!");
        System.out.println("Step 3: Products page verified ✅");

        // Step 4 - Add item to cart
        inventoryPage.addFirstItemToCart();
        Assert.assertEquals(inventoryPage.getCartCount(), "1",
                "Cart count should be 1!");
        System.out.println("Step 4: Item added to cart ✅");

        // Step 5 - Go to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 1,
                "Cart should have 1 item!");
        System.out.println("Step 5: Cart verified ✅");

        // Step 6 - Checkout
        cartPage.clickCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails("Shilpa", "Soni", "682001");
        System.out.println("Step 6: Checkout details filled ✅");

        // Step 7 - Finish order
        checkoutPage.clickFinish();
        String confirmation = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your order!",
                "Order confirmation failed!");
        System.out.println("Step 7: Order confirmed ✅");

        System.out.println("\n🎉 Full E2E Test Passed!");
    }
}