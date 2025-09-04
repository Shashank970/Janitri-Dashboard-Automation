package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators (update as per actual DOM)
    private By userIdInput = By.id("email");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By passwordToggle = By.xpath("//button[@aria-label='toggle password visibility']");
    private By errorMsg = By.cssSelector(".MuiAlert-message"); 

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void enterUserId(String userId) {
        driver.findElement(userIdInput).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public void togglePasswordVisibility() {
        driver.findElement(passwordToggle).click();
    }

    public String getPasswordFieldType() {
        return driver.findElement(passwordInput).getAttribute("type");
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
