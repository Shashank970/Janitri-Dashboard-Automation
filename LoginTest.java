package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage login = new LoginPage(driver);
        Assert.assertFalse(login.isLoginButtonEnabled(),
                "Login button should be disabled when fields are empty");
    }

    @Test
    public void testPasswordMaskedButton() {
        LoginPage login = new LoginPage(driver);
        login.enterPassword("mypassword");
        Assert.assertEquals(login.getPasswordFieldType(), "password");

        login.togglePasswordVisibility();
        Assert.assertEquals(login.getPasswordFieldType(), "text");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        LoginPage login = new LoginPage(driver);
        login.enterUserId("random@test.com");
        login.enterPassword("wrong123");
        login.clickLogin();

        String error = login.getErrorMessage();
        System.out.println("Error message: " + error);
        Assert.assertTrue(error.toLowerCase().contains("invalid") || error.toLowerCase().contains("incorrect"),
                "Expected error message for invalid login");
    }
}
