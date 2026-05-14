package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;

    // Locators
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By confirmationMessage = By.className("complete-header");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions
                .visibilityOfElementLocated(finishButton));
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    public void fillCheckoutDetails(String firstName, String lastName, String zipCode) {
        try {
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            // no alert present, continue
        }

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions
                .visibilityOfElementLocated(firstNameField));
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
        clickContinue();
    }
}

//confirmationMessage = By.className("complete-header")
//This locates the "Thank you for your order!" message on the confirmation page. We'll use this to verify the order was placed successfully.
//getConfirmationMessage()
//Returns the text of the confirmation message. We'll compare this in our test to verify checkout worked.
//fillCheckoutDetails()
//Notice this method calls 3 other methods inside it — enterFirstName, enterLastName, enterZipCode. This is called a helper method — it groups multiple actions into one clean call. Makes tests shorter and readable.