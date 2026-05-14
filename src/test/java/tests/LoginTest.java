package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        test = ExtentReportManager.createTest("Successful Login Test");
        test.info("Navigating to SauceDemo");
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);
        test.info("Entering credentials");
        loginPage.login("standard_user", "secret_sauce");

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL, "Login failed!");
        test.info("Login verified successfully");
        System.out.println("Login test passed! ✅");
    }
}