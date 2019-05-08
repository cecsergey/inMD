package Pages.ForgotPassword;

import Pages.BasePage;
import Utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    //*********Constructor*********
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        driver.get(Properties.baseURL + "auth/forgot-password/");
    }


    //*********Page Variables*********


    //*********Web Elements*********
    final By emailBy= By.id("email");
    final By submitButtonBy= By.cssSelector("div[class=\"login-content\"] button[type=\"submit\"]");
    final By errorBy= By.cssSelector("div[role=\"alert\"]"); // Error message if invalid username/email specified

    public CheckYourEmailPage validUsername(final String username){
        driver.get(Properties.baseURL + "auth/forgot-password/");
        click(emailBy);
        writeText(emailBy, username);
        click(submitButtonBy);
        return new CheckYourEmailPage(driver);
    }

    public ForgotPasswordPage invalidUsername(final String invalidUsername) {
        driver.get(Properties.baseURL + "auth/forgot-password/");
        click(emailBy);
        writeText(emailBy, invalidUsername);
        click(submitButtonBy);
        return this;
    }

    public ForgotPasswordPage VerifyErrorMessage() {
        assertVisible(errorBy);
        return this;
    }
}
